package com.ssrg.hw.service;

import com.ssrg.hw.dto.CourseDto;

import java.util.List;

public interface ICourseService {

    List<CourseDto> queryCourseByTeacherId(int teacherId);

    CourseDto queryCourseByCourseId(int courseId);

    CourseDto queryCourseByInviteCode(String inviteCode);

    int addCourse(CourseDto courseDto);

    int deleteCourse(int courseId);

    int updateCourse(CourseDto courseDto);
}
