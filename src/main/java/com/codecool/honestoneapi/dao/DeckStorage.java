package com.codecool.honestoneapi.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeckStorage {
    private List<String> deckStorage = new ArrayList();

    public void saveDeck(String deckcode) {
        deckStorage.add(deckcode);
        System.out.println(deckStorage);
    }

    public List<String> getDeckStorage() {
        return deckStorage;
    }
}
