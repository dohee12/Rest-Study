package com.example.daelimdemo01.service;

import com.example.daelimdemo01.domain.dto.request.ClubDto;
import com.example.daelimdemo01.domain.dto.request.IdAndNameDto;
import com.example.daelimdemo01.domain.dto.request.SchoolDto;
import com.example.daelimdemo01.domain.dto.request.StudentDto;
import com.example.daelimdemo01.domain.entity.*;
import com.example.daelimdemo01.repository.ClubRepository;
import com.example.daelimdemo01.repository.SchoolRepository;
import com.example.daelimdemo01.repository.StudentClubRepository;
import com.example.daelimdemo01.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SchoolService {
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final ClubRepository clubRepository;
    private final StudentClubRepository studentClubRepository;

    public String addSchool(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.getName());
        schoolRepository.save(school);

        return "success";
    }

    public String addStudent(StudentDto studentDto) {
        Optional<School> schoolOptional = schoolRepository.findById(studentDto.getSchoolId());
        if (schoolOptional.isPresent()) {
            School school = schoolOptional.get();

            Student student = new Student();
            student.setName(studentDto.getName());
            student.setSchool(school);

            studentRepository.save(student);

            return student.getSchool().getName() + "에 잘 등록되었습니다.";
        }

        return "찾을 수 없는 학교 ID 입니다.";
    }

    public List<SchoolDto> getSchoolList() {
//        List<School> schoolList = schoolRepository.findAll();
//        List<SchoolDto> schoolDtoList = new ArrayList<>();
//
//        for (School school : schoolList) {
//            SchoolDto schoolDto = new SchoolDto(school);
//            schoolDtoList.add(schoolDto);
//        }

//        return schoolDtoList;

        return schoolRepository.findAll().stream()
                .map(school -> new SchoolDto(school)).toList();
    }

    public List<StudentDto> getStudentList() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentDto(student))
                .toList();
    }

    public List<StudentDto> getStudentListBySchool(Long schoolId) {
//        School school = schoolRepository.findById(schoolId).get();
        return studentRepository.findAllBySchool_Id(schoolId).stream()
                .map(student -> new StudentDto(student))
                .toList();
    }

    public SchoolDto updateSchoolName(IdAndNameDto idAndNameDto) {
        Optional<School> schoolOptional = schoolRepository.findById(idAndNameDto.getId());
        if (schoolOptional.isPresent()) {
            School school = schoolOptional.get();
            school.setName(idAndNameDto.getName());

            return new SchoolDto(school);
        }

        return null;
    }

    public String addClub(ClubDto clubDto) {
        Club club = new Club();
        club.setName(clubDto.getName());
        clubRepository.save(club);

        return "success";
    }

    public String joinClub(IdAndNameDto idAndNameDto) {
        // id로 student id를 조회
        // name은 동아리 이름

        Optional<Student> studentOptional = studentRepository.findById(idAndNameDto.getId());
        Club club = clubRepository.findByName(idAndNameDto.getName());

        if (studentOptional.isPresent() && club != null) {
            StudentClub studentClub = new StudentClub();
            studentClub.setStudent(studentOptional.get());
            studentClub.setClub(club);
            studentClubRepository.save(studentClub);

            return "가입 완료!";
        }


        return "잘 못된 요청값입니다.";
    }
}
