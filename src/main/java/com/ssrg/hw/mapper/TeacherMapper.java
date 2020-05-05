package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.TeacherDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    /**
     * 查询所有教师
     * @return
     */
	List<TeacherDto> queryTeacherList();

    /**
     * 根据教师ID查询教师
     * @param teacherId
     * @return
     */
    TeacherDto queryTeacherByTeacherId(int teacherId);
    
    /**
     * 根据电话查询教师
     * @param phone
     * @return
     */
    TeacherDto queryTeacherByPhone(int phone);

    /**
     * 添加教师
     * @param teacherDto
     * @return
     */
    int addTeacher(TeacherDto teacherDto);

    /**
     * 删除教师
     * @param teacherId
     * @return
     */
    int deleteTeacher(int teacherId);

    /**
     * 修改教师信息
     * @param teacherDto
     * @return
     */
    int updateTeacher(TeacherDto teacherDto);
}
