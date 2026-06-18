package com.example.backendHotel.controller;


import com.example.backendHotel.entities.Hotel;
import com.example.backendHotel.service.IHotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<HotelDTO> hotelDTOList = hotelService.findAll()
                .stream()
                .map(hotel -> HotelDTO.builder()
                        .id(hotel.getId())
                        .name(hotel.getName())
                        .nameManager(hotel.getNameManager())
                        .numRooms(hotel.getNumRooms())
                        .hasAParking(hotel.isHasAParking())
                        .hasARestaurant(hotel.isHasARestaurant())
                        .route(hotel.getRoute())
                        .build())
                .toList();
        return ResponseEntity.ok(hotelDTOList);

    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Hotel> hotelOptional = hotelService.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            HotelDTO hotelDTO = HotelDTO.builder()
                    .id(hotel.getId())
                    .name(hotel.getName())
                    .nameManager(hotel.getNameManager())
                    .numRooms(hotel.getNumRooms())
                    .hasAParking(hotel.isHasAParking())
                    .hasARestaurant(hotel.isHasARestaurant())
                    .route(hotel.getRoute())
                    .build();
            return ResponseEntity.ok(hotelDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody HotelDTO hotelDto) {
        Hotel hotel = Hotel.builder()
                .name(hotelDto.getName())
                .nameManager(hotelDto.getNameManager())
                .numRooms(hotelDto.getNumRooms())
                .hasAParking(hotelDto.isHasAParking())
                .hasARestaurant(hotelDto.isHasARestaurant())
                .route(hotelDto.getRoute()).
                build();
        hotelService.save(hotel);
        return ResponseEntity.created(URI.create("api/hotel/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody HotelDTO hotelDto){
        Optional<Hotel> hotelOptional = hotelService.findById(id);
        if (hotelOptional.isPresent()){
            Hotel hotel = Hotel.builder()
                    .id(id)
                    .name(hotelDto.getName())
                    .nameManager(hotelDto.getNameManager())
                    .numRooms(hotelDto.getNumRooms())
                    .hasAParking(hotelDto.isHasAParking())
                    .hasARestaurant(hotelDto.isHasARestaurant())
                    .route(hotelDto.getRoute()).
                    build();
            hotelService.save(hotel);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?>deleteById(@PathVariable long id){
        Optional<Hotel> hotelOptional = hotelService.findById(id);
        if (hotelOptional.isPresent()){
            hotelService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findByRoute/{route}")
    public ResponseEntity<?> findByRoute (@PathVariable String route){
        List<Hotel> hotelOptional = hotelService.findHotelByRoute(route);
       if (hotelOptional.isEmpty()){
           return ResponseEntity.notFound().build();
        }
       List<HotelDTO> hotelDTOS = hotelOptional.stream()
               .map(hotel -> HotelDTO.builder()
                       .id(hotel.getId())
                       .name(hotel.getName())
                       .nameManager(hotel.getNameManager())
                       .numRooms(hotel.getNumRooms())
                       .hasAParking(hotel.isHasAParking())
                       .hasARestaurant(hotel.isHasARestaurant())
                       .route(hotel.getRoute())
                       .build())
               .toList();
       return ResponseEntity.ok(hotelDTOS);
    }
}
