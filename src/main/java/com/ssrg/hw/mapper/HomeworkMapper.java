package com.ssrg.hw.mapper;

import com.ssrg.hw.dto.HomeworkDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface HomeworkMapper {

    /**
     * 根据作业ID查询作业
     * @param homeworkId
     * @return
     */
    HomeworkDto queryHomeworkByHomeworkId(int homeworkId);

    /**
     * 根据课程ID查询作业
     * @param courseId
     * @return
     */
    List<HomeworkDto> queryHomeworkByCourseId(int courseId);

    /**
     * 为课程添加作业
     * @param homeworkDto
     * @return
     */
    int addHomework(HomeworkDto homeworkDto);

    /**
     * 根据作业ID删除课程作业
     * @param homeworkId
     * @return
     */
    int deleteHomeworkByHomeworkId(int homeworkId);

    /**
     * 删除某一课程的全部作业
     * @param courseId
     * @return
     */
    int deleteHomeworkByCourseId(int courseId);

    /**
     * 修改作业信息
     * @param homeworkDto
     * @return
     */
    int updateHomework(HomeworkDto homeworkDto);

    /**
     * 发布作业
     * @param courseId
     * @param title
     * @param introduce
     * @param ddl
     * @return
     */
    int publishHomework(@Param("teacherId") int teacherId,
                        @Param("courseId") int courseId, @Param("title") String title,
                        @Param("introduce") String introduce, @Param("ddl") Timestamp ddl);
}
