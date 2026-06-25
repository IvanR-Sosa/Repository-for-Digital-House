package com.example.backendUser.controller;

import com.example.backendUser.entities.User;
import com.example.backendUser.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userDTOList = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName()).dni(user.getDni())
                        .build())
                .toList();
        return ResponseEntity.ok(userDTOList);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id){
        Optional<User> userOptional =userService.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            UserDTO userDTO =UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .dni(user.getDni())
                    .build();
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO userDTO){
        User user = User.builder()
                .name(userDTO.getName())
                .dni(userDTO.getDni())
                .build();
        userService.save(user);
        return ResponseEntity.created(URI.create("/api/user/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable Long id,@RequestBody UserDTO userDTO){
        Optional<User> userOptional =userService.findById(id);
        if (userOptional.isPresent()){
            User user =User.builder()
                    .id(id)
                    .name(userDTO.getName())
                    .dni(userDTO.getDni())
                    .build();
            userService.save(user);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
