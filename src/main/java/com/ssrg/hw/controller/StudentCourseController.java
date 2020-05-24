package com.ssrg.hw.controller;


import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.StudentCourseDto;
import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.dto.StudentMistakeNoteDto;
import com.ssrg.hw.service.ICourseService;
import com.ssrg.hw.service.IStudentCourseService;
import com.ssrg.hw.service.IStudentMistakeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/StuCourse")
public class StudentCourseController {

    @Autowired
    private IStudentCourseService studentCourseService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IStudentMistakeNoteService studentMistakeNoteService;

    @RequestMapping("/queryCourseAllStudent")
    public List<StudentDto> queryCourseAllStudent(int courseId){
        return studentCourseService.queryCourseAllStudent(courseId);
    }

    @RequestMapping("/queryStudentAllCourse")
    public List<CourseDto> queryStudentAllCourse(HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        return studentCourseService.queryStudentAllCourse(studentId);
    }

    @RequestMapping("/courseSelection")
    public int courseSelection(int studentId,int courseId){
        return studentCourseService.courseSelection(studentId,courseId);
    }

    @RequestMapping("/joinCourse")
    public Map<String,Object> joinCourse(@RequestParam("inviteCode") String inviteCode, @RequestParam("studentId") int studentId, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        int status = 0;
        CourseDto courseDto = courseService.queryCourseByInviteCode(inviteCode);
        List<CourseDto> studentCourseDto = studentCourseService.queryStudentAllCourse(studentId);

        //不可重复加入课程
        for(CourseDto c:studentCourseDto){
            if(c.getCourseId() == courseDto.getCourseId()){
                status = -1;
                result.put("status",status);
                return result;
            }
        }

        status = studentCourseService.courseSelection(studentId,courseDto.getCourseId());
        if(status != 1){
            status = 0;
        }
        else{    //生成相应课程的错题本
            StudentMistakeNoteDto noteDto = new StudentMistakeNoteDto();
            noteDto.setNoteName(courseDto.getCourseName());
            noteDto.setStudentId(studentId);
            studentMistakeNoteService.addStudentMistakeNote(noteDto);
        }
        result.put("status",status);
        return result;
    }

    @RequestMapping("/cancelCourse")
    public int cancelCourse(int studentId,int courseId){
        return studentCourseService.cancelCourse(studentId,courseId);
    }
}
