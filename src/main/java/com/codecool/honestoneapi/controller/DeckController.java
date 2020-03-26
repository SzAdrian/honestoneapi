package com.codecool.honestoneapi.controller;

import com.codecool.honestoneapi.model.Deck;
import com.codecool.honestoneapi.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
@CrossOrigin
public class DeckController {
    @Autowired
    private DeckService deckService;

    @PostMapping("/save")
    public Deck saveDeck(@RequestBody Deck deck, @RequestHeader("user-id") String userId) {
        if(deckService.isDeckAlreadySaved(deck)){
            return deckService.updateDeck(deck);
        }
        return deckService.saveDeck(deck, Long.valueOf(userId));
    }

    @GetMapping("/get/{id}")
    public List<Deck> getDecksById(@PathVariable("id") Integer id) {
        return deckService.getDecksByUserId(id);
    }

    @DeleteMapping("/{deckId}")
    public void deleteDeckById(@PathVariable("deckId") Long deckId) {
        deckService.deleteDeckById(deckId);
    }

    @PutMapping("")
    public void updateDeck(@RequestBody Deck deck){
        deckService.updateDeck(deck);
    }
}

