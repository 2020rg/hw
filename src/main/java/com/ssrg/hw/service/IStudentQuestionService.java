package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentQuestionDto;

import java.util.List;

public interface IStudentQuestionService {
	
	StudentQuestionDto querySQByStudentQuestionId(int studentQuestionId);

	int addSQ(StudentQuestionDto studentQuestionDto);

	int deleteSQ(int homeworkId);

	int updateSQ(StudentQuestionDto studentQuestionDto);
}
