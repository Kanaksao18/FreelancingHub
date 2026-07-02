package com.kanak.freelancing.auth.service.implement;

import com.kanak.freelancing.auth.dto.request.RegisterRequest;
import com.kanak.freelancing.auth.dto.response.AuthResponse;
import com.kanak.freelancing.auth.service.interfaces.AuthService;
import com.kanak.freelancing.entity.User;
import com.kanak.freelancing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest){

        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .enabled(true)
                .emailVerified(false)
                .build();
        userRepository.save(user);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage("Register successful");
        authResponse.setEmail(user.getEmail());
        authResponse.setRole(user.getRole().name());
        return authResponse;
    }
}
