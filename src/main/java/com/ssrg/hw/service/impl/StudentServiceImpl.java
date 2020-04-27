package com.ssrg.hw.service.impl;


import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.mapper.StudentMapper;
import com.ssrg.hw.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDto> queryStudentList(){
        return studentMapper.queryStudentList();
    }

    @Override
    public StudentDto queryStudentById(int studentId){
        return studentMapper.queryStudentById(studentId);
    }

    @Override
    public StudentDto queryStudentByPhone(int phone){
        return studentMapper.queryStudentByPhone(phone);
    }

    @Override
    public int addStudent(StudentDto studentDto){
        studentMapper.addStudent(studentDto);
        return 1;
    }

    @Override
    public int updateStudent(StudentDto studentDto){
        studentMapper.updateStudent(studentDto);
        return 1;
    }

    @Override
    public int deleteStudent(int studentId){
        studentMapper.deleteStudent(studentId);
        return 1;
    }

}
