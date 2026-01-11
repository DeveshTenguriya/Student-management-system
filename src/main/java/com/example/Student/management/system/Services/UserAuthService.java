package com.example.Student.management.system.Services;

import com.example.Student.management.system.Repository.UserRepository;
import com.example.Student.management.system.Security.JwtService;
import com.example.Student.management.system.Security.UserDetailsServiceImpl;
import com.example.Student.management.system.dto.UserRegisterRequest;
import com.example.Student.management.system.entity.Role;
import com.example.Student.management.system.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public UserAuthService(PasswordEncoder passwordEncoder, UserRepository userRepository, JwtService jwtService, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    public String register(UserRegisterRequest request){

        if (userRepository.findByusername(request.getUsername()).isPresent()){
            throw new RuntimeException("Username is already in use");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        // 2️⃣ Load UserDetails (for JWT)
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(user.getUsername());

        return jwtService.generateToken(userDetails);
    }

}
