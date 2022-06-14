package com.vestra.pp3bootstrap.controllers;

import com.vestra.pp3bootstrap.service.RoleService;
import com.vestra.pp3bootstrap.service.UserService;
import com.vestra.pp3bootstrap.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
public class MainController {

    private final UserService userService;
    private final RoleService roleService;

    public MainController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    /*@GetMapping("/login")
    public String login(){
        return "login";
    }*/

    @GetMapping("/admin")
    public String getListUsers(@AuthenticationPrincipal UserDetails userDetails, Model model){
        String name = userDetails.getUsername();
        User user = userService.getByName(name);
        model.addAttribute("user", user);
        model.addAttribute("userList", userService.getAllUser());
        model.addAttribute("user1", new User());
        model.addAttribute("roleList", roleService.getAllRoles());
        return "userPage";
    }

    @PostMapping(value="/admin/add")
    public String saveUser(@ModelAttribute User user1,
                           @RequestParam(value = "checked", required = false ) Long[] checked){
        if (checked == null) {
            user1.setOneRole(roleService.getRoleByName("USER"));
        } else {
            for (Long aLong : checked) {
                if (aLong != null) {
                    user1.setOneRole(roleService.getRoleByID(aLong));
                }
            }
        }
        userService.addUser(user1);
        return "redirect:/admin";
    }

    @PatchMapping(value="/admin/edit/{id}")
    public String updateUser(@ModelAttribute User user,
                             @RequestParam(value = "checked", required = false ) Long[] checked) {
        if (checked == null) {
            user.setOneRole(roleService.getRoleByName("USER"));
            userService.updateUser(user);
        } else {
            for (Long aLong : checked) {
                if (aLong != null) {
                    user.setOneRole(roleService.getRoleByID(aLong));
                    userService.updateUser(user);
                }
            }
        }
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String getUserId(@PathVariable(value="id")Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String getUserInfo(@AuthenticationPrincipal UserDetails userDetails,
                              Model model){
        String name = userDetails.getUsername();
        User user = userService.getByName(name);
        model.addAttribute("user", user);
        return "adminPage";
    }

}
