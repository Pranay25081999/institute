package com.example.institute.service;

import com.example.institute.entity.CourseDetails;

import com.example.institute.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;
    public String addCourse(CourseDetails courseDetails){
        courseRepo.save(courseDetails);
        return "add";
    }
    public List<CourseDetails> getCourseAll( ){
        return courseRepo.findAll();
    }
}
