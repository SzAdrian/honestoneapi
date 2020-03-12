package com.codecool.honestoneapi.model;

public class Deck {
    private String deckcode;
    private Integer hero;
    private Integer format;
    private String name;
    private Integer userId;

    public String getDeckcode() {
        return deckcode;
    }

    public void setDeckcode(String deckcode) {
        this.deckcode = deckcode;
    }

    public Integer getHero() {
        return hero;
    }

    public void setHero(Integer hero) {
        this.hero = hero;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
