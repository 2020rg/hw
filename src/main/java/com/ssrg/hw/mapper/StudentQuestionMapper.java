package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.StudentQuestionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentQuestionMapper {
    
    /**
     * 根据ID查询题目
     * @param studentQuestionId
     * @return
     */
    StudentQuestionDto querySQByStudentQuestionId(int studentQuestionId);

    /**
     * 学生作答后添加
     * @param studentQuestionDto
     * @return
     */
    int addSQ(StudentQuestionDto studentQuestionDto);

    /**
     * 作业删除时，学生回答的相关题目删除
     * @param homeworkId
     * @return
     */
    int deleteSQ(int homeworkId);

    /**
     * 学生重新回答题目或添加分数
     * @param studentQuestionDto
     * @return
     */
    int updateSQ(StudentQuestionDto studentQuestionDto);
}
