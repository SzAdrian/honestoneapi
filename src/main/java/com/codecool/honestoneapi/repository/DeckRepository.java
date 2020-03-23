package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck,Long> {
}
