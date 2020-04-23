package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.controller.dto.PublishedDeckDto;
import com.codecool.honestoneapi.dao.DeckStorage;
import com.codecool.honestoneapi.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeckService {
    @Autowired
    private DeckStorage deckStorage;

    public Deck saveDeck(Deck deck, Long userId){
        deck.setUpdateTime(LocalDateTime.now());
        return deckStorage.saveDeck(deck,userId);
    }

    public List<Deck> getDecksByUserId(Long id) {
        return deckStorage.getDecksByUserId(id);
    }

    public void deleteDeckById(Long deckId) {
        deckStorage.deleteDeckById(deckId);
    }

    public Deck updateDeck(Deck deck) {
        return deckStorage.updateDeck(deck);
    }
    public boolean isDeckAlreadySaved(Deck deck){
        return deckStorage.isDeckAlreadySaved(deck);
    }

    public void updatePublished(PublishedDeckDto deck) {
        deckStorage.updatePublished(deck);
    }

    public List<Deck> getAllPublicDecks() {
        return deckStorage.getAllPublicDecks();
    }

    public List<Deck> getMostRecentDecks(Integer limit) {
        return deckStorage.getMostRecentDecks(limit);
    }
}
