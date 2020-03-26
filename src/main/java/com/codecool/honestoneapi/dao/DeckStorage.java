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

    public void saveDeck(Deck deck, Long userId) {
        Usr user = userRepository.findById(userId).get();
        user.addDeck(deck);
        userRepository.save(user);
    }

    public List<Deck> getDecksByUserId(Integer userId) {
        return deckRepository.findByUserId(Long.valueOf(userId));
    }
}
