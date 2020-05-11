package com.ssrg.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentMistakeNoteDto {

    private int noteId;
    private int studentId;
    private String noteName;
    private String content;

}
