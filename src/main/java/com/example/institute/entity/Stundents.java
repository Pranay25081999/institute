package com.example.institute.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name="studentstable")
public class Stundents {
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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
    @NotNull(message = "studentId should not be null")
    private int studentId;
   // @NotNull
    //@Size(min=3,max=30,message = "studentName should not be less than 3 characters and not greater than 30 characters")
    private String studentName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="courseId")
    private CourseDetails courseDetails;


}
