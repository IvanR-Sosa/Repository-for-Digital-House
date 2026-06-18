package com.example.backendHotel.entities;


import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nameManager;
    private int numRooms;
    private boolean hasAParking;
    private boolean hasARestaurant;
    private String route;
}
