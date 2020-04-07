package com.codecool.honestoneapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    private String username;

    private LocalDateTime registrationDate;

    private long numberOfDecks;

    //private long totalVotes; todo
}
