package com.kanak.freelancing.auth.dto.response;

import com.kanak.freelancing.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String message;
    private String email;
    private String role;
}
