package com.ssrg.hw.service;

import com.ssrg.hw.dto.QuestionDto;

import java.util.List;

public interface IQuestionService {

    List<QuestionDto> queryQuestionByHomeworkId(int homeworkId);

    QuestionDto queryQuestionByQuestionId(int questionId);

    int addQuestion(QuestionDto questionDto);

    int updateQuestion(int questionId,String content);

    int deleteQuestionByQuestionId(int questionId);

    int deleteQuestionByHomeworkId(int homeworkId);
}
