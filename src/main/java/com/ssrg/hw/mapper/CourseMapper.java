package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.CourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    /**
     * 查询教师的所有课程
     * @param teacherId
     * @return
     */
    List<CourseDto> queryCourseByTeacherId(int teacherId);

    /**
     * 根据课程ID查询课程
     * @param courseId
     * @return
     */
    CourseDto queryCourseByCourseId(int courseId);

    /**
     * 根据邀请码查询课程
     * @param inviteCode
     * @return
     */
    CourseDto queryCourseByInviteCode(String inviteCode);

    /**
     * 添加课程
     * @param courseDto
     * @return
     */
    int addCourse(CourseDto courseDto);

    /**
     * 删除课程
     * @param courseId
     * @return
     */
    int deleteCourse(int courseId);

    /**
     * 修改课程信息
     * @param courseDto
     * @return
     */
    int updateCourse(CourseDto courseDto);
}
