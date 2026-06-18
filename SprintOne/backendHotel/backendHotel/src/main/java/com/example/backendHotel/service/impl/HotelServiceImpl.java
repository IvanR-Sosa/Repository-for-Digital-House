package com.example.backendHotel.service.impl;

import com.example.backendHotel.entities.Hotel;
import com.example.backendHotel.persistence.IHotelDAO;
import com.example.backendHotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {
    @Autowired
    private IHotelDAO hotelDAO;
    @Override
    public List<Hotel> findAll() {
        return hotelDAO.findAll();
    }

    @Override
    public Optional<Hotel> findById(long id) {
        return hotelDAO.findById(id);
    }

    @Override
    public List<Hotel> findHotelByRoute(String route) {
        return hotelDAO.findHotelByRoute(route);
    }

    @Override
    public void save(Hotel hotel) {
        hotelDAO.save(hotel);
    }

    @Override
    public void deleteById(long id) {
        hotelDAO.deleteById(id);
    }
}
