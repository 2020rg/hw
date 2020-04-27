package com.ssrg.hw.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private int studentId;
    private String name;
    private String school;
    private int phone;
    private String password;
    private String enterSchoolYear;

}
