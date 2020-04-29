package com.ssrg.hw.service;

import com.ssrg.hw.dto.StudentDdlDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentDdlService {

    List<StudentDdlDto> queryDdlByStudentId(int studentId);

    int addStudentDdl(StudentDdlDto studentDdlDto);

    int updateStudentDdl(int ddlId, String warn);

    int deleteStudentDdl(int ddlId);
}
