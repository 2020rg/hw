package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentQuestionDto;

import java.util.List;

public interface ICourseService {

	List<StudentQuestionDto> queryStudentQuestionByStudentId(int studentId);
	
	StudentQuestionDto queryStudentQuestionByStudentQuestion(int studentQuestionId);

	int addStudentQuestion(StudentQuestionDto studentQuestionDto);

	int deleteQuestion(int studentQuestionId);

	int updateStudentQuestion(StudentQuestionDto studentQuestionDto);
}
