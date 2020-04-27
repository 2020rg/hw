package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.StudentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {


    /**
     * 查询所有学生
     * @return
     */
    List<StudentDto> queryStudentList();

    /**
     * 根据student_id 查询学生
     * @param studentId
     * @return
     */
    StudentDto queryStudentById(int studentId);

    /**
     * 根据电话号码查询学生
     * @param phone
     * @return
     */
    StudentDto queryStudentByPhone(int phone);

    /**
     * 添加学生
     * @param studentDto
     * @return
     */
    int addStudent(StudentDto studentDto);

    /**
     * 修改学生数据
     * @param studentDto
     * @return
     */
    int updateStudent(StudentDto studentDto);

    /**
     * 根据student_id 删除学生
     * @param studentId
     * @return
     */
    int deleteStudent(int studentId);
}
