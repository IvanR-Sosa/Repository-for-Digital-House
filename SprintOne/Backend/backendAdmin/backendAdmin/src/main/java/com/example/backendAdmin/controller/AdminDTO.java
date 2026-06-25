package com.example.backendAdmin.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {

    private Long id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "dni is required")
    private String dni;
    @NotBlank(message = "password is required")
    private String password;
}
