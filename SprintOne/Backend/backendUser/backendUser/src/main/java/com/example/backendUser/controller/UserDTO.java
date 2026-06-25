package com.example.backendUser.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @NotBlank(message = "Name is Required")
    private String name;
    @NotBlank(message = "DNI is required")
    private String dni;
}
