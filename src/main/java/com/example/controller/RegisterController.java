package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestParam String email, @RequestParam String name, @RequestParam String password){
        userService.addUser(name, email, password);
        return "redirect:/login";
    }
}
