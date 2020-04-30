package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.StudentHomeworkDto;
import com.ssrg.hw.mapper.StudentHomeworkMapper;
import com.ssrg.hw.service.IStudentHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentHomeworkServiceImpl implements IStudentHomeworkService {

    @Autowired
    private StudentHomeworkMapper StudentHomeworkMapper;

    @Override
    public List<StudentHomeworkDto> queryStudentHomeworkByStudentId(int studentId){
        return  StudentHomeworkMapper.queryStudentHomeworkByStudentId(studentId);
    }

    @Override
    public StudentHomeworkDto queryStudentHomeworkByHomeworkId(int homeworkId){
        return StudentHomeworkMapper.queryStudentHomeworkByHomeworkId(homeworkId);
    }

    @Override
    public StudentHomeworkDto queryStudentHomeworkByStudentHomeworkId(int studentHomeworkId){
        return StudentHomeworkMapper.queryStudentHomeworkByStudentHomeworkId(studentHomeworkId);
    }

    @Override
    public int addStudentHomework(StudentHomeworkDto studentHomeworkDto){
        StudentHomeworkMapper.addStudentHomework(studentHomeworkDto);
        return 1;
    }

    @Override
    public int deleteStudentHomework(int studentHomeworkId){
        StudentHomeworkMapper.deleteStudentHomework(studentHomeworkId);
        return 1;
    }

    @Override
    public int updateStudentHomework(StudentHomeworkDto studentHomeworkDto){
        StudentHomeworkMapper.updateStudentHomework(studentHomeworkDto);
        return 1;
    }
}
