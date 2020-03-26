package com.codecool.honestoneapi.dao;

import com.codecool.honestoneapi.model.Deck;
import com.codecool.honestoneapi.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DeckStorage {

    @Autowired
    DeckRepository deckRepository;

    public void saveDeck(Deck deck) {
        deckRepository.save(deck);
    }
//
//    public List<Deck> getDecksByUserId(Integer userId) {
//        return deckStorage.stream()
//                .filter(deck -> deck.getUserId() == userId)
//                .collect(Collectors.toList());
//    }
}
