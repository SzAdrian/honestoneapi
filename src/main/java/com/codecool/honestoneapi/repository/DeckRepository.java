package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck,Long> {


    List<Deck> findByUserId(Long user_id);

}
