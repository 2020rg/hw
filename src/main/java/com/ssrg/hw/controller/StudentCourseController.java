package com.ssrg.hw.controller;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.service.IStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentCourseController {

    @Autowired
    private IStudentCourseService studentCourseService;

    @GetMapping("/queryCourseAllStudent")
    public List<StudentDto> queryCourseAllStudent(int courseId){
        return studentCourseService.queryCourseAllStudent(courseId);
    }

    @GetMapping("/queryStudentAllCourse")
    public List<CourseDto> queryStudentAllCourse(int studentId){
        return studentCourseService.queryStudentAllCourse(studentId);
    }

    @GetMapping("/courseSelection")
    public int courseSelection(int studentId,int courseId){
        return studentCourseService.courseSelection(studentId,courseId);
    }

    @GetMapping("/cancelCourse")
    public int cancelCourse(int studentId,int courseId){
        return studentCourseService.cancelCourse(studentId,courseId);
    }
}
