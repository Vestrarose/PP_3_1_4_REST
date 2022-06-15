package com.vestra.pp3bootstrap.controllers;

import com.vestra.pp3bootstrap.model.Role;
import com.vestra.pp3bootstrap.model.User;
import com.vestra.pp3bootstrap.service.RoleService;
import com.vestra.pp3bootstrap.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    private final UserService userService;
    private final RoleService roleService;

    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("admin/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("admin/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("admin/authorities")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping(value = "admin")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("admin")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
