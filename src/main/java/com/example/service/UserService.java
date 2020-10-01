package com.example.service;

import com.example.dto.UserDto;
import com.example.pojo.AppUser;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void deleteUsers(List<String> listId){
        listId.forEach(elem -> {
            AppUser userDb = userRepository.getUserById(Long.parseLong(elem));
            userRepository.delete(userDb);
        });
    }

    public boolean isBlockUser(Long id){
        return userRepository.getUserById(id).getIsblock();
    }

    public void blockUser(List<String> listId){
        listId.forEach(elem -> {
            AppUser userDb = userRepository.getUserById(Long.parseLong(elem));
            if (!isBlockUser(Long.parseLong(elem))) {
                userDb.setIsblock(true);
                userDb.setId(userDb.getId());
                userDb.setRegisterdate(userDb.getRegisterdate());
                userRepository.save(userDb);
            }
        });
    }

    public void unblockUser(List<String> listId){
        listId.forEach(elem -> {
            AppUser userDb = userRepository.getUserById(Long.parseLong(elem));
            if (isBlockUser(Long.parseLong(elem))) {
                userDb.setIsblock(false);
                userDb.setId(userDb.getId());
                userDb.setRegisterdate(userDb.getRegisterdate());
                userRepository.save(userDb);
            }
        });
    }

    public void addUser(String name, String email, String password){
        AppUser user = new AppUser();
        user.setName(name);
        user.setEmail(email);
        user.setLastaccess(LocalDateTime.now());
        user.setPassword(password);
        user.setIsblock(false);
        userRepository.save(user);
    }


    public List<UserDto> getAllUsers(){
        final List<UserDto> list = new ArrayList<>();
        userRepository.findAll().forEach(user -> list.add(new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRegisterdate(),
                user.getLastaccess(),
                user.getIsblock())
        ));
        return list;
    }

}
