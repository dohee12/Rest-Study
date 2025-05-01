package com.example.daelimdemo01.controller;

import com.example.daelimdemo01.domain.dto.request.ClubDto;
import com.example.daelimdemo01.domain.dto.request.IdAndNameDto;
import com.example.daelimdemo01.domain.dto.request.SchoolDto;
import com.example.daelimdemo01.domain.dto.request.StudentDto;
import com.example.daelimdemo01.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    // 학교 생성
    @PostMapping("/add-school")
    public String addSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.addSchool(schoolDto);
    }

    // 학생 생성
    @PostMapping("/add-student")
    public String addStudent(@RequestBody StudentDto studentDto) {
        return schoolService.addStudent(studentDto);
    }

    // 학교 조회 findAll()
    @GetMapping("/get-school-list")
    public List<SchoolDto> getSchoolList() {
        return schoolService.getSchoolList();
    }

    // 학생 조회 findAll()
    @GetMapping("/get-student-list")
    public List<StudentDto> getStudentList() {
        return schoolService.getStudentList();
    }

    // 학생 학교별로 조회
    @GetMapping("/get-student-list-by-school")
    public List<StudentDto> getStudentListBySchool(@RequestParam("schoolId") Long schoolId) {
        return schoolService.getStudentListBySchool(schoolId);
    }

    // 학교 이름 변경
    @PostMapping("/update-school-name")
    public SchoolDto updateSchoolName(@RequestBody IdAndNameDto idAndNameDto) {
        return schoolService.updateSchoolName(idAndNameDto);
    }

    // 동아리 생성
    @PostMapping("/add-club")
    public String addClub(@RequestBody ClubDto clubDto) {
        return schoolService.addClub(clubDto);
    }

    // 동아리 가입
    @PostMapping("/join-club")
    public String joinClub(@RequestBody IdAndNameDto idAndNameDto) {
        return schoolService.joinClub(idAndNameDto);
    }

}