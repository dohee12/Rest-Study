package com.example.daelimdemo01.domain.dto.request;

import com.example.daelimdemo01.domain.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentDto {
    private Long id;
    private String name;
    private SchoolDto schoolDto;
    private Long schoolId;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.schoolDto = new SchoolDto(student.getSchool());
        this.schoolId = student.getSchool().getId();
    }
}
