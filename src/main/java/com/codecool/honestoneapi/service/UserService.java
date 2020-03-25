package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.dao.UserStorage;
import com.codecool.honestoneapi.model.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserStorage userStorage;

    public Long register(Usr user){
        return userStorage.register(user);
    }

    public Long login(String username, String password) {
        long login = userStorage.login(username, password);
        if(login != -1) return login;
        return -1L;
    }
}
