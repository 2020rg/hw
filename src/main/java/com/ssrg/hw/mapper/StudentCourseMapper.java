package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentCourseMapper {

    /**
     * 查询课程中的所有学生
     * @param courseId
     * @return
     */
    List<StudentDto> queryCourseAllStudent(int courseId);

    /**
     * 查询学生所选课程
     * @param studentId
     * @return
     */
    List<CourseDto> queryStudentAllCourse(int studentId);

    /**
     * 学生选课
     * @param studentId
     * @param courseId
     * @return
     */
    int courseSelection(@Param("studentId")int studentId,@Param("courseId")int courseId);

    /**
     * 学生撤课
     * @param studentId
     * @param courseId
     * @return
     */
    int cancelCourse(@Param("studentId")int studentId,@Param("courseId")int courseId);
}
