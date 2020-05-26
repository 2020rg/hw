package com.ssrg.hw.controller;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.dto.StudentHomeworkDto;
import com.ssrg.hw.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private IHomeworkService homeworkService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentHomeworkService shService;

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/queryHomeworkByTeacherId")
    public Map<String,Object> queryHomeworkByTeacherId(HttpServletRequest request){
        int teacherId = (int)request.getSession().getAttribute("userId");
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> SubmitOkCheckedList = new ArrayList<>();
        List<Map<String,Object>> SubmitOkNotCheckList = new ArrayList<>();

        int SubmitOkNum = 0, SubmitNotOkNum = 0, HasCheckedNum = 0;

        List<CourseDto> courseList = courseService.queryCourseByTeacherId(teacherId);
        HomeworkDto homeworkDto;
        CourseDto courseDto;
        StudentDto studentDto;

        for(CourseDto c: courseList) {
            List<HomeworkDto> homeworkList = homeworkService.queryHomeworkByCourseId(c.getCourseId());
            for(HomeworkDto h: homeworkList) {
                List<StudentHomeworkDto> studentHomeworkList = shService.querySHByStudentId(h.getHomeworkId());
                for (StudentHomeworkDto s: studentHomeworkList) {
                    Map<String,Object> homework = new HashMap<>();
                    homeworkDto = homeworkService.queryHomeworkByHomeworkId(s.getHomeworkId());
                    courseDto = courseService.queryCourseByCourseId(homeworkDto.getCourseId());
                    studentDto = studentService.queryStudentById(s.getStudentId());
                    homework.put("homeworkID",homeworkDto.getHomeworkId());
                    homework.put("courseName",courseDto.getCourseName());
                    homework.put("studentID",studentDto.getStudentId());
                    homework.put("studentName",studentDto.getName());
                    homework.put("homeworkTitle",homeworkDto.getTitle());
                    homework.put("homeworkIntroduce",homeworkDto.getIntroduce());
                    homework.put("submitTime",s.getSubmitTime());
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
                    }
                }
            }
        }
        result.put("SubmitOkNum",SubmitOkNum);
        result.put("SubmitNotOkNum",SubmitNotOkNum);
        result.put("HasCheckedNum",HasCheckedNum);
        result.put("HasNotCheckedNum",SubmitOkNum - HasCheckedNum);
        result.put("SubmitOkCheckedList",SubmitOkCheckedList);
        result.put("SubmitOkNotCheckList",SubmitOkNotCheckList);

        return result;
    }

    @RequestMapping("/queryHomeworkByHomeworkId")
    public HomeworkDto queryHomeworkByHomeworkId(int homeworkId){
        return homeworkService.queryHomeworkByHomeworkId(homeworkId);
    }

    @RequestMapping("/queryHomeworkByCourseId")
    public List<HomeworkDto> queryHomeworkByCourseId(int courseId){
        return homeworkService.queryHomeworkByCourseId(courseId);
    }

    @RequestMapping("/addHomework")
    public int addHomework(HomeworkDto homeworkDto){
        return homeworkService.addHomework(homeworkDto);
    }

    @RequestMapping("/deleteHomeworkByHomeworkId")
    public int deleteHomeworkByHomeworkId(int homeworkId){
        return homeworkService.deleteHomeworkByHomeworkId(homeworkId);
    }

    @RequestMapping("/deleteHomeworkByCourseId")
    public int deleteHomeworkByCourseId(int courseId){
        return homeworkService.deleteHomeworkByCourseId(courseId);
    }

    @RequestMapping("/updateHomework")
    public int updateHomework(HomeworkDto homeworkDto){
        return homeworkService.updateHomework(homeworkDto);
    }

    @RequestMapping("/publishHomework")
    public Map<String,Object> publishHomework(@RequestParam("courseId") int courseId,
                                              @RequestParam("title") String title, @RequestParam("introduce") String introduce,
                                              @RequestParam("ddl") Timestamp ddl, HttpServletRequest request){
        int teacherId = (int)request.getSession().getAttribute("userId");
        int flag = homeworkService.publishHomework(teacherId, courseId, title, introduce, ddl);
        Map<String,Object> result = new HashMap<>();
        result.put("flag",flag);
        return result;
    }
}
