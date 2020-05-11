package com.ssrg.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCourseDto {

    private int teacher_course_id;
    private int teacherId;
    private int courseId;
}
