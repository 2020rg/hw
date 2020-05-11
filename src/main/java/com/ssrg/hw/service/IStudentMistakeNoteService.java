package com.ssrg.hw.service;


import com.ssrg.hw.dto.StudentMistakeNoteDto;

import java.util.List;

public interface IStudentMistakeNoteService {

    List<StudentMistakeNoteDto> queryStudentMistakeNoteList();

    List<StudentMistakeNoteDto> queryStudentMistakeNoteByStudentId(int studentId);

    List<StudentMistakeNoteDto> queryStudentMistakeNoteByNoteName(String noteName);

    StudentMistakeNoteDto queryStudentMistakeNoteByNoteId(int noteId);

    int addStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto);

    int updateStudentMistakeNote(StudentMistakeNoteDto studentMistakeNoteDto);

    int deleteStudentMistakeNote(int noteId);

}
