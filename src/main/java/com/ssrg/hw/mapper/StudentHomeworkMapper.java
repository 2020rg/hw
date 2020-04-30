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
    List<StudentHomeworkDto> queryStudentHomeworkByStudentId(int studentId);

    /**
     * 根据作业ID查询作业
     * @param homeworkId
     * @return
     */
    StudentHomeworkDto queryStudentHomeworkByHomeworkId(int homeworkId);

    /**
     * 根据Id查询作业
     * @param StudentHomeworkId
     * @return
     */
    StudentHomeworkDto queryStudentHomeworkByStudentHomeworkId(int studentHomeworkId);

    /**
     * 添加学生作业
     * @param studentHomeworkDto
     * @return
     */
    int addStudentHomework(StudentHomeworkDto studentHomeworkDto);

    /**
     * 删除学生作业
     * @param studentHomeworkId
     * @return
     */
    int deleteStudentHomework(int studentHomeworkId);

    /**
     * 修改学生作业信息
     * @param studentHomeworkDto
     * @return
     */
    int updateStudentHomework(StudentHomeworkDto studentHomeworkDto);
}
