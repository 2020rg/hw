package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentHomeworkDto;

import java.util.List;

public interface IStudentHomeworkService {

    List<StudentHomeworkDto> queryStudentHomeworkByStudentId(int studentId);

    StudentHomeworkDto queryStudentHomeworkByHomeworkId(int homeworkId);

    StudentHomeworkDto queryStudentHomeworkByStudentHomeworkId(int studentHomeworkId);

    int addStudentHomework(StudentHomeworkDto studentHomeworkDto);

    int deleteStudentHomework(int studentHomeworkId);

    int updateStudentHomework(StudentHomeworkDto studentHomeworkDto);
}
