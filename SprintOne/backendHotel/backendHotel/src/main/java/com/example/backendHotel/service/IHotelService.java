package com.example.backendHotel.service;

import com.example.backendHotel.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(long id);
    List<Hotel> findHotelByRoute(String route);
    void save (Hotel hotel);
    void deleteById(long id);
}
