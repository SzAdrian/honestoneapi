package com.codecool.honestoneapi.dao;

import com.codecool.honestoneapi.controller.dto.PublishedDeckDto;
import com.codecool.honestoneapi.model.Deck;
import com.codecool.honestoneapi.model.Usr;
import com.codecool.honestoneapi.repository.DeckRepository;
import com.codecool.honestoneapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DeckStorage {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private UserRepository userRepository;

    public Deck saveDeck(Deck deck, Long userId) {
        Usr user = userRepository.findById(userId).get();
        deck.setUser(user);
        return deckRepository.save(deck);
    }

    public List<Deck> getDecksByUserId(Integer userId) {
        return deckRepository.findByUserIdOrderById(Long.valueOf(userId));
    }

    public void deleteDeckById(Long deckId) {
        deckRepository.deleteById(deckId);
    }

    public Deck updateDeck(Deck deck) {
        //deckRepository.updateDeckById(deck.getId(), deck.getName(), deck.getDeckcode(), deck.isPublished());
        Deck deckToUpdate = deckRepository.findById(deck.getId()).get();
        deckToUpdate.setName(deck.getName());
        deckToUpdate.setDeckcode(deck.getDeckcode());
        deckToUpdate.setUpdateTime(LocalDateTime.now());
        deckToUpdate.setPublished(deck.isPublished());
        deckRepository.save(deckToUpdate);
        return deckToUpdate;
    }

    public boolean isDeckAlreadySaved(Deck deck) {
        return deckRepository.existsById(deck.getId());
    }

    public void updatePublished(PublishedDeckDto deck) {
        Deck deckToUpdate = deckRepository.findById(deck.getId()).get();
        deckToUpdate.setPublished(deck.getPublished());
        deckRepository.save(deckToUpdate);
    }

    public List<Deck> getAllPublicDecks() {
        return deckRepository.getAllPublic();

    }

    public List<Deck> getMostRecentDecks(Integer limit) {
        return deckRepository.getMostRecentDecks();
    }
}
