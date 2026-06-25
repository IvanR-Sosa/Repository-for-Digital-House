package com.example.backendAdmin.service;

import com.example.backendAdmin.entities.Admin;
import com.example.backendAdmin.persistence.IAdminDAO;
import com.example.backendAdmin.persistence.impl.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    AdminDAO adminDAO;

    @Override
    public List<Admin> findAll() {
        return adminDAO.findAll();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminDAO.findById(id);
    }

    @Override
    public void save(Admin admin) {
        adminDAO.save(admin);
    }

    @Override
    public void deleteById(Long id) {
        adminDAO.deleteById(id);
    }
}
