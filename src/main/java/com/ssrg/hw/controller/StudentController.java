package com.ssrg.hw.controller;


import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/queryStudentList")
    public List<StudentDto> queryStudentList(){
        List<StudentDto> studentList = studentService.queryStudentList();
        return studentList;
    }

    @GetMapping("/queryStudentById")
    public StudentDto queryStudentById(int studentId){
        StudentDto studentDto = studentService.queryStudentById(studentId);
        return studentDto;
    }

    @GetMapping("/queryStudentByPhone")
    public StudentDto queryStudentByPhone(int phone){
        StudentDto studentDto = studentService.queryStudentByPhone(phone);
        return studentDto;
    }

    @GetMapping("/addStudent")
    public int addStudent(StudentDto studentDto){
        studentService.addStudent(studentDto);
        return 1;
    }

    @GetMapping("/updateStudent")
    public int updateStudent(StudentDto studentDto){
        studentService.updateStudent(studentDto);
        return 1;
    }

    @GetMapping("/deleteStudent")
    public int deleteStudent(int studentId){
        studentService.deleteStudent(studentId);
        return 1;
    }
}
