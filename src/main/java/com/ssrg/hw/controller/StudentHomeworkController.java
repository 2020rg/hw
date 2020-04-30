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
    private IStudentHomeworkService studenthomeworkService;

    @GetMapping("/queryStudentHomeworkByStudentId")
    public List<StudentHomeworkDto> queryStudentHomeworkByStudentId(int studentId){
        List<StudentHomeworkDto> StudentHomeworkList = StudentHomeworkService.queryStudentHomeworkByStudentId(studentId);
        return StudentHomeworkList;
    }

    @GetMapping("/queryStudentHomeworkByHomeworkId")
    public StudentHomeworkDto queryStudentHomeworkByHomeworkId(int homeworkId){
        StudentHomeworkDto StudentHomework = StudentHomeworkService.queryStudentHomeworkByHomeworkId(homeworkId);
        return StudentHomework;
    }

    @GetMapping("/queryStudentHomeworkByStudentHomeworkId")
    public StudentHomeworkDto queryStudentHomeworkByStudentHomeworkId(int studentHomeworkId){
        StudentHomeworkDto StudentHomework = StudentHomeworkService.queryStudentHomeworkByStudentHomeworkId(studentHomeworkId);
        return StudentHomework;
    }

    @GetMapping("/addStudentHomework")
    public int addStudentHomework(StudentHomeworkDto studentHomeworkDto){
        StudentHomeworkService.addStudentHomework(studentHomeworkDto);
        return 1;
    }

    @GetMapping("/deleteStudentHomework")
    public int deleteStudentHomework(int studentHomeworkId){
        StudentHomeworkService.deleteStudentHomework(studentHomeworkId);
        return 1;
    }

    @GetMapping("/updateStudentHomework")
    public int updateStudentHomework(StudentHomeworkDto studentHomeworkDto){
        StudentHomeworkService.updateStudentHomework(studentHomeworkDto);
        return 1;
    }
}
