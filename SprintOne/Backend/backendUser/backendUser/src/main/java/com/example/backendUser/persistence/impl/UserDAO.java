package com.example.backendUser.persistence.impl;

import com.example.backendUser.entities.User;
import com.example.backendUser.persistence.IUserDAO;
import com.example.backendUser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserDAO implements IUserDAO {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
