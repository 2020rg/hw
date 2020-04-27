package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.mapper.CourseMapper;
import com.ssrg.hw.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDto> queryCourseByTeacherId(int teacherId){
        return  courseMapper.queryCourseByTeacherId(teacherId);
    }

    @Override
    public CourseDto queryCourseByCourseId(int courseId){
        return courseMapper.queryCourseByCourseId(courseId);
    }

    @Override
    public CourseDto queryCourseByInviteCode(String inviteCode){
        return courseMapper.queryCourseByInviteCode(inviteCode);
    }

    @Override
    public int addCourse(CourseDto courseDto){
        courseMapper.addCourse(courseDto);
        return 1;
    }

    @Override
    public int deleteCourse(int courseId){
        courseMapper.deleteCourse(courseId);
        return 1;
    }

    @Override
    public int updateCourse(CourseDto courseDto){
        courseMapper.updateCourse(courseDto);
        return 1;
    }
}
