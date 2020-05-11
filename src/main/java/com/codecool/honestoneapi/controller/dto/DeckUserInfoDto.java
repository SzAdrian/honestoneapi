package com.codecool.honestoneapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeckUserInfoDto {

    private Long deckId;

    private String deckcode;

    private int hero;

    private int format;

    private String name;

    private boolean published;

    private LocalDateTime updateTime;

    private int votes;

    private boolean liked;

    private boolean disliked;

    private Long userId;

    private String username;
}
