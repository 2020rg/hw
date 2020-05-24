package com.ssrg.hw.mapper;

import com.ssrg.hw.dto.NoteQuestionDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoteQuestionMapper {

    List<NoteQuestionDto> queryNQByNoteId(int noteId);

    int deleteNQByNoteId(int noteId);

    int addNQ(NoteQuestionDto noteQuestionDto);

    int updateNQ(NoteQuestionDto noteQuestionDto);
}
