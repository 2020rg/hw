package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.QuestionDto;
import com.ssrg.hw.mapper.QuestionMapper;
import com.ssrg.hw.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<QuestionDto> queryQuestionByHomeworkId(int homeworkId){
        return questionMapper.queryQuestionByHomeworkId(homeworkId);
    }

    @Override
    public QuestionDto queryQuestionByQuestionId(int questionId){
        return questionMapper.queryQuestionByQuestionId(questionId);
    }

    @Override
    public int addQuestion(QuestionDto questionDto){
        return questionMapper.addQuestion(questionDto);
    }

    @Override
    public int updateQuestion(int questionId,String content){
        return questionMapper.updateQuestion(questionId,content);
    }

    @Override
    public int deleteQuestionByQuestionId(int questionId){
        return questionMapper.deleteQuestionByQuestionId(questionId);
    }

    @Override
    public int deleteQuestionByHomeworkId(int homeworkId){
        return questionMapper.deleteQuestionByHomeworkId(homeworkId);
    }
}
