package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.dao.DeckStorage;
import com.codecool.honestoneapi.dao.UserStorage;
import com.codecool.honestoneapi.controller.dto.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private DeckStorage deckStorage;

    @Autowired
    private UserStorage userStorage;

    public Profile getProfile(Long id) {
        return Profile.
                builder().
                username(userStorage.getUsernameById(id))
                .registrationDate(userStorage.getRegistrationDateById(id))
                .numberOfDecks(deckStorage.getDecksByUserId(id).size())
                .build();
    }
}
