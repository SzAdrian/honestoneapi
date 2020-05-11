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

    public Usr registerReturnUser(Usr user){
        user.setRegistrationTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Usr findUsrByUsername(String username) {
        return userRepository.findUsrByUsername(username);
    }

    public String getUsernameById(Long id) {
        Usr user = userRepository.findById(id).get();
        return user.getUsername();
    }

    public LocalDateTime getRegistrationDateById(Long id) {
        return userRepository.findById(id).get().getRegistrationTime();
    }

    public void save(Usr usr) {
        userRepository.save(usr);
    }
}
