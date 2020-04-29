package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDdlDto {

    private int ddlId;

    private int studentId;

    private int homeworkId;

    private String warn;

    public int getHomeworkId(){
        return homeworkId;
    }
}
