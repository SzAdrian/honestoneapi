package com.codecool.honestoneapi.controller;

import com.codecool.honestoneapi.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeckController {
    @Autowired
    private DeckService deckService;

    @CrossOrigin
    @PostMapping("/api/v1/savedeck/{deckcode}")
    public void saveDeck(@PathVariable("deckcode") String deckcode) {
        deckService.saveDeck(deckcode);
    }
}
