package com.ssrg.hw.service.impl;


import com.ssrg.hw.dto.StudentMistakeNoteDto;
import com.ssrg.hw.mapper.StudentMistakeNoteMapper;
import com.ssrg.hw.service.IStudentMistakeNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMistakeNoteServiceImpl implements IStudentMistakeNoteService {

    @Autowired
    private StudentMistakeNoteMapper studentMistakeNoteMapper;

    @Override
    public List<StudentMistakeNoteDto> queryStudentMistakeNoteList() {
        return studentMistakeNoteMapper.queryStudentMistakeNoteList();
    }

    @Override
    public List<StudentMistakeNoteDto> queryStudentMistakeNoteByStudentId(int studentId) {
        return studentMistakeNoteMapper.queryStudentMistakeNoteByStudentId(studentId);
    }

    @Override
    public List<StudentMistakeNoteDto> queryStudentMistakeNoteByNoteName(String noteName) {
        return studentMistakeNoteMapper.queryStudentMistakeNoteByNoteName(noteName);
    }

    @Override
    public StudentMistakeNoteDto queryStudentMistakeNoteByNoteId(int noteId) {
        return studentMistakeNoteMapper.queryStudentMistakeNoteByNoteId(noteId);
    }

    @Override
    public int addStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto) {
        studentMistakeNoteMapper.addStudentMistakeNote(studentMistakeNoteDto);
        return 1;
    }

    @Override
    public int updateStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto) {
        studentMistakeNoteMapper.updateStudentMistakeNote(studentMistakeNoteDto);
        return 1;
    }

    @Override
    public int deleteStudentMistakeNote(int noteId) {
        studentMistakeNoteMapper.deleteStudentMistakeNote(noteId);
        return 1;
    }
}
