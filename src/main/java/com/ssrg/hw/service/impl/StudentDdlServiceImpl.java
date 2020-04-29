package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.StudentDdlDto;
import com.ssrg.hw.mapper.StudentDdlMapper;
import com.ssrg.hw.service.IStudentDdlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDdlServiceImpl implements IStudentDdlService {

    @Autowired
    private StudentDdlMapper studentDdlMapper;

    @Override
    public List<StudentDdlDto> queryDdlByStudentId(int studentId){
        return studentDdlMapper.queryDdlByStudentId(studentId);
    }

    @Override
    public int addStudentDdl(StudentDdlDto studentDdlDto){
        return studentDdlMapper.addStudentDdl(studentDdlDto);
    }

    @Override
    public int updateStudentDdl(int ddlId, String warn){
        return studentDdlMapper.updateStudentDdl(ddlId,warn);
    }

    @Override
    public int deleteStudentDdl(int ddlId){
        return studentDdlMapper.deleteStudentDdl(ddlId);
    }
}
