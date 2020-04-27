package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentDto;

import java.util.List;

public interface IStudentService {

    List<StudentDto> queryStudentList();

    StudentDto queryStudentById(int studentId);

    StudentDto queryStudentByPhone(int phone);

    int addStudent(StudentDto studentDto);

    int updateStudent(StudentDto studentDto);

    int deleteStudent(int studentId);

}
