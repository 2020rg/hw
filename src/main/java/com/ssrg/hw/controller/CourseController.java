package com.ssrg.hw.controller;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.dto.TeacherDto;
import com.ssrg.hw.service.ICourseService;
import com.ssrg.hw.service.IHomeworkService;
import com.ssrg.hw.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IHomeworkService homeworkService;



    @RequestMapping("/queryCourseByTeacherId")
    public List<CourseDto> queryCourseByTeacherId(int teacherId){
        List<CourseDto> courseList = courseService.queryCourseByTeacherId(teacherId);
        return courseList;
    }

    @RequestMapping("/queryCourseByCourseId")
    public Map<String,Object> queryCourseByCourseId(@RequestParam("courseId") int courseId){
        Map<String,Object> result = new HashMap<>();
        CourseDto course = courseService.queryCourseByCourseId(courseId);
        TeacherDto teacher = teacherService.queryTeacherByTeacherId(course.getTeacherId());
        List<HomeworkDto> homeworkList = homeworkService.queryHomeworkByCourseId(courseId);
        result.put("teacherName",teacher.getName());
        result.put("courseName",course.getCourseName());
        result.put("homeworkList",homeworkList);

        return result;
    }

    @RequestMapping("/queryCourseByInviteCode")
    public CourseDto queryCourseByInviteCode(String inviteCode){
        CourseDto course = courseService.queryCourseByInviteCode(inviteCode);
        return course;
    }

    @RequestMapping("/addCourse")
    public int addCourse(CourseDto courseDto){
        courseService.addCourse(courseDto);
        return 1;
    }

    @RequestMapping("/deleteCourse")
    public int deleteCourse(int courseId){
        courseService.deleteCourse(courseId);
        return 1;
    }

    @RequestMapping("/updateCourse")
    public int updateCourse(CourseDto courseDto){
        courseService.updateCourse(courseDto);
        return 1;
    }
}
