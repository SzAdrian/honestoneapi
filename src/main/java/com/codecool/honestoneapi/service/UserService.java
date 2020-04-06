package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.controller.dto.UserCredentials;
import com.codecool.honestoneapi.dao.UserStorage;
import com.codecool.honestoneapi.model.Role;
import com.codecool.honestoneapi.model.Usr;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStorage userStorage;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public Long register(Usr user){
        return userStorage.register(user);
    }


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

    public Long login(String username, String password) {
        long login = userStorage.login(username, password);
        if(login != -1) return login;
        return -1L;
    }
}
