package com.vestra.pp3bootstrap.service;

import com.vestra.pp3bootstrap.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

}
