package com.example.institute.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name="studentstable")
public class Stundents {
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    @Override
    public String toString() {
        return "Stundents{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseDetails=" + courseDetails +
                '}';
    }

    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(CourseDetails courseDetails) {
        this.courseDetails = courseDetails;
    }

   @Id
    private String studentId;
    private String studentName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="courseId")
    private CourseDetails courseDetails;


}
