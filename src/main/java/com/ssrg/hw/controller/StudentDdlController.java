package com.ssrg.hw.controller;


import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.dto.StudentDdlDto;
import com.ssrg.hw.service.ICourseService;
import com.ssrg.hw.service.IHomeworkService;
import com.ssrg.hw.service.IStudentDdlService;
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

    @RequestMapping("/queryDDLByStudentId")
    public List<Map<String,Object>> queryDdlByStudentId(HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("studentId");
        List<Map<String,Object>> resultMap = new ArrayList<>();
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
