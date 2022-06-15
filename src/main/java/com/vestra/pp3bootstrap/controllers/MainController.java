package com.vestra.pp3bootstrap.controllers;

import com.vestra.pp3bootstrap.model.User;
import com.vestra.pp3bootstrap.service.RoleService;
import com.vestra.pp3bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private final UserService userService;
    private final RoleService roleService;

    public MainController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/user")
    public String userInfo(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userPage";
    }

    @GetMapping(value = "/admin")
    public String listUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "adminPage";
    }


}
