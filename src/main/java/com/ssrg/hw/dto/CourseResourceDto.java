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

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getResourceFilepath() {
        return resourceFilepath;
    }

    public void setResourceFilepath(String resourceFilepath) {
        this.resourceFilepath = resourceFilepath;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}

