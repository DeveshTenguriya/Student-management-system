package com.example.Student.management.system.Services;

import com.example.Student.management.system.Repository.UserRepository;
import com.example.Student.management.system.dto.UserRegisterRequest;
import com.example.Student.management.system.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserAuthService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void register(UserRegisterRequest request){

        if (userRepository.findByusername(request.getUsername()).isPresent()){
            throw new RuntimeException("Username is already in use");
        }

        User user = new User();
        user.setUsername(request.getUsername());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

}
