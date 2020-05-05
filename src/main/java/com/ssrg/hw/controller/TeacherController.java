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
        List<TeacherDto> teacherList = teacherService.queryTeacherList();
        return teacherList;
    }

    @GetMapping("/queryTeacherByPhone")
    public TeacherDto queryTeacherByPhone(int phone){
        TeacherDto teacher = teacherService.queryTeacherByPhone(phone);
        return teacher;
    }

    @GetMapping("/queryTeacherByTeacherId")
    public TeacherDto queryTeacherByTeacherId(int teacherId){
        TeacherDto teacher = teacherService.queryTeacherByTeacherId(teacherId);
        return teacher;
    }

    @GetMapping("/addTeacher")
    public int addTeacher(TeacherDto teacherDto){
        teacherService.addTeacher(teacherDto);
        return 1;
    }

    @GetMapping("/deleteTeacher")
    public int deleteTeacher(int teacherId){
        teacherService.deleteTeacher(teacherId);
        return 1;
    }

    @GetMapping("/updateTeacher")
    public int updateTeacher(TeacherDto teacherDto){
        teacherService.updateTeacher(teacherDto);
        return 1;
    }
}
