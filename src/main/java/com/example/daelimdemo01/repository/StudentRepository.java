package com.example.daelimdemo01.repository;

import com.example.daelimdemo01.domain.entity.School;
import com.example.daelimdemo01.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllBySchool(School school);

    List<Student> findAllBySchool_Id(Long schoolId);

    List<Student> findAllBySchool_IdAndDeleted(Long schoolId, Boolean deleted);

}
