package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findByName(String name);
}
