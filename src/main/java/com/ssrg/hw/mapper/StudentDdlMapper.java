package com.ssrg.hw.mapper;


import com.ssrg.hw.dto.StudentDdlDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDdlMapper {

    List<StudentDdlDto> queryDdlByStudentId(int studentId);

    int addStudentDdl(StudentDdlDto studentDdlDto);

    int updateStudentDdl(@Param("ddlId")int ddlId,@Param("warn")String warn);

    int deleteStudentDdl(int ddlId);
}
