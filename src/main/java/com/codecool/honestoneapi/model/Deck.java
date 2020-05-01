package com.codecool.honestoneapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Deck {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Usr user;

    private String deckcode;

    private int hero;

    private int format;

    private String name;

    private boolean published;

    private LocalDateTime updateTime;

    private int votes;

    //private Generation generation;

}
