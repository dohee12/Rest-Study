package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNickname(String nickname);
}