package com.example.institute.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="coursetable")
public class CourseDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "courseId", unique = true)
    private String cousreId;
    private  String courseName;
    private String modeOfCourse;
    private int courseDuration;
    private String instituteId;

    public String getModeOfCourse() {
        return modeOfCourse;
    }

    public void setModeOfCourse(String modeOfCourse) {
        this.modeOfCourse = modeOfCourse;
    }

  //  UUID uuid=UUID.randomUUID();



    public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    @Override
    public String toString() {
        return "CourseDetails{" +
                "cousreId=" + cousreId +
                ", courseName='" + courseName + '\'' +
                ", modeOfCourse='" + modeOfCourse + '\'' +
                ", courseDuration=" + courseDuration +
                ",instituteId="+instituteId+
               // ", institute=" +institute+

                '}';
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


}
