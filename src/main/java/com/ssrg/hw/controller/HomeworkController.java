package com.ssrg.hw.controller;


import com.ssrg.hw.dto.HomeworkDto;
import com.ssrg.hw.service.IHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeworkController {

    @Autowired
    private IHomeworkService homeworkService;

    @GetMapping("/queryHomeworkByHomeworkId")
    public HomeworkDto queryHomeworkByHomeworkId(int homeworkId){
        return homeworkService.queryHomeworkByHomeworkId(homeworkId);
    }

    @GetMapping("/queryHomeworkByCourseId")
    public List<HomeworkDto> queryHomeworkByCourseId(int courseId){
        return homeworkService.queryHomeworkByCourseId(courseId);
    }

    @GetMapping("/addHomework")
    public int addHomework(HomeworkDto homeworkDto){
        return homeworkService.addHomework(homeworkDto);
    }

    @GetMapping("/deleteHomeworkByHomeworkId")
    public int deleteHomeworkByHomeworkId(int homeworkId){
        return homeworkService.deleteHomeworkByHomeworkId(homeworkId);
    }

    @GetMapping("/deleteHomeworkByCourseId")
    public int deleteHomeworkByCourseId(int courseId){
        return homeworkService.deleteHomeworkByCourseId(courseId);
    }

    @GetMapping("/updateHomework")
    public int updateHomework(HomeworkDto homeworkDto){
        return homeworkService.updateHomework(homeworkDto);
    }
}
