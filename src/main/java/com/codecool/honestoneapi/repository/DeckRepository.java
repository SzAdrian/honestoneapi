package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.controller.dto.DeckUserInfoDto;
import com.codecool.honestoneapi.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface DeckRepository extends JpaRepository<Deck,Long> {


    List<Deck> findByUserIdOrderById(Long user_id);

    @Modifying
    @Transactional
    @Query("UPDATE Deck d SET d.deckcode = :deckcode, d.name = :name,d.published =:published WHERE d.id = :id")
    void updateDeckById(@Param("id") Long id,@Param("name") String name,@Param("deckcode") String deckcode,@Param("published") Boolean published);

    @Query("SELECT d FROM Deck d WHERE d.published = true")
    List<Deck> getAllPublic();

    @Query("SELECT d FROM Deck d WHERE d.published = true ORDER BY d.updateTime DESC ")
    List<Deck> getMostRecentDecks();


//    @Query("SELECT d.id as deckId, d.deckcode as deckcode, d.hero as hero,d.format as format, d.name as name,d.published as published, u.id as userid,u.username as username FROM Deck d JOIN Usr u ON (d.user = u) WHERE d.published = true ")
//    List<DeckUserInfoDto> getAllPublicWithUsername();
}
