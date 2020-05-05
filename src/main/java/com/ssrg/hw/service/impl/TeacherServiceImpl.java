package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.TeacherDto;
import com.ssrg.hw.mapper.TeacherMapper;
import com.ssrg.hw.service.ICourseService;
import com.ssrg.hw.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherDto> queryTeacherList(){
        return  teacherMapper.queryTeacherList();
    }

    @Override
    public TeacherDto queryTeacherByPhone(int phone){
        return teacherMapper.queryTeacherByPhone(phone);
    }

    @Override
    public TeacherDto queryTeacherByTeacherId(int teacherId){
        return teacherMapper.queryTeacherByTeacherId(teacherId);
    }

    @Override
    public int addTeacher(TeacherDto teacherDto){
        teacherMapper.addTeacher(teacherDto);
        return 1;
    }

    @Override
    public int deleteTeacher(int teacherId){
        teacherMapper.deleteTeacher(teacherId);
        return 1;
    }

    @Override
    public int updateTeacher(TeacherDto teacherDto){
        teacherMapper.updateTeacher(teacherDto);
        return 1;
    }
}
