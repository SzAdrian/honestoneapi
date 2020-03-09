package com.codecool.honestoneapi.dao;

import com.codecool.honestoneapi.model.Deck;
import com.intellij.openapi.vcs.history.VcsRevisionNumber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DeckStorage {
    private List<Deck> deckStorage = new ArrayList();

    public void saveDeck(Deck deck) {
        deckStorage.add(deck);
    }

    public List<Deck> getDecksByUserId(Integer userId) {
        return deckStorage.stream()
                .filter(deck -> deck.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
