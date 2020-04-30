package com.ssrg.hw.controller;


import com.ssrg.hw.dto.StudentQuestionDto;
import com.ssrg.hw.service.IStudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentQuestionController {

    @Autowired
    private IStudentQuestionService StudentQuestionService;

    @GetMapping("/queryStudentQuestionByStudentId")
    public List<StudentQuestionDto> queryStudentQuestionByStudentId(int studentId){
        List<StudentQuestionDto> StudentQuestionList = StudentQuestionService.queryStudentQuestionByTeacherId(teacherId);
        return StudentQuestionList;
    }

    @GetMapping("/queryStudentQuestionByStudentQuestionId")
    public StudentQuestionDto queryStudentQuestionByStudentQuestionId(int studentQuestionId){
        StudentQuestionDto StudentQuestion = StudentQuestionService.queryStudentQuestionByStudentQuestionId(studentQuestionId);
        return StudentQuestion;
    }

    @GetMapping("/addStudentQuestion")
    public int addStudentQuestion(StudentQuestionDto studentQuestionDto){
        StudentQuestionService.addStudentQuestion(studentQuestionDto);
        return 1;
    }

    @GetMapping("/deleteStudentQuestion")
    public int deleteStudentQuestion(int studentQuestionId){
        StudentQuestionService.deleteStudentQuestion(studentQuestionId);
        return 1;
    }

    @GetMapping("/updateStudentQuestion")
    public int updateStudentQuestion(StudentQuestionDto studentQuestionDto){
        StudentQuestionService.updateStudentQuestion(studentQuestionDto);
        return 1;
    }
}
