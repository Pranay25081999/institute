package com.example.institute.entity;

import jakarta.persistence.*;

@Entity
@Table(name="institutetable")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cousreId;
    private  String courseName;

    @Override
    public String toString() {
        return "Institute{" +
                "cousreId=" + cousreId +
                ", courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
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
