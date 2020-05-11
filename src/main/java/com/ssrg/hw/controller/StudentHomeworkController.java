package com.ssrg.hw.controller;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.dto.StudentHomeworkDto;
import com.ssrg.hw.service.ICourseService;
import com.ssrg.hw.service.IHomeworkService;
import com.ssrg.hw.service.IStudentHomeworkService;
import com.ssrg.hw.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/stuHw")
public class StudentHomeworkController {

    @Autowired
    private IStudentHomeworkService shService;

    @Autowired
    private IHomeworkService homeworkService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/querySHByStudentId")
    public Map<String,Object> querySHByStudentId(HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> SubmitOkCheckedList = new ArrayList<>();
        List<Map<String,Object>> SubmitOkNotCheckList = new ArrayList<>();
        List<Map<String,Object>> SubmitNotOkList = new ArrayList<>();

        int SubmitOkNum = 0, SubmitNotOkNum = 0, HasCheckedNum = 0;

        List<StudentHomeworkDto> studentHomeworkList = shService.querySHByStudentId(studentId);
        HomeworkDto homeworkDto;
        CourseDto courseDto;

        for (StudentHomeworkDto s: studentHomeworkList) {
            Map<String,Object> homework = new HashMap<>();
            homeworkDto = homeworkService.queryHomeworkByHomeworkId(s.getHomeworkId());
            courseDto = courseService.queryCourseByCourseId(homeworkDto.getCourseId());
            homework.put("homeworkID",homeworkDto.getHomeworkId());
            homework.put("courseName",courseDto.getCourseName());
            homework.put("teacherName",teacherService.queryTeacherByTeacherId(courseDto.getTeacherId()).getName());
            homework.put("homeworkTitle",homeworkDto.getTitle());
            homework.put("homeworkIntroduce",homeworkDto.getIntroduce());
            homework.put("submitTime",s.getSubmitTime());
            homework.put("submitspareTime",0);
            homework.put("homeworkDDL",homeworkDto.getDdl());
            if(s.getSubmitOK().equals("true")){
                SubmitOkNum++;
                if(s.getScore() != -1){
                    HasCheckedNum++;
                    SubmitOkCheckedList.add(homework);
                }
                else{
                    SubmitOkNotCheckList.add(homework);
                }
            }
            else{
                SubmitNotOkNum++;
                SubmitNotOkList.add(homework);
            }
        }

        result.put("SubmitOkNum",SubmitOkNum);
        result.put("SubmitNotOkNum",SubmitNotOkNum);
        result.put("HasCheckedNum",HasCheckedNum);
        result.put("SubmitOkCheckedList",SubmitOkCheckedList);
        result.put("SubmitOkNotCheckList",SubmitOkNotCheckList);
        result.put("SubmitNotOkList",SubmitNotOkList);

        return result;
    }

    @RequestMapping("/querySHByHomeworkId")
    public StudentHomeworkDto querySHByHomeworkId(int homeworkId){
        StudentHomeworkDto studentHomework = shService.querySHByHomeworkId(homeworkId);
        return studentHomework;
    }

    @RequestMapping("/querySHByStudentHomeworkId")
    public StudentHomeworkDto querySHByStudentHomeworkId(int studentHomeworkId){
        StudentHomeworkDto StudentHomework = shService.querySHByStudentHomeworkId(studentHomeworkId);
        return StudentHomework;
    }

    @RequestMapping("/addSH")
    public int addSH(StudentHomeworkDto studentHomeworkDto){
        shService.addSH(studentHomeworkDto);
        return 1;
    }

    @RequestMapping("/deleteSH")
    public int deleteSH(int studentHomeworkId){
        shService.deleteSH(studentHomeworkId);
        return 1;
    }

    @RequestMapping("/updateSH")
    public int updateSH(StudentHomeworkDto studentHomeworkDto){
        shService.updateSH(studentHomeworkDto);
        return 1;
    }
}
