package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private int courseId;
    private String courseName;
    private int teacherId;
    private String inviteCode;
    private int classRepresentativeId;

}
