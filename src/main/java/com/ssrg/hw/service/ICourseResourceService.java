package com.ssrg.hw.service;

import com.ssrg.hw.dto.CourseResourceDto;

import java.util.List;

public interface ICourseResourceService {

    List<CourseResourceDto> queryCourseResourceList();

    List<CourseResourceDto> queryCourseResourceByCourseId(int courseId);

    List<CourseResourceDto> queryCourseResourceByResourceName(String resourceName);

    CourseResourceDto queryCourseResourceByResourceId(int resourceId);

    int addCourseResource(CourseResourceDto courseResourceDto);

    int updateCourseResource(CourseResourceDto courseResourceDto);

    int deleteCourseResource(int resourceId);
}
