package com.codecool.honestoneapi.dao;

import com.codecool.honestoneapi.model.Deck;
import com.codecool.honestoneapi.model.Usr;
import com.codecool.honestoneapi.repository.DeckRepository;
import com.codecool.honestoneapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
       deckRepository.updateDeckById(deck.getId(),deck.getName(),deck.getDeckcode());
       return deckRepository.findById(deck.getId()).get();
    }

    public boolean isDeckAlreadySaved(Deck deck) {
        return deckRepository.existsById(deck.getId());
    }
}
