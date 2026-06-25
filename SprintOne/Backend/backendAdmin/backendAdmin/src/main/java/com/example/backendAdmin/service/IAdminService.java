package com.example.backendAdmin.service;

import com.example.backendAdmin.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {
    List<Admin> findAll ();
    Optional<Admin> findById(Long id);
    void save (Admin admin);
    void deleteById (Long id);
}
