package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.StudentQuestionDto;
import com.ssrg.hw.mapper.StudentQuestionMapper;
import com.ssrg.hw.service.IStudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentQuestionServiceImpl implements IStudentQuestionService {

    @Autowired
    private StudentQuestionMapper studentQuestionMapper;

    @Override
    public StudentQuestionDto querySQBySIdAndQId(int studentId,int questionId){
        return studentQuestionMapper.querySQBySIdAndQId(studentId,questionId);
    }

    @Override
    public int addSQ(StudentQuestionDto studentQuestionDto){
        studentQuestionMapper.addSQ(studentQuestionDto);
        return 1;
    }

    @Override
    public int deleteSQ(int homeworkId){
        studentQuestionMapper.deleteSQ(homeworkId);
        return 1;
    }

    @Override
    public int updateSQ(StudentQuestionDto studentQuestionDto){
        studentQuestionMapper.updateSQ(studentQuestionDto);
        return 1;
    }

    @Override
    public int submitQuestion(int studentId, int questionId, String answer){
        return studentQuestionMapper.submitQuestion(studentId, questionId, answer);
    }
}
