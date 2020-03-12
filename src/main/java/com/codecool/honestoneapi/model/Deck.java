package com.codecool.honestoneapi.model;
import java.util.List;

public class Deck {
    private String deckcode;
    private int hero;
    private int format;
    private String name;
    private int userId;

    public String getDeckcode() {
        return deckcode;
    }

    public void setDeckcode(String deckcode) {
        this.deckcode = deckcode;
    }

    public int getHero() {
        return hero;
    }

    public void setHero(int hero) {
        this.hero = hero;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deckcode='" + deckcode + '\'' +
                ", hero=" + hero +
                ", name='" + name + '\'' +
                '}';
    }
}
