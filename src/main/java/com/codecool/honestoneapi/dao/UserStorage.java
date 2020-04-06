package com.codecool.honestoneapi.dao;

import com.codecool.honestoneapi.model.Usr;
import com.codecool.honestoneapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public class UserStorage {

    @Autowired
    private UserRepository userRepository;

    public Long register(Usr user){
        user.setRegistrationTime(LocalDateTime.now());
        userRepository.save(user);
        return userRepository.findUsrByUsername(user.getUsername()).getId();
    }

    public Usr registerReturnUser(Usr user){
        user.setRegistrationTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Long login(String username, String password){
        Usr user = userRepository.findUsrByUsername(username);
        if (user!= null && user.getPassword().equals(password)){
            return user.getId();
        }
        return -1L;
    }


}
