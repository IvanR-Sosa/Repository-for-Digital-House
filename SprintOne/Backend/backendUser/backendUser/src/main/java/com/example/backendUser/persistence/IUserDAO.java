package com.example.backendUser.persistence;

import com.example.backendUser.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    List<User> findAll();
    Optional<User> findById(long id);
    void save (User user);
    void deleteById(long id);
}
