package com.ssrg.hw.controller;

import com.ssrg.hw.dto.StudentMistakeNoteDto;
import com.ssrg.hw.service.IStudentMistakeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentMistakeNoteController {

    @Autowired
    private IStudentMistakeNoteService studentMistakeNoteService;

    @GetMapping("/queryStudentMistakeNoteList")
    public List<StudentMistakeNoteDto> queryStudentMistakeNoteList()
    {
        List<StudentMistakeNoteDto> studentMistakeNoteList=studentMistakeNoteService.queryStudentMistakeNoteList();
        return studentMistakeNoteList;
    }

    @GetMapping("/queryStudentMistakeNoteByStudentId")
    public List<StudentMistakeNoteDto> queryStudentMistakeNoteByStudentId(int studentId)
    {
        List<StudentMistakeNoteDto> studentMistakeNoteList=studentMistakeNoteService.queryStudentMistakeNoteByStudentId(studentId);
        return studentMistakeNoteList;
    }

    @GetMapping("/queryStudentMistakeNoteByNoteName")
    public List<StudentMistakeNoteDto> queryStudentMistakeNoteByNoteName(String noteName)
    {
        List<StudentMistakeNoteDto> studentMistakeNoteList=studentMistakeNoteService.queryStudentMistakeNoteByNoteName(noteName);
        return studentMistakeNoteList;
    }

    @GetMapping("/queryStudentMistakeNoteByNoteId")
    public StudentMistakeNoteDto queryStudentMistakeNoteByNoteId(int noteId)
    {
        StudentMistakeNoteDto studentMistakeNoteDto=studentMistakeNoteService.queryStudentMistakeNoteByNoteId(noteId);
        return studentMistakeNoteDto;
    }

    @GetMapping("/addStudentMistakeNote")
    public int addStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto)
    {
        studentMistakeNoteService.addStudentMistakeNote(studentMistakeNoteDto);
        return 1;
    }

    @GetMapping("/updateStudentMistakeNote")
    public int updateStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto)
    {
        studentMistakeNoteService.updateStudentMistakeNote(studentMistakeNoteDto);
        return 1;
    }

    @GetMapping("/deleteStudentMistakeNote")
    public int deleteStudentMistakeNote(int noteId)
    {
        studentMistakeNoteService.deleteStudentMistakeNote(noteId);
        return 1;
    }
}
