package com.example.daelimdemo01.domain.dto.request;

import com.example.daelimdemo01.domain.entity.School;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ClubDto {
    private Long id;
    private String name;
    private List<StudentDto> students;

    public ClubDto(School school) {
        this.id = school.getId();
        this.name = school.getName();
    }
}