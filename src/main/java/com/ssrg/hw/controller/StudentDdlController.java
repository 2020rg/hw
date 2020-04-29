package com.ssrg.hw.controller;


import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.dto.StudentDdlDto;
import com.ssrg.hw.service.IHomeworkService;
import com.ssrg.hw.service.IStudentDdlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentDdlController {

    @Autowired
    private IStudentDdlService studentDdlService;

    @Autowired
    private IHomeworkService homeworkService;

    @GetMapping("/queryDdlByStudentId")
    public List<Object> queryDdlByStudentId(int studentId){
        List<Object> result = new ArrayList<>();
        List<HomeworkDto> hw = new ArrayList<>();
        List<StudentDdlDto> sd = studentDdlService.queryDdlByStudentId(studentId);
        for (StudentDdlDto s:sd) {
            hw.add(homeworkService.queryHomeworkByHomeworkId(s.getHomeworkId()));
        }
        for(int i = 0; i < sd.size(); i++){
            result.add(hw.get(i));
            result.add(sd.get(i));
        }
        return result;
    }

    @GetMapping("/addStudentDdl")
    public int addStudentDdl(StudentDdlDto studentDdlDto){
        return studentDdlService.addStudentDdl(studentDdlDto);
    }

    @GetMapping("/updateStudentDdl")
    public int updateStudentDdl(int ddlId, String warn){
        return studentDdlService.updateStudentDdl(ddlId,warn);
    }

    @GetMapping("/deleteStudentDdl")
    public int deleteStudentDdl(int ddlId){
        return studentDdlService.deleteStudentDdl(ddlId);
    }
}
