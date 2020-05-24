package com.ssrg.hw.service;

import com.ssrg.hw.dto.NoteQuestionDto;

import java.util.List;

public interface INoteQuestionService {

    List<NoteQuestionDto> queryNQByNoteId(int noteId);

    int deleteNQByNoteId(int noteId);

    int addNQ(NoteQuestionDto noteQuestionDto);

    int updateNQ(NoteQuestionDto noteQuestionDto);
}
