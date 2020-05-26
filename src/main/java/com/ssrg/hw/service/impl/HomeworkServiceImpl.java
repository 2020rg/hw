package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.mapper.HomeworkMapper;
import com.ssrg.hw.service.IHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class HomeworkServiceImpl implements IHomeworkService {

    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public HomeworkDto queryHomeworkByHomeworkId(int homeworkId){
        return homeworkMapper.queryHomeworkByHomeworkId(homeworkId);
    }

    @Override
    public List<HomeworkDto> queryHomeworkByCourseId(int courseId){
        return homeworkMapper.queryHomeworkByCourseId(courseId);
    }

    @Override
    public int addHomework(HomeworkDto homeworkDto){
        homeworkMapper.addHomework(homeworkDto);
        return 1;
    }

    @Override
    public int deleteHomeworkByHomeworkId(int homeworkId){
        homeworkMapper.deleteHomeworkByHomeworkId(homeworkId);
        return 1;
    }

    @Override
    public int deleteHomeworkByCourseId(int courseId){
        homeworkMapper.deleteHomeworkByCourseId(courseId);
        return 1;
    }

    @Override
    public int updateHomework(HomeworkDto homeworkDto){
        homeworkMapper.updateHomework(homeworkDto);
        return 1;
    }

    @Override
    public int publishHomework(int teacherId, int courseId, String title, String introduce, Timestamp ddl){
        return homeworkMapper.publishHomework(teacherId, courseId, title, introduce, ddl);
    }
}
