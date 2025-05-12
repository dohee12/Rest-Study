package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
