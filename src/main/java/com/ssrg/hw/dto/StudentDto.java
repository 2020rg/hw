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

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int _studentId){
        studentId = _studentId;
    }
    public String getName(){
        return name;
    }
    public void setName(String _name){
        name = _name;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String _school){
        school = _school;
    }

    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnterSchoolYear() {
        return enterSchoolYear;
    }

    public void setEnterSchoolYear(String enterSchoolYear) {
        this.enterSchoolYear = enterSchoolYear;
    }
}
