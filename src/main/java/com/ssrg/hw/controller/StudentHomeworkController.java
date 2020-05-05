package com.ssrg.hw.controller;


import com.ssrg.hw.dto.StudentHomeworkDto;
import com.ssrg.hw.service.IStudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentHomeworkController {

    @Autowired
    private IStudentHomeworkService shService;

    @GetMapping("/querySHByStudentId")
    public List<StudentHomeworkDto> querySHByStudentId(int studentId){
        List<StudentHomeworkDto> studentHomeworkList = shService.querySHByStudentId(studentId);
        return studentHomeworkList;
    }

    @GetMapping("/querySHByHomeworkId")
    public StudentHomeworkDto querySHByHomeworkId(int homeworkId){
        StudentHomeworkDto studentHomework = shService.querySHByHomeworkId(homeworkId);
        return studentHomework;
    }

    @GetMapping("/querySHByStudentHomeworkId")
    public StudentHomeworkDto querySHByStudentHomeworkId(int studentHomeworkId){
        StudentHomeworkDto StudentHomework = shService.querySHByStudentHomeworkId(studentHomeworkId);
        return StudentHomework;
    }

    @GetMapping("/addSH")
    public int addSH(StudentHomeworkDto studentHomeworkDto){
        shService.addSH(studentHomeworkDto);
        return 1;
    }

    @GetMapping("/deleteSH")
    public int deleteSH(int studentHomeworkId){
        shService.deleteSH(studentHomeworkId);
        return 1;
    }

    @GetMapping("/updateSH")
    public int updateSH(StudentHomeworkDto studentHomeworkDto){
        shService.updateSH(studentHomeworkDto);
        return 1;
    }
}
