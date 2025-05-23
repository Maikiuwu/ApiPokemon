package com.pokemon.guess.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthRequest {
    @Email
    private String correo;

    @NotBlank
    private String password;

    // Getters y setters
}
