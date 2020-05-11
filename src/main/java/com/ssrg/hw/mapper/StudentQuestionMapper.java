package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.QuestionDto;
import com.ssrg.hw.dto.StudentQuestionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentQuestionMapper {


    /**
     * 根据学生ID和题目ID查询
     * @param studentId
     * @param questionId
     * @return
     */
    StudentQuestionDto querySQBySIdAndQId(int studentId,int questionId);

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

    /**
     * 学生提交题目答案
     * @param questionId
     * @param answer
     * @return
     */
    int submitQuestion(@Param("studentId") int studentId,@Param("questionId") int questionId, @Param("answer") String answer);
}
