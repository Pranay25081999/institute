package com.example.institute.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="coursetable")
public class CourseDetails {
    @Id
    private int cousreId;
    private  String courseName;
    private String modeOfCourse;

    public String getModeOfCourse() {
        return modeOfCourse;
    }

    public void setModeOfCourse(String modeOfCourse) {
        this.modeOfCourse = modeOfCourse;
    }

    public List<Stundents> getStundentsList() {
        return stundentsList;
    }

    public void setStundentsList(List<Stundents> stundentsList) {
        this.stundentsList = stundentsList;
    }
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentsList")
    private List<Stundents> stundentsList;
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
                ", stundentsList=" + stundentsList +
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
