package com.ssrg.hw.controller;


import com.ssrg.hw.dto.TeacherDto;
import com.ssrg.hw.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @GetMapping("/queryTeacherList")
    public List<TeacherDto> queryTeacherList(){
        List<TeacherDto> teacherList = TeacherService.queryTeacherList();
        return teacherList;
    }

    @GetMapping("/queryTeacherByPhone")
    public List<TeacherDto> queryTeacherByPhone(int phone){
        TeacherDto teacher = TeacherService.queryTeacherByPhone(phone);
        return teacher;
    }

    @GetMapping("/queryTeacherByTeacherId")
    public TeacherDto queryTeacherByTeacherId(int teacherId){
        TeacherDto teacher = TeacherService.queryTeacherByTeacherId(teacherId);
        return teacher;
    }

    @GetMapping("/addTeacher")
    public int addCourse(TeacherDto teacherDto){
        TeacherService.addCourse(teacherDto);
        return 1;
    }

    @GetMapping("/deleteTeacher")
    public int deleteCourse(int teacherId){
        TeacherService.deleteTeacher(teacherId);
        return 1;
    }

    @GetMapping("/updateTeacher")
    public int updateCourse(TeacherDto teacherDto){
        TeacherService.updateTeacher(teacherDto);
        return 1;
    }
}
