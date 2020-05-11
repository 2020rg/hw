package com.ssrg.hw.controller;

import com.ssrg.hw.dto.TeacherCourseDto;
import com.ssrg.hw.service.ITeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherCourseController {

    @Autowired
    private ITeacherCourseService teacherCourseService;

    @GetMapping("/queryTeacherCourseList")
    public List<TeacherCourseDto> queryTeacherCourseList()
    {
        List<TeacherCourseDto> teacherCourseList=teacherCourseService.queryTeacherCourseList();
        return  teacherCourseList;
    }

    @GetMapping("/queryTeacherCourseByTeacherId")
    public List<TeacherCourseDto> queryTeacherCourseByTeacherId(int teacherId)
    {
        List<TeacherCourseDto> teacherCourseList=teacherCourseService.queryTeacherCourseByTeacherId(teacherId);
        return  teacherCourseList;
    }

    @GetMapping("/queryTeacherCourseByCourseId")
    public List<TeacherCourseDto> queryTeacherCourseByCourseId(int courseId)
    {
        List<TeacherCourseDto> teacherCourseList=teacherCourseService.queryTeacherCourseByCourseId(courseId);
        return  teacherCourseList;
    }

    @GetMapping("/queryTeacherCourseByTeacherCourseId")
    public TeacherCourseDto queryTeacherCourseByTeacherCourseId(int teacher_course_id)
    {
        TeacherCourseDto teacherCourseDto=teacherCourseService.queryTeacherCourseByTeacherCourseId(teacher_course_id);
        return teacherCourseDto;
    }

    @GetMapping("/addTeacherCourse")
    public int addTeacherCourse(TeacherCourseDto teacherCourseDto)
    {
        teacherCourseService.addTeacherCourse(teacherCourseDto);
        return 1;
    }

    @GetMapping("/updateTeacherCourse")
    public int updateTeacherCourse(TeacherCourseDto teacherCourseDto)
    {
        teacherCourseService.updateTeacherCourse(teacherCourseDto);
        return 1;
    }

    @GetMapping("/deleteTeacherCourse")
    public int deleteTeacherCourse(int teacher_course_id)
    {
        teacherCourseService.deleteTeacherCourse(teacher_course_id);
        return 1;
    }

}
