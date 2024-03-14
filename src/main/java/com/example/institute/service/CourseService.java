package com.example.institute.service;

import com.example.institute.entity.CourseDetails;
import com.example.institute.repository.CourseRepo;
import com.example.institute.validations.CourseValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CourseService {
  private final CourseRepo courseRepo;

  private final CourseValidation courseValidation;
    public String addCourse(CourseDetails courseDetails) throws Exception {
        courseValidation.courseValidation(courseDetails);
        String courseName = courseDetails.getCourseName();
        if(courseRepo.findByCourseName(courseName)!=null){
            throw new Exception("course already exist");
        }
        CourseDetails save = courseRepo.save(courseDetails);
        if(save!=null){
            return save.getInstituteId();
        }else {
            throw new Exception("unable to save course"+courseName);
        }
    }
    public List<CourseDetails> getCourseAll( ) {
         return courseRepo.findAll();
    }
    public CourseDetails getCourseById(String id)  {
    Optional<CourseDetails> courseDetails=courseRepo.findById(id);
        if(courseDetails.isPresent()){
            return courseDetails.get();
        }
        else {
            throw new NoSuchElementException("There is no course with this id");
        }
    }
}
