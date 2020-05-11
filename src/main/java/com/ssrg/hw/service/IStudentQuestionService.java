package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentQuestionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentQuestionService {

	StudentQuestionDto querySQBySIdAndQId(int studentId,int questionId);

	int addSQ(StudentQuestionDto studentQuestionDto);

	int deleteSQ(int homeworkId);

	int updateSQ(StudentQuestionDto studentQuestionDto);

	int submitQuestion(int studentId, int questionId, String answer);
}
