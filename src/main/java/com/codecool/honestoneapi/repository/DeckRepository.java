package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck,Long> {

    List<Deck> findByUserId(Long user_id);
}
