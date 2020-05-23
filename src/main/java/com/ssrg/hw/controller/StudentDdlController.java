package com.ssrg.hw.controller;


import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.dto.StudentDdlDto;
import com.ssrg.hw.service.ICourseService;
import com.ssrg.hw.service.IHomeworkService;
import com.ssrg.hw.service.IStudentDdlService;
import com.ssrg.hw.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stuDDL")
public class StudentDdlController {

    @Autowired
    private IStudentDdlService studentDdlService;

    @Autowired
    private IHomeworkService homeworkService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/queryDDLByStudentId")
    public List<Map<String,Object>> queryDdlByStudentId(HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        List<Map<String,Object>> resultMap = new ArrayList<>();
        List<StudentDdlDto> sd = studentDdlService.queryDdlByStudentId(studentId);

        for (StudentDdlDto s:sd) {

        }

        return resultMap;
    }

    @RequestMapping("/addStudentDDL")
    public int addStudentDdl(StudentDdlDto studentDdlDto){
        return studentDdlService.addStudentDdl(studentDdlDto);
    }

    @RequestMapping("/updateStudentDDL")
    public int updateStudentDdl(int ddlId, String warn){
        return studentDdlService.updateStudentDdl(ddlId,warn);
    }

    @RequestMapping("/deleteStudentDDL")
    public int deleteStudentDdl(int ddlId){
        return studentDdlService.deleteStudentDdl(ddlId);
    }
}
