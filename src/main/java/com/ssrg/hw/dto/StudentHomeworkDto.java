package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomeworkDto {

    private int studentHomeworkId;
    private int studentId;
    private int homeworkId;
    private Date submitTime;
    private int score;
    private String file;
    private String answer;
    private bool submitOK;

}
