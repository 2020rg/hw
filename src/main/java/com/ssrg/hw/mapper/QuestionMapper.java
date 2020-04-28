package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.QuestionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {

    /**
     * 查询某一作业中的所有题目
     * @param homeworkId
     * @return
     */
    List<QuestionDto> queryQuestionByHomeworkId(int homeworkId);

    /**
     * 查询一个题目
     * @param questionId
     * @return
     */
    QuestionDto queryQuestionByQuestionId(int questionId);

    /**
     * 添加一个题目
     * @param questionDto
     * @return
     */
    int addQuestion(QuestionDto questionDto);

    /**
     * 修改题目内容
     * @param questionId
     * @param content
     * @return
     */
    int updateQuestion(int questionId,String content);

    /**
     * 删除一个题目
     * @param questionId
     * @return
     */
    int deleteQuestionByQuestionId(int questionId);

    /**
     * 删除一个作业中的所有题目
     * @param homeworkId
     * @return
     */
    int deleteQuestionByHomeworkId(int homeworkId);
}
