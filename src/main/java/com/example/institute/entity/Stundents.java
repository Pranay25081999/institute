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

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Stundents{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", institute=" + institute +
                '}';
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int studentId;
    private String studentName;
    @ManyToOne
    @JoinColumn(name="courseId")
    private Institute institute;

}
