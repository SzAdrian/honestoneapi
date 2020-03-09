package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.dao.DeckStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckService {
    @Autowired
    private DeckStorage deckStorage;

    public void saveDeck(String deckcode){
        deckStorage.saveDeck(deckcode);
    }

    public List<String> getDecks(){
        return deckStorage.getDeckStorage();
    }
}
