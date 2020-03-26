package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat,Long> {
}
