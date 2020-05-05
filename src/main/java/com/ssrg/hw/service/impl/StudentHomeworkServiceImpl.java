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
    public List<StudentHomeworkDto> querySHByStudentId(int studentId){
        return  StudentHomeworkMapper.querySHByStudentId(studentId);
    }

    @Override
    public StudentHomeworkDto querySHByHomeworkId(int homeworkId){
        return StudentHomeworkMapper.querySHByHomeworkId(homeworkId);
    }

    @Override
    public StudentHomeworkDto querySHByStudentHomeworkId(int studentHomeworkId){
        return StudentHomeworkMapper.querySHByStudentHomeworkId(studentHomeworkId);
    }

    @Override
    public int addSH(StudentHomeworkDto studentHomeworkDto){
        StudentHomeworkMapper.addSH(studentHomeworkDto);
        return 1;
    }

    @Override
    public int deleteSH(int studentHomeworkId){
        StudentHomeworkMapper.deleteSH(studentHomeworkId);
        return 1;
    }

    @Override
    public int updateSH(StudentHomeworkDto studentHomeworkDto){
        StudentHomeworkMapper.updateSH(studentHomeworkDto);
        return 1;
    }
}
