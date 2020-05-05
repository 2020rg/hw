package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentHomeworkDto;

import java.util.List;

public interface IStudentHomeworkService {

    List<StudentHomeworkDto> querySHByStudentId(int studentId);

    StudentHomeworkDto querySHByHomeworkId(int homeworkId);

    StudentHomeworkDto querySHByStudentHomeworkId(int studentHomeworkId);

    int addSH(StudentHomeworkDto studentHomeworkDto);

    int deleteSH(int studentHomeworkId);

    int updateSH(StudentHomeworkDto studentHomeworkDto);
}
