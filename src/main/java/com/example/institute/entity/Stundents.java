package com.example.institute.entity;

import jakarta.persistence.*;

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
    private int studentId;
    private String studentName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="courseId")
    private CourseDetails courseDetails;


}
