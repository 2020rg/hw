package com.ssrg.hw.mapper;

import com.ssrg.hw.dto.CourseResourceDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseResourceMapper {

    /**
     * 查询所有课程资源
     * @return
     */
    List<CourseResourceDto> queryCourseResourceList();

    /**
     * 根据courseId查询该课程所有资源
     * @param courseId
     * @return
     */
    List<CourseResourceDto> queryCourseResourceByCourseId(int courseId);

    /**
     * 根据resourceName查询课程资源
     * @param resourceName
     * @return
     */
    List<CourseResourceDto> queryCourseResourceByResourceName(String resourceName);

    /**
     * 根据resourceId查询课程资源
     * @param resourceId
     * @return
     */
    CourseResourceDto queryCourseResourceByResourceId(int resourceId);

    /**
     * 添加课程资源
     * @param courseResourceDto
     * @return
     */
    int addCourseResource(CourseResourceDto courseResourceDto);

    /**
     * 更新课程资源
     * @param courseResourceDto
     * @return
     */
    int updateCourseResource(CourseResourceDto courseResourceDto);

    /**
     * 删除课程资源
     * @param resourceId
     * @return
     */
    int deleteCourseResource(int resourceId);
}
