package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name);
    Optional<Food> findByType(String type);
    Optional<Food> findByNameAndDeleted(String name, Boolean deleted);
}