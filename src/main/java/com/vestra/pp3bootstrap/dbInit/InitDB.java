package com.vestra.pp3bootstrap.dbInit;

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
        User admin = new User("admin", "ser", 23, "ya@mail.ru", "admin");
        User user = new User("user", "Doo", 14, "re@mail.ru", "user");
        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");
        roleService.addRole(adminRole);
        roleService.addRole(userRole);
        admin.setOneRole(adminRole);
        user.setOneRole(userRole);
        userService.addUser(admin);
        userService.addUser(user);
    }
}
