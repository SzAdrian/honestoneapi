package com.codecool.honestoneapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Deck {

    @Id
    @GeneratedValue
    private long id;

    private String deckcode;

    private int hero;

    private int format;

    private String name;

}
