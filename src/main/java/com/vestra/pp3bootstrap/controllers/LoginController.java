package com.vestra.pp3bootstrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String indexPage() {
        return "login";
    }
}
