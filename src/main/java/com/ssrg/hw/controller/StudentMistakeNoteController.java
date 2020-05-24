package com.ssrg.hw.controller;

import com.ssrg.hw.dto.NoteQuestionDto;
import com.ssrg.hw.dto.StudentMistakeNoteDto;
import com.ssrg.hw.service.INoteQuestionService;
import com.ssrg.hw.service.IQuestionService;
import com.ssrg.hw.service.IStudentMistakeNoteService;
import com.ssrg.hw.service.IStudentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/note")
public class StudentMistakeNoteController {

    @Autowired
    private IStudentMistakeNoteService studentMistakeNoteService;

    @Autowired
    private INoteQuestionService noteQuestionService;

    @Autowired
    private IStudentQuestionService studentQuestionService;

    @Autowired
    private IQuestionService questionService;

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

    @RequestMapping("/getNote")
    public Map<String,Object> getNote(HttpServletRequest request){
        int studentId = (int)request.getSession().getAttribute("userId");
        Map<String,Object> result= new HashMap<>();
        List<StudentMistakeNoteDto> noteDto = studentMistakeNoteService.queryStudentMistakeNoteByStudentId(studentId);
        List<Map<String,Object>> noteList = new ArrayList<>();

        for(StudentMistakeNoteDto n:noteDto){
            Map<String,Object> temp = new HashMap<>();
            temp.put("noteId",n.getNoteId());
            temp.put("noteName",n.getNoteName());
            noteList.add(temp);
        }

        result.put("noteList",noteList);

        return result;
    }


    @RequestMapping("/getANoteContent")
    public Map<String,Object> getANoteContent(@RequestParam("noteId") int noteId, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        List<NoteQuestionDto> noteQuestionDtos;
        List<Map<String,Object>> note = new ArrayList<>();

        int studentId = (int)request.getSession().getAttribute("userId");
        noteQuestionDtos = noteQuestionService.queryNQByNoteId(noteId);
        for(NoteQuestionDto n:noteQuestionDtos){
            Map<String,Object> temp = new HashMap<>();
            int questionId = n.getQuestionId();
            String questionContent = questionService.queryQuestionByQuestionId(questionId).getContent();
            String answer = studentQuestionService.querySQBySIdAndQId(studentId,questionId).getAnswer();
            temp.put("questionContent",questionContent);
            temp.put("answer",answer);
            temp.put("content",n.getContent());
            note.add(temp);
        }

        result.put("note",note);

        return result;
    }
}
