package com.example.Student.management.system.Controller;

import com.example.Student.management.system.Security.JwtService;
import com.example.Student.management.system.Services.UserAuthService;
import com.example.Student.management.system.dto.UserAuthResponse;
import com.example.Student.management.system.dto.UserLoginRequest;
import com.example.Student.management.system.dto.UserRegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserAuthService userAuthService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserAuthService userAuthService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userAuthService = userAuthService;
    }

    @PostMapping(path = {"/login"})
    public String login(@RequestBody @Valid UserLoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getUsername()));

        UserDetails userDetails= new
                org.springframework.security.core.userdetails.User(
                        request.getUsername(), "", List.of());

        return jwtService.generateToken(userDetails);

    }


    @PostMapping(path = "/register")
    public ResponseEntity<UserAuthResponse> register(@RequestBody @Valid UserRegisterRequest request){
      String token = userAuthService.register(request);
       return ResponseEntity.ok(new UserAuthResponse(token));

    }

}
