package com.codecool.honestoneapi.dao;


import com.codecool.honestoneapi.model.Stat;
import com.codecool.honestoneapi.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatStorage {

    @Autowired
    StatRepository statRepository;

    public void saveStat(Stat stat) { statRepository.save(stat); }
}
