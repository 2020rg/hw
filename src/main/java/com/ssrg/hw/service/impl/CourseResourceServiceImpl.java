package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.CourseResourceDto;
import com.ssrg.hw.mapper.CourseResourceMapper;
import com.ssrg.hw.service.ICourseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseResourceServiceImpl implements ICourseResourceService {

    @Autowired
    private CourseResourceMapper courseResourceMapper;

    @Override
    public List<CourseResourceDto> queryCourseResourceList() {
        return courseResourceMapper.queryCourseResourceList();
    }

    @Override
    public List<CourseResourceDto> queryCourseResourceByCourseId(int courseId) {
        return courseResourceMapper.queryCourseResourceByCourseId(courseId);
    }

    @Override
    public List<CourseResourceDto> queryCourseResourceByResourceName(String resourceName) {
        return courseResourceMapper.queryCourseResourceByResourceName(resourceName);
    }

    @Override
    public CourseResourceDto queryCourseResourceByResourceId(int resourceId) {
        return courseResourceMapper.queryCourseResourceByResourceId(resourceId);
    }

    @Override
    public int addCourseResource(CourseResourceDto courseResourceDto) {
        courseResourceMapper.addCourseResource(courseResourceDto);
        return 1;
    }

    @Override
    public int updateCourseResource(CourseResourceDto courseResourceDto) {
        courseResourceMapper.updateCourseResource(courseResourceDto);
        return 1;
    }

    @Override
    public int deleteCourseResource(int resourceId) {
        courseResourceMapper.deleteCourseResource(resourceId);
        return 1;
    }
}
