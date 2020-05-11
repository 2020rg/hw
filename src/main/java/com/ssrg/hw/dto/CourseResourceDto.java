package com.ssrg.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResourceDto {

    private int resourceId;
    private int courseId;
    private Date uploadTime;
    private String resourceName;
    private String resourceFilepath;
}

