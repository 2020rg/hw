package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQuestionDto {

    private int studentQuestionId;
    private int studentId;
    private int questionId;
    private int score;

}
