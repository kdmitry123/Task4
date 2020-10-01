package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserMvcController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String getAll(){
        return "users";
    }

    @PostMapping("/block")
    public String block(@RequestBody List<String> listId){
        userService.blockUser(listId);
        return "redirect: /main";
    }
}
