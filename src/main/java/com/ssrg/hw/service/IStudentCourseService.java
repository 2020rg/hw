package com.ssrg.hw.service;

import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.StudentDto;

import java.util.List;

public interface IStudentCourseService {

    List<StudentDto> queryCourseAllStudent(int courseId);

    List<CourseDto> queryStudentAllCourse(int studentId);

    int courseSelection(int studentId,int courseId);

    int cancelCourse(int studentId,int courseId);
}
