package com.ssrg.hw.mapper;

import com.ssrg.hw.dto.TeacherCourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherCourseMapper {

    /**
     * 查询所有课程
     * @return
     */
    List<TeacherCourseDto> queryTeacherCourseList();

    /**
     * 根据teacherID查询该老师的所有课程
     * @param teacherId
     * @return
     */
    List<TeacherCourseDto> queryTeacherCourseByTeacherId(int teacherId);

    /**
     * 根据courseID查询课程
     * @param courseId
     * @return
     */
    List<TeacherCourseDto> queryTeacherCourseByCourseId(int courseId);

    /**
     * 根据teacher_course_id查询课程
     * @param teacher_course_id
     * @return
     */
    TeacherCourseDto queryTeacherCourseByTeacherCourseId(int teacher_course_id);

    /**
     * 添加一位老师的一个课程
     * @param teacherCourseDto
     * @return
     */
    int addTeacherCourse(TeacherCourseDto teacherCourseDto);

    /**
     * 更新一个老师的一个课程
     * @param teacherCourseDto
     * @return
     */
    int updateTeacherCourse(TeacherCourseDto teacherCourseDto);

    /**
     * 删除一个老师的一个课程
     * @param teacher_course_id
     * @return
     */
    int deleteTeacherCourse(int teacher_course_id);
}
