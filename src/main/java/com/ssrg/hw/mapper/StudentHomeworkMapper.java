package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.StudentHomeworkDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentHomeworkMapper {

    /**
     * 查询学生的所有作业
     * @param studentId
     * @return
     */
    List<StudentHomeworkDto> querySHByStudentId(int studentId);

    /**
     * 根据作业ID查询作业
     * @param homeworkId
     * @return
     */
    StudentHomeworkDto querySHByHomeworkId(int homeworkId);

    /**
     * 根据Id查询作业
     * @param studentHomeworkId
     * @return
     */
    StudentHomeworkDto querySHByStudentHomeworkId(int studentHomeworkId);

    /**
     * 修改学生作业信息
     * @param studentHomeworkDto
     * @return
     */
    int updateSH(StudentHomeworkDto studentHomeworkDto);

    /**
     * 为学生添加作业
     * @param studentHomeworkDto
     * @return
     */
    int addSH(StudentHomeworkDto studentHomeworkDto);

    /**
     * 为学生删除作业
     * @param studentHomeworkId
     * @return
     */
    int deleteSH(int studentHomeworkId);
}
