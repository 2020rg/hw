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

    List<StudentDto> queryCourseAllStudent(int courseId);

    List<CourseDto> queryStudentAllCourse(int studentId);

    int courseSelection(@Param("studentId")int studentId,@Param("courseId")int courseId);

    int cancelCourse(@Param("studentId")int studentId,@Param("courseId")int courseId);
}
