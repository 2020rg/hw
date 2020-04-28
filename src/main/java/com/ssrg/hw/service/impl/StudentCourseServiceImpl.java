package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.mapper.StudentCourseMapper;
import com.ssrg.hw.service.IStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements IStudentCourseService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Override
    public List<StudentDto> queryCourseAllStudent(int courseId){
        return studentCourseMapper.queryCourseAllStudent(courseId);
    }

    @Override
    public List<CourseDto> queryStudentAllCourse(int studentId){
        return studentCourseMapper.queryStudentAllCourse(studentId);
    }

    @Override
    public int courseSelection(int studentId,int courseId){
        return studentCourseMapper.courseSelection(studentId,courseId);
    }

    @Override
    public int cancelCourse(int studentId,int courseId){
        return studentCourseMapper.cancelCourse(studentId,courseId);
    }
}
