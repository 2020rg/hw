package com.ssrg.hw.service;

import com.ssrg.hw.dto.HomeworkDto;

import java.sql.Timestamp;
import java.util.List;

public interface IHomeworkService {


    HomeworkDto queryHomeworkByHomeworkId(int homeworkId);

    List<HomeworkDto> queryHomeworkByCourseId(int courseId);

    int addHomework(HomeworkDto homeworkDto);

    int deleteHomeworkByHomeworkId(int homeworkId);

    int deleteHomeworkByCourseId(int courseId);

    int updateHomework(HomeworkDto homeworkDto);

    int publishHomework(int teacherId,int courseId, String title,String introduce, Timestamp ddl);
}
