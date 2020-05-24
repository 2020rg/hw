package com.ssrg.hw.service.impl;


import com.ssrg.hw.dto.NoteQuestionDto;
import com.ssrg.hw.mapper.NoteQuestionMapper;
import com.ssrg.hw.service.INoteQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteQuestionServiceImpl implements INoteQuestionService {

    @Autowired
    private NoteQuestionMapper noteQuestionMapper;

    @Override
    public List<NoteQuestionDto> queryNQByNoteId(int noteId){
        return noteQuestionMapper.queryNQByNoteId(noteId);
    }

    @Override
    public int deleteNQByNoteId(int noteId){
        return noteQuestionMapper.deleteNQByNoteId(noteId);
    }

    @Override
    public int addNQ(NoteQuestionDto noteQuestionDto){
        return noteQuestionMapper.addNQ(noteQuestionDto);
    }

    @Override
    public int updateNQ(NoteQuestionDto noteQuestionDto){
        return noteQuestionMapper.updateNQ(noteQuestionDto);
    }
}
