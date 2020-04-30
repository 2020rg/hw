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
    public List<StudentQuestionDto> queryStudentQuestionByStudentId(int studentId){
        return  StudentQuestionMapper.queryStudentQuestionByStudentId(studentId);
    }

    @Override
    public StudentQuestionDto queryStudentQuestionByStudentQuestionId(int studentQuestionId){
        return StudentQuestionMapper.queryStudentQuestionByStudentQuestionId(studentQuestionId);
    }

    @Override
    public int addStudentQuestion(StudentQuestionDto studentQuestionDto){
        StudentQuestionMapper.addStudentQuestion(studentQuestionDto);
        return 1;
    }

    @Override
    public int deleteStudentQuestion(int studentQuestionId){
        StudentQuestionMapper.deleteStudentQuestion(studentQuestionId);
        return 1;
    }

    @Override
    public int updateStudentQuestion(StudentQuestionDto studentQuestionDto){
        StudentQuestionMapper.updateStudentQuestion(studentQuestionDto);
        return 1;
    }
}
