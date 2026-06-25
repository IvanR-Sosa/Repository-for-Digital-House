package com.example.backendAdmin.controller;

import com.example.backendAdmin.entities.Admin;
import com.example.backendAdmin.service.IAdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<AdminDTO> adminDTOList = adminService.findAll()
                .stream()
                .map(admin -> AdminDTO.builder()
                        .id(admin.getId())
                        .name(admin.getName())
                        .dni(admin.getDni())
                        .password(admin.getPassword())
                        .build())
                .toList();
        return ResponseEntity.ok(adminDTOList);

    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Admin> adminOptional = adminService.findById(id);
        if (adminOptional.isPresent()){
            Admin admin = adminOptional.get();
            AdminDTO adminDTO =AdminDTO.builder()
                    .name(admin.getName())
                    .dni(admin.getDni())
                    .password(admin.getPassword())
                    .build();
            return ResponseEntity.ok(adminDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody AdminDTO adminDTO){
        Admin admin =Admin.builder()
                .name(adminDTO.getName())
                .dni(adminDTO.getDni())
                .password(adminDTO.getPassword())
                .build();
        adminService.save(admin);
        return ResponseEntity.created(URI.create("api/admin/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable Long id,@RequestBody AdminDTO adminDTO){
        Optional<Admin> adminOptional = adminService.findById(id);
        if (adminOptional.isPresent()){
            Admin admin = Admin.builder()
                    .id(id)
                    .name(adminDTO.getName())
                    .dni(adminDTO.getDni())
                    .password(adminDTO.getPassword())
                    .build();
            adminService.save(admin);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<Admin> adminOptional = adminService.findById(id);
        if (adminOptional.isPresent()){
            adminService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
