package com.example.backendUser.service;

import com.example.backendUser.entities.User;
import com.example.backendUser.persistence.impl.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements IUserService{
    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
