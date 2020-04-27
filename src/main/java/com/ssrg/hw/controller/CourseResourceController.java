package com.ssrg.hw.controller;

import com.ssrg.hw.dto.CourseResourceDto;
import com.ssrg.hw.service.ICourseResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseResourceController {

    @Autowired
    private ICourseResourceService courseResourceService;

    @GetMapping("/queryCourseResourceList")
    public List<CourseResourceDto> queryCourseResourceList()
    {
        List<CourseResourceDto> courseResourceList=courseResourceService.queryCourseResourceList();
        return courseResourceList;
    }

    @GetMapping("/queryCourseResourceByCourseId")
    public List<CourseResourceDto> queryCourseResourceByCourseId(int courseId)
    {
        List<CourseResourceDto> courseResourceList=courseResourceService.queryCourseResourceByCourseId(courseId);
        return courseResourceList;
    }

    @GetMapping("/queryCourseResourceByResourceName")
    public List<CourseResourceDto> queryCourseResourceByResourceName(String resourceName)
    {
        List<CourseResourceDto> courseResourceList=courseResourceService.queryCourseResourceByResourceName(resourceName);
        return courseResourceList;
    }

    @GetMapping("/queryCourseResourceByResourceId")
    public CourseResourceDto queryCourseResourceByResourceId(int resourceId)
    {
        CourseResourceDto courseResourceDto=courseResourceService.queryCourseResourceByResourceId(resourceId);
        return courseResourceDto;
    }

    @GetMapping("/addCourseResource")
    public int addCourseResource(CourseResourceDto courseResourceDto)
    {
        courseResourceService.addCourseResource(courseResourceDto);
        return 1;
    }

    @GetMapping("/updateCourseResource")
    public int updateCourseResource(CourseResourceDto courseResourceDto)
    {
        courseResourceService.updateCourseResource(courseResourceDto);
        return 1;
    }

    @GetMapping("/deleteCourseResource")
    public int deleteCourseResource(int resourceId)
    {
        courseResourceService.deleteCourseResource(resourceId);
        return 1;
    }

}
