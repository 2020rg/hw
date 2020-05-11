package com.ssrg.hw.controller;


import com.ssrg.hw.dto.QuestionDto;
import com.ssrg.hw.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @RequestMapping("/queryQuestionByHomeworkId")
    public List<QuestionDto> queryQuestionByHomeworkId(@RequestParam("homeworkID") int homeworkId){
        return questionService.queryQuestionByHomeworkId(homeworkId);
    }

    @RequestMapping("/queryQuestionByQuestionId")
    public QuestionDto queryQuestionByQuestionId(int questionId){
        return questionService.queryQuestionByQuestionId(questionId);
    }

    @RequestMapping("/addQuestion")
    public int addQuestion(QuestionDto questionDto){
        return questionService.addQuestion(questionDto);
    }

    @RequestMapping("/updateQuestion")
    public int updateQuestion(@RequestParam("questionID") int questionId, @RequestParam("questionAnswer") String content){
        return questionService.updateQuestion(questionId,content);
    }

    @RequestMapping("/deleteQuestionByQuestionId")
    public int deleteQuestionByQuestionId(int questionId){
        return questionService.deleteQuestionByQuestionId(questionId);
    }

    @RequestMapping("/deleteQuestionByHomeworkId")
    public int deleteQuestionByHomeworkId(int homeworkId){
        return questionService.deleteQuestionByHomeworkId(homeworkId);
    }
}
