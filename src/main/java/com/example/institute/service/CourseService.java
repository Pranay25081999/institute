package com.example.institute.service;

import com.example.institute.entity.CourseDetails;

import com.example.institute.entity.Institute;
import com.example.institute.repository.CourseRepo;
import com.example.institute.repository.InstituteRepo;
import com.example.institute.validations.CourseValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseValidation courseValidation;

    public CourseDetails addCourse(CourseDetails courseDetails) throws Exception {
        courseValidation.courseValidation(courseDetails);
        String courseName = courseDetails.getCourseName();

        if(courseRepo.findByCourseName(courseName)!=null){
            throw new Exception("course already exist");
        }
        else{
            return courseRepo.save(courseDetails);
        }

    }

    public List<CourseDetails> getCourseAll( ){
        return courseRepo.findAll();
    }
    public String getCourseById(String id) throws Exception {

    courseRepo.findById(id);
        if(!courseRepo.findById(id).isEmpty()){
            return id;
        }
        else {
            throw new Exception("There is is no course with this id");
        }
    }
}
