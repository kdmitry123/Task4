package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserMvcController {

    @Autowired
    UserService userService;


    @PostMapping("/block")
    public void block(@RequestBody List<String> listId){
        userService.blockUser(listId);
    }

    @PostMapping("/unblock")
    public void unblockUsers(@RequestBody List<String> list){
        userService.unblockUser(list);
    }

    @PostMapping("/delete")
    public void deleteUsers(@RequestBody List<String> list){
        userService.deleteUsers(list);
    }

}
