package com.example.institute.validations;

import com.example.institute.entity.CourseDetails;
import org.springframework.stereotype.Component;

@Component
public class CourseValidation {
    public void courseValidation(CourseDetails courseDetails) throws Exception {
        if(courseDetails==null){
            throw new Exception("courseDetails should not be null");
        }
        String courseName = courseDetails.getCourseName();
        if(courseName==null){
            throw new Exception("courseName should not be null");
        }
        if(courseDetails.getModeOfCourse()==null){
            throw new Exception("modeOfCourse should not be null");
        }
        if(courseDetails.getCourseDuration()==0){
            throw new Exception("courseDuration should not be null");
        }
        if(courseDetails.getInstituteId()==null){
            throw new Exception("instituteId should not be null");
        }

    }
}
