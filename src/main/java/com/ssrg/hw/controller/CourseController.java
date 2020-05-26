package com.ssrg.hw.controller;


import com.ssrg.hw.dto.*;
import com.ssrg.hw.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    private ICourseResourceService courseResourceService;

    @Autowired
    private IStudentCourseService studentCourseService;


    @RequestMapping("/queryCourseByTeacherId")
    public Map<String,Object> queryCourseByTeacherId(HttpServletRequest request){
        int teacherId = (int)request.getSession().getAttribute("userId");
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> courseList = new ArrayList<>();

        int StudentNum = 0;

        List<CourseDto> tcourseList = courseService.queryCourseByTeacherId(teacherId);
        CourseDto courseDto;

        for (CourseDto c: tcourseList) {
            List<StudentDto> studentList = studentCourseService.queryCourseAllStudent(c.getCourseId());
            Map<String,Object> course = new HashMap<>();
            courseDto = courseService.queryCourseByCourseId(c.getCourseId());
            StudentNum = studentList.size();

            course.put("courseName",courseDto.getCourseName());
            course.put("teacherName",teacherService.queryTeacherByTeacherId(teacherId).getName());
            course.put("studentNum",StudentNum);

            courseList.add(course);
        }

        result.put("courseList",courseList);

        return result;
    }

    @RequestMapping("/queryCourseByCourseId")
    public Map<String,Object> queryCourseByCourseId(@RequestParam("courseId") int courseId){
        Map<String,Object> result = new HashMap<>();
        CourseDto course = courseService.queryCourseByCourseId(courseId);
        TeacherDto teacher = teacherService.queryTeacherByTeacherId(course.getTeacherId());
        List<CourseResourceDto> resourceList = courseResourceService.queryCourseResourceByCourseId(courseId);
        List<HomeworkDto> homeworkList = homeworkService.queryHomeworkByCourseId(courseId);
        result.put("teacherName",teacher.getName());
        result.put("courseName",course.getCourseName());
        result.put("homeworkList",homeworkList);
        result.put("resourceList",resourceList);

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
