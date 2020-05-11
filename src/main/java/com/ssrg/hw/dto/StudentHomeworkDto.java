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
    private String submitOK;

    public int getStudentId() {
        return studentId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public int getStudentHomeworkId() {
        return studentHomeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setStudentHomeworkId(int studentHomeworkId) {
        this.studentHomeworkId = studentHomeworkId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubmitOK() {
        return submitOK;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public int getScore() {
        return score;
    }

    public String getAnswer() {
        return answer;
    }

    public String getFile() {
        return file;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSubmitOK(String submitOK) {
        this.submitOK = submitOK;
    }
}

