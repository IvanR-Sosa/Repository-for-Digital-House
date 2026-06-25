package com.example.backendHotel.persistence.impl;

import com.example.backendHotel.entities.Hotel;
import com.example.backendHotel.persistence.IHotelDAO;
import com.example.backendHotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HotelDAOImpl implements IHotelDAO {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> findAll() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public List<Hotel> findHotelByRoute(String route){
        return hotelRepository.findHotelByRoute(route);
    }

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteById(long id) {
        hotelRepository.deleteById(id);
    }
}
