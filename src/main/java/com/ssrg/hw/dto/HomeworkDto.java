package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkDto {

    private int homeworkId;
    private int courseId;
    private String title;
    private String introduce;
    private String file;
    private Timestamp ddl;
}
