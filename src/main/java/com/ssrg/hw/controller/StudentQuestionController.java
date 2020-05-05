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

    @GetMapping("/querySQByStudentQuestionId")
    public StudentQuestionDto querySQByStudentQuestionId(int studentQuestionId){
        StudentQuestionDto StudentQuestion = StudentQuestionService.querySQByStudentQuestionId(studentQuestionId);
        return StudentQuestion;
    }

    @GetMapping("/addSQ")
    public int addSQ(StudentQuestionDto studentQuestionDto){
        StudentQuestionService.addSQ(studentQuestionDto);
        return 1;
    }

    @GetMapping("/deleteSQ")
    public int deleteSQ(int studentQuestionId){
        StudentQuestionService.deleteSQ(studentQuestionId);
        return 1;
    }

    @GetMapping("/updateSQ")
    public int updateSQ(StudentQuestionDto studentQuestionDto){
        StudentQuestionService.updateSQ(studentQuestionDto);
        return 1;
    }
}
