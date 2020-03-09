package com.codecool.honestoneapi.model;

import com.intellij.openapi.vcs.history.VcsRevisionNumber;

import java.util.List;

public class Deck {
    private String deckcode;
    private Integer hero;
    private Integer format;
    private String name;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }
}
