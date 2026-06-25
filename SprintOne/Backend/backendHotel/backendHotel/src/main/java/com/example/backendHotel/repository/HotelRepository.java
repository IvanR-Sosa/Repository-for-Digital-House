package com.example.backendHotel.repository;

import com.example.backendHotel.entities.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel,Long> {

    List<Hotel> findHotelByRoute(String route);
}
