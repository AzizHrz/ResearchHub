package com.groupeAziz.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "CIN is required")
    private String cin;

    @NotBlank(message = "Password is required")
    private String password;
}
