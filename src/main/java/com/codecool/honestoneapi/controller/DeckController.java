package com.codecool.honestoneapi.controller;

import com.codecool.honestoneapi.model.Deck;
import com.codecool.honestoneapi.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController {
    @Autowired
    private DeckService deckService;

    @CrossOrigin
    @PostMapping("/save")
    public void saveDeck(@RequestBody Deck deck) {
        deckService.saveDeck(deck);
    }

    @CrossOrigin
    @GetMapping("/get/{id}")
    public List<Deck> getDecksById(@PathVariable("id") Integer id){
        return deckService.getDecksByUserId(id);
    }
}
