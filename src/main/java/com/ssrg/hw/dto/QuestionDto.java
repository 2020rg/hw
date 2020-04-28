package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private int questionId;
    private int homeworkId;
    private String content;
}
