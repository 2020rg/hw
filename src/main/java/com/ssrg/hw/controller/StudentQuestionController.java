package com.ssrg.hw.controller;


import com.ssrg.hw.dto.QuestionDto;
import com.ssrg.hw.dto.StudentQuestionDto;
import com.ssrg.hw.service.IHomeworkService;
import com.ssrg.hw.service.IQuestionService;
import com.ssrg.hw.service.IStudentHomeworkService;
import com.ssrg.hw.service.IStudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sq")
public class StudentQuestionController {

    @Autowired
    private IStudentQuestionService StudentQuestionService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IStudentHomeworkService studentHomeworkService;

    @RequestMapping("/querySubmitOk")
    public Map<String,Object> querySubmitOk(@RequestParam("homeworkId")int homeworkId, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        int studentId = (int)request.getSession().getAttribute("userId");
        List<QuestionDto> questionDto = questionService.queryQuestionByHomeworkId(homeworkId);
        List<Map<String,Object>> questionList = new ArrayList<>();
        for(QuestionDto q:questionDto){
            StudentQuestionDto studentQuestionDto = StudentQuestionService.querySQBySIdAndQId(studentId,q.getQuestionId());
            Map<String,Object> temp = new HashMap<>();
            temp.put("questionID",q.getQuestionId());
            temp.put("questionContent",q.getContent());
            temp.put("answer",studentQuestionDto.getAnswer());
            questionList.add(temp);
        }
        result.put("questionList",questionList);
        return result;
    }

    @RequestMapping("/queryChecked")
    public Map<String,Object> queryChecked(@RequestParam("homeworkId")int homeworkId, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        int studentId = (int)request.getSession().getAttribute("userId");
        List<QuestionDto> questionDto = questionService.queryQuestionByHomeworkId(homeworkId);
        List<Map<String,Object>> questionList = new ArrayList<>();
        int scoreAll = 0;
        for(QuestionDto q:questionDto){
            StudentQuestionDto studentQuestionDto = StudentQuestionService.querySQBySIdAndQId(studentId,q.getQuestionId());
            Map<String,Object> temp = new HashMap<>();
            temp.put("questionID",q.getQuestionId());
            temp.put("questionContent",q.getContent());
            temp.put("answer",studentQuestionDto.getAnswer());
            temp.put("score",studentQuestionDto.getScore());
            scoreAll += studentQuestionDto.getScore();
            questionList.add(temp);
        }
        result.put("scoreAll",scoreAll);
        result.put("questionList",questionList);
        return result;
    }

    @RequestMapping("/querySQByStudentQuestionId")
    public StudentQuestionDto querySQByStudentQuestionId(int studentId,int questionId){
        StudentQuestionDto StudentQuestion = StudentQuestionService.querySQBySIdAndQId(studentId, questionId);
        return StudentQuestion;
    }

    @RequestMapping("/addSQ")
    public int addSQ(StudentQuestionDto studentQuestionDto){
        StudentQuestionService.addSQ(studentQuestionDto);
        return 1;
    }

    @RequestMapping("/deleteSQ")
    public int deleteSQ(int studentQuestionId){
        StudentQuestionService.deleteSQ(studentQuestionId);
        return 1;
    }

    @RequestMapping("/updateSQ")
    public int updateSQ(StudentQuestionDto studentQuestionDto){
        StudentQuestionService.updateSQ(studentQuestionDto);
        return 1;
    }

    @RequestMapping("/submitQuestion")
    public Map<String,Object> submitQuestion(@RequestParam("questionId") int questionId, @RequestParam("answer") String answer,HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        int flag = StudentQuestionService.submitQuestion(studentId, questionId, answer);
        Map<String,Object> result = new HashMap<>();
        result.put("flag",flag);
        return result;
    }

    @RequestMapping("/submitAllQuestion")
    public Map<String,Object> submitAllQuestion(@RequestBody Map sq,
                                                HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        int homeworkId = Integer.parseInt(sq.get("homeworkID").toString());
        Map<String,Object> result = new HashMap<>();
        List<QuestionDto> question = questionService.queryQuestionByHomeworkId(homeworkId);
        List<String> questionS = new ArrayList<>();

        for(QuestionDto q:question){
            questionS.add(String.valueOf(q.getQuestionId()));
        }

        int flag = 0;

        for(String q:questionS){
            flag = StudentQuestionService.submitQuestion(studentId,Integer.parseInt(q),sq.get(q).toString());
            if(flag == 0){
                result.put("flag",flag);
                return result;
            }
        }
        studentHomeworkService.updateSHSubmit(studentId,homeworkId,"true");
        result.put("flag",flag);
        return result;
    }
}
