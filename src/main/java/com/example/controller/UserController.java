package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        userService.addUser(name, email, password);
    }

    @PutMapping("/block")
    public void blockUsers(@RequestBody List<String> list){
        userService.blockUser(list);
    }

    @PutMapping("/unblock")
    public void unblockUsers(@RequestBody List<String> list){
        userService.unblockUser(list);
    }

    @DeleteMapping("/delete")
    public void deleteUsers(@RequestBody List<String> list){
        userService.deleteUsers(list);
    }

    @GetMapping("/all")
    public List<UserDto> getAll(){
        return userService.getAllUsers();
    }
}
