package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.StudentQuestionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentQuestionMapper {

    /**
     * 查询学生的所有问题
     * @param studentId
     * @return
     */
    List<StudentQuestionDto> queryStudentQuestionByStudentId(int studentId);
    
    /**
     * 根据ID查询问题
     * @param studentQuestionId
     * @return
     */
    StudentQuestionDto queryStudentQuestionByStudentQuestionId(int studentQuestionId);

    /**
     * 添加学生的问题
     * @param studentQuestionDto
     * @return
     */
    int addStudentQuestion(StudentQuestionDto studentQuestionDto);

    /**
     * 删除课程
     * @param studentQuestionId
     * @return
     */
    int deleteQuestion(int studentQuestionId);

    /**
     * 修改学生问题信息
     * @param studentQuestionDto
     * @return
     */
    int updateStudentQuestion(StudentQuestionDto studentQuestionDto);
}
