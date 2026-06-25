package com.example.backendHotel.persistence;

import com.example.backendHotel.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelDAO {
    List<Hotel> findAll();
    Optional<Hotel> findById(long id);
    List<Hotel> findHotelByRoute(String route);
    void save (Hotel hotel);
    void deleteById(long id);
}
