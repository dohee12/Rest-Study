package com.example.daelimdemo01.domain.dto.request;

import com.example.daelimdemo01.domain.entity.School;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SchoolDto {
    private Long id;
    private String name;

    public SchoolDto(School school) {
        this.id = school.getId();
        this.name = school.getName();
    }
}
