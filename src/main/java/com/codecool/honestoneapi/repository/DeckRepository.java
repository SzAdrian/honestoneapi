package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck,Long> {


    List<Deck> findByUserIdOrderById(Long user_id);

    @Modifying
    @Transactional
    @Query("UPDATE Deck d SET d.deckcode = :deckcode, d.name = :name,d.published =:published WHERE d.id = :id")
    void updateDeckById(@Param("id") Long id,@Param("name") String name,@Param("deckcode") String deckcode,@Param("published") Boolean published);

}
