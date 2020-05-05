package com.ssrg.hw.service.impl;

import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.mapper.StudentMapper;
import com.ssrg.hw.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentDto studentLogin(int phone){
        return studentMapper.queryStudentByPhone(phone);
    }
}
