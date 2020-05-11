package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.controller.dto.UserCredentials;
import com.codecool.honestoneapi.controller.dto.UserResponseCredentials;
import com.codecool.honestoneapi.dao.UserStorage;
import com.codecool.honestoneapi.model.Role;
import com.codecool.honestoneapi.model.Usr;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStorage userStorage;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public Usr register(String username, String password) {
        return userStorage.registerReturnUser(
                Usr.builder()
                        .username(username)
                        .password(passwordEncoder.encode(password))
                        .role(Role.USER)
                        .build()
        );
    }

    public Usr register(UserCredentials userCredentials) {
        return register(userCredentials.getUsername(), userCredentials.getPassword());
    }


    public UserResponseCredentials getUserResponseCredentials(UserCredentials user) {
        return new UserResponseCredentials(user.getUsername(),userStorage.findUsrByUsername(user.getUsername()).getId());
    }
}
