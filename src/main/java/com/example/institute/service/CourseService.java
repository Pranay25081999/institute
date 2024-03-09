package com.example.institute.service;

import com.example.institute.entity.CourseDetails;
import com.example.institute.repository.CourseRepo;
import com.example.institute.validations.CourseValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
    public List<CourseDetails> getCourseAll( ) throws Exception {
        List<CourseDetails> all = courseRepo.findAll();
        if(!all.isEmpty()){
            return all;
        }
        else{
            throw new Exception("There is no course");
        }
    }
    public Optional<CourseDetails> getCourseById(String id) throws Exception {
    Optional<CourseDetails> courseDetails=courseRepo.findById(id);
        if(!courseRepo.findById(id).isEmpty()){
            return courseDetails;
        }
        else {
            throw new Exception("There is no course with this id");
        }
    }
}
