package com.ssrg.hw.controller;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/queryCourseByTeacherId")
    public List<CourseDto> queryCourseByTeacherId(int teacherId){
        List<CourseDto> courseList = courseService.queryCourseByTeacherId(teacherId);
        return courseList;
    }

    @GetMapping("/queryCourseByCourseId")
    public CourseDto queryCourseByCourseId(int courseId){
        CourseDto course = courseService.queryCourseByCourseId(courseId);
        return course;
    }

    @GetMapping("/queryCourseByInviteCode")
    public CourseDto queryCourseByInviteCode(String inviteCode){
        CourseDto course = courseService.queryCourseByInviteCode(inviteCode);
        return course;
    }

    @GetMapping("/addCourse")
    public int addCourse(CourseDto courseDto){
        courseService.addCourse(courseDto);
        return 1;
    }

    @GetMapping("/deleteCourse")
    public int deleteCourse(int courseId){
        courseService.deleteCourse(courseId);
        return 1;
    }

    @GetMapping("/updateCourse")
    public int updateCourse(CourseDto courseDto){
        courseService.updateCourse(courseDto);
        return 1;
    }
}
