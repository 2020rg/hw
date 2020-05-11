package com.ssrg.hw.service;

import com.ssrg.hw.dto.TeacherCourseDto;

import java.util.List;

public interface ITeacherCourseService {

    List<TeacherCourseDto> queryTeacherCourseList();

    List<TeacherCourseDto> queryTeacherCourseByTeacherId(int teacherId);

    List<TeacherCourseDto> queryTeacherCourseByCourseId(int courseId);

    TeacherCourseDto queryTeacherCourseByTeacherCourseId(int teacher_course_id);

    int addTeacherCourse(TeacherCourseDto teacherCourseDto);

    int updateTeacherCourse(TeacherCourseDto teacherCourseDto);

    int deleteTeacherCourse(int teacher_course_id);



}
