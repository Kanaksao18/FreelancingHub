package com.kanak.freelancing.auth.dto.request;


import com.kanak.freelancing.entity.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    @NotNull
    private Role role;
}
