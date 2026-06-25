package com.example.backendAdmin.persistence.impl;

import com.example.backendAdmin.entities.Admin;
import com.example.backendAdmin.persistence.IAdminDAO;
import com.example.backendAdmin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class AdminDAO implements IAdminDAO {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public List<Admin> findAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }
}
