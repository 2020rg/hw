package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomeworkDto {

    private int studentHomeworkId;
    private int studentId;
    private int homeworkId;
    private Timestamp submitTime;
    private int score;
    private String file;
    private String answer;
    private boolean submitOK;

}

