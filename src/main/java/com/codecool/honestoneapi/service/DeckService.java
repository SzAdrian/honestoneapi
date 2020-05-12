package com.codecool.honestoneapi.service;

import com.codecool.honestoneapi.controller.dto.DeckUserInfoDto;
import com.codecool.honestoneapi.controller.dto.PublishedDeckDto;
import com.codecool.honestoneapi.dao.DeckStorage;
import com.codecool.honestoneapi.dao.UserStorage;
import com.codecool.honestoneapi.model.Deck;
import com.codecool.honestoneapi.model.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeckService {
    @Autowired
    private DeckStorage deckStorage;
    @Autowired
    private UserStorage userStorage;

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

    public List<DeckUserInfoDto> getAllPublicDecks() {
        List<Deck> decks =   deckStorage.getAllPublicDecks();
        return decks.stream().map(this::buildDtoFromDeck).collect(Collectors.toList());

    }

    public List<DeckUserInfoDto> getMostRecentDecks(Integer limit) {
        List<Deck> decks =  deckStorage.getMostRecentDecks(limit);

       return decks.stream().map(this::buildDtoFromDeck).collect(Collectors.toList());
    }
    private DeckUserInfoDto buildDtoFromDeck(Deck deck) {
        return DeckUserInfoDto.builder()
                .deckcode(deck.getDeckcode())
                .deckId(deck.getId())
                .format(deck.getFormat())
                .hero(deck.getHero())
                .name(deck.getName())
                .published(deck.isPublished())
                .updateTime(deck.getUpdateTime())
                .userId(deck.getUser().getId())
                .username(deck.getUser().getUsername())
                .votes(deck.getVotes())
                .build();
    }

    public void like(DeckUserInfoDto data) {
        Usr usr = userStorage.findUsrByUsername(data.getUsername());
        Deck deck = deckStorage.findDeckById(data.getDeckId());
        resetVotes(usr, deck);
        deck.setVotes(deck.getVotes()+1);
        usr.getLikedDecks().add(deck.getId());
        userStorage.save(usr);
        deckStorage.save(deck);
    }

    public void unlike(DeckUserInfoDto data) {
        Usr usr = userStorage.findUsrByUsername(data.getUsername());
        Deck deck = deckStorage.findDeckById(data.getDeckId());
        resetVotes(usr, deck);
        userStorage.save(usr);
        deckStorage.save(deck);
    }

    public void dislike(DeckUserInfoDto data) {
        Usr usr = userStorage.findUsrByUsername(data.getUsername());
        Deck deck = deckStorage.findDeckById(data.getDeckId());
        resetVotes(usr, deck);
        deck.setVotes(deck.getVotes()-1);
        usr.getDislikedDecks().add(deck.getId());
        userStorage.save(usr);
        deckStorage.save(deck);
    }

    private void resetVotes(Usr usr, Deck deck) {
        if (usr.getLikedDecks().remove(deck.getId())) {
            deck.setVotes(deck.getVotes()-1);
        }
        else if(usr.getDislikedDecks().remove(deck.getId())){
            deck.setVotes(deck.getVotes()+1);
        }
    }

}
