package com.ssrg.hw.controller;


import com.ssrg.hw.dto.QuestionDto;
import com.ssrg.hw.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping("/queryQuestionByHomeworkId")
    public List<QuestionDto> queryQuestionByHomeworkId(int homeworkId){
        return questionService.queryQuestionByHomeworkId(homeworkId);
    }

    @GetMapping("/queryQuestionByQuestionId")
    public QuestionDto queryQuestionByQuestionId(int questionId){
        return questionService.queryQuestionByQuestionId(questionId);
    }

    @GetMapping("/addQuestion")
    public int addQuestion(QuestionDto questionDto){
        return questionService.addQuestion(questionDto);
    }

    @GetMapping("/updateQuestion")
    public int updateQuestion(int questionId,String content){
        return questionService.updateQuestion(questionId,content);
    }

    @GetMapping("/deleteQuestionByQuestionId")
    public int deleteQuestionByQuestionId(int questionId){
        return questionService.deleteQuestionByQuestionId(questionId);
    }

    @GetMapping("/deleteQuestionByHomeworkId")
    public int deleteQuestionByHomeworkId(int homeworkId){
        return questionService.deleteQuestionByHomeworkId(homeworkId);
    }
}
