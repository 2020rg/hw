package com.ssrg.hw.controller;


import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/queryStudentById")
    public StudentDto queryStudentById(HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        StudentDto studentDto = studentService.queryStudentById(studentId);
        return studentDto;
    }

    @RequestMapping("/queryStudentByPhone")
    public StudentDto queryStudentByPhone(int phone){
        StudentDto studentDto = studentService.queryStudentByPhone(phone);
        return studentDto;
    }

    @RequestMapping("/addStudent")
    public int addStudent(StudentDto studentDto){
        studentService.addStudent(studentDto);
        return 1;
    }

    @RequestMapping("/updateStudent")
    public int updateStudent(StudentDto studentDto){
        studentService.updateStudent(studentDto);
        return 1;
    }

    @RequestMapping("/deleteStudent")
    public int deleteStudent(int studentId){
        studentService.deleteStudent(studentId);
        return 1;
    }
}
