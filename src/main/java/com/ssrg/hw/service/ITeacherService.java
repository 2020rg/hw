package com.ssrg.hw.service;

import com.ssrg.hw.dto.TeacherDto;

import java.util.List;

public interface ITeacherService {

	List<TeacherDto> queryTeacherList();

	TeacherDto queryTeacherByTeacherId(int teacherId);
	
	TeacherDto queryTeacherByPhone(int phone);

	int addTeacher(TeacherDto teacherDto);

	int deleteTeacher(int teacherId);

	int updateCourse(TeacherDto teacherDto);
}
