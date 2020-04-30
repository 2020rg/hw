package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.TeacherDto;
import com.ssrg.hw.mapper.TeacherMapper;
import com.ssrg.hw.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<TeacherDto> queryTeacherList(){
        return  TeacherMapper.queryTeacherList();
    }

    @Override
    public TeacherDto queryTeacherByPhone(int phone){
        return TeacherMapper.queryTeacherBySchool(phone));
    }

    @Override
    public TeacherDto queryTeacherByTeacherId(int teacherId){
        return TeacherMapper.queryTeacherByTeacherId(teacherId);
    }

    @Override
    public int addTeacher(TeacherDto teacherDto){
        TeacherMapper.addTeacher(teacherDto);
        return 1;
    }

    @Override
    public int deleteTeacher(int teacherId){
        TeacherMapper.deleteTeacher(teacherId);
        return 1;
    }

    @Override
    public int updateTeacher(TeacherDto teacherDto){
        TeacherMapper.updateTeacher(teacherDto);
        return 1;
    }
}
