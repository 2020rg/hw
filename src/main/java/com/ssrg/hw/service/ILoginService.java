package com.ssrg.hw.service;


import com.ssrg.hw.dto.StudentDto;

public interface ILoginService {

    StudentDto studentLogin(int phone);
}
