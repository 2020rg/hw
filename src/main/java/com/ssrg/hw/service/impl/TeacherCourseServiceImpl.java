package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.TeacherCourseDto;
import com.ssrg.hw.mapper.TeacherCourseMapper;
import com.ssrg.hw.service.ITeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherCourseServiceImpl implements ITeacherCourseService
{

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;


    @Override
    public List<TeacherCourseDto> queryTeacherCourseList() {
        return teacherCourseMapper.queryTeacherCourseList();
    }

    @Override
    public List<TeacherCourseDto> queryTeacherCourseByTeacherId(int teacherId) {
        return teacherCourseMapper.queryTeacherCourseByTeacherId(teacherId);
    }

    @Override
    public List<TeacherCourseDto> queryTeacherCourseByCourseId(int courseId) {
        return teacherCourseMapper.queryTeacherCourseByCourseId(courseId);
    }

    @Override
    public TeacherCourseDto queryTeacherCourseByTeacherCourseId(int teacher_course_id) {
        return teacherCourseMapper.queryTeacherCourseByTeacherCourseId(teacher_course_id);
    }

    @Override
    public int addTeacherCourse(TeacherCourseDto teacherCourseDto) {
        teacherCourseMapper.addTeacherCourse(teacherCourseDto);
        return 1;
    }

    @Override
    public int updateTeacherCourse(TeacherCourseDto teacherCourseDto) {
        teacherCourseMapper.updateTeacherCourse(teacherCourseDto);
        return 1;
    }

    @Override
    public int deleteTeacherCourse(int teacher_course_id) {
        teacherCourseMapper.deleteTeacherCourse(teacher_course_id);
        return 1;
    }
}
