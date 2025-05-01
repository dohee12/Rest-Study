package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.StudentClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClubRepository extends JpaRepository<StudentClub, Long> {
}
