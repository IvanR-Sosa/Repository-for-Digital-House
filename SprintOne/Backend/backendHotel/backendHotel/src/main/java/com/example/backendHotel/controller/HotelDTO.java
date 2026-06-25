package com.example.backendHotel.controller;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {

    private Long id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "required a Manager")
    private String nameManager;
    @Min(value = 1, message = "Debe tener al menos 1 habitación")
    private int numRooms;
    private boolean hasAParking;
    private boolean hasARestaurant;
    @NotBlank(message = "Required route")
    private String route;
}
