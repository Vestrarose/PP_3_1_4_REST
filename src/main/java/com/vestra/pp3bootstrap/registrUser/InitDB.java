package com.vestra.pp3bootstrap.registrUser;

import com.vestra.pp3bootstrap.model.Role;
import com.vestra.pp3bootstrap.model.User;
import com.vestra.pp3bootstrap.service.RoleService;
import com.vestra.pp3bootstrap.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDB {
    private final UserService userService;
    private final RoleService roleService;

    public InitDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void addUsersInDB() {
        User admin = new User("1", 1, "1", "1");
        User user = new User("2", 2, "2", "2");
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        roleService.addRole(adminRole);
        roleService.addRole(userRole);
        admin.setOneRole(adminRole);
        user.setOneRole(userRole);
        userService.addUser(admin);
        userService.addUser(user);
    }
}
