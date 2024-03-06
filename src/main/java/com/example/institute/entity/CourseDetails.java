package com.example.institute.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="coursetable")
public class CourseDetails {
    @Id
    @NotNull
    private int cousreId;
    @NotNull
    @Size(min=3,max = 20)
    private  String courseName;
    @NotNull
    private String modeOfCourse;

    public String getModeOfCourse() {
        return modeOfCourse;
    }

    public void setModeOfCourse(String modeOfCourse) {
        this.modeOfCourse = modeOfCourse;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institueid")
    private Institute institute;

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "CourseDetails{" +
                "cousreId=" + cousreId +
                ", courseName='" + courseName + '\'' +
                ", modeOfCourse='" + modeOfCourse + '\'' +
                ", courseDuration=" + courseDuration +
                ", institute=" +institute+
                '}';
    }

    public int getCousreId() {
        return cousreId;
    }

    public void setCousreId(int cousreId) {
        this.cousreId = cousreId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    private int courseDuration;
}
