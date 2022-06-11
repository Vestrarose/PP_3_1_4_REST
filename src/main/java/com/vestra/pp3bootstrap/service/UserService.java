package com.vestra.pp3bootstrap.service;

import com.vestra.pp3bootstrap.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    List<User> getAllUser();
    void addUser(User u);
    void deleteById(Long id);
    User getUserById(Long id);
    void updateUser(User u);
    User getByName(String name);
}
