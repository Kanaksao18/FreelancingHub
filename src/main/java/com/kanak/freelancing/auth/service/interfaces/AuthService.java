package com.kanak.freelancing.auth.service.interfaces;

import com.kanak.freelancing.auth.dto.request.RegisterRequest;
import com.kanak.freelancing.auth.dto.response.AuthResponse;
import org.springframework.stereotype.Service;


public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
}
