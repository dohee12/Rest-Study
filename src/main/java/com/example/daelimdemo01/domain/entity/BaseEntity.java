package com.example.daelimdemo01.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(nullable = false)
    LocalDateTime createdTime;

    @LastModifiedDate
    @Column(nullable = false)
    LocalDateTime lastModifiedDate;

    Boolean deleted = false;

    public void delete() {
        deleted = true;
    }

    public void revive() {
        deleted = false;
    }
}
