package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNickname(String nickname);
}