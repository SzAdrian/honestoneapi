package com.codecool.honestoneapi.controller;


import com.codecool.honestoneapi.controller.dto.Profile;
import com.codecool.honestoneapi.model.Usr;
import com.codecool.honestoneapi.service.ProfileService;
import com.codecool.honestoneapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private ProfileService profileService;


    @GetMapping("/profile/{id}")
    public Profile profile(@PathVariable("id") Long id) {
        return profileService.getProfile(id);
    }

}
