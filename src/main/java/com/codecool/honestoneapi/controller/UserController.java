package com.codecool.honestoneapi.controller;


import com.codecool.honestoneapi.controller.dto.UserCredentials;
import com.codecool.honestoneapi.model.Usr;
import com.codecool.honestoneapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Long login(@RequestBody Usr user){
        return userService.login(user.getUsername(),user.getPassword());
    }
}
