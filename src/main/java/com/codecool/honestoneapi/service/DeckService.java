package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.dao.DeckStorage;
import com.codecool.honestoneapi.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DeckService {
    @Autowired
    private DeckStorage deckStorage;

    public void saveDeck(Deck deck, Long userId){
        deckStorage.saveDeck(deck,userId);
    }

    public List<Deck> getDecksByUserId(Integer id) {
        return deckStorage.getDecksByUserId(id);
    }
}
