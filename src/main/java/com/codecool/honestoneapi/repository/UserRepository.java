package com.codecool.honestoneapi.repository;

import com.codecool.honestoneapi.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usr,Long> {

    Usr findUsrByUsername(String username);
}
