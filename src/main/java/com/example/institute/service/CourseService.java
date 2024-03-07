package com.example.institute.service;

import com.example.institute.entity.CourseDetails;

import com.example.institute.entity.Institute;
import com.example.institute.repository.CourseRepo;
import com.example.institute.repository.InstituteRepo;
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
    InstituteRepo instituteRepo;

    public CourseDetails addCourse(CourseDetails courseDetails) throws Exception {
        String instituteId = courseDetails.getInstituteId();

        if(!instituteRepo.findById(instituteId).isEmpty()&&courseDetails.getInstituteId() != null && !courseDetails.getInstituteId().isEmpty()){
             return courseRepo.save(courseDetails);
        }else {
              throw new  Exception("institute doesn't exist");
            }
    }



    public List<CourseDetails> getCourseAll( ){
       // int instituteId = institute.getInstituteId();
        return courseRepo.findAll();
    }
    public String getCourseById(String id){
      //  int instituteId = institute.getInstituteId();
        Optional<CourseDetails> byId = courseRepo.findById(id);
        return id;
    }
}
