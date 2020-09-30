package com.example.repo;

import com.example.pojo.AppUser;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<AppUser, Long> {
    AppUser getUserById(Long id);
    AppUser findUserByEmail(String email);
}
