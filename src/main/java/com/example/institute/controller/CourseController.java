package com.example.institute.controller;

import com.example.institute.entity.CourseDetails;
import com.example.institute.service.CourseService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;
   @PostMapping("/addCourse")
   public ResponseEntity<String> createCourse(@Valid @RequestBody CourseDetails courseDetails) throws Exception {
       try{
           courseService.addCourse(courseDetails);
           return new ResponseEntity<>("course is added", HttpStatus.CREATED);
       }
       catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }

    }
    @GetMapping("/getCourse")
    public List<CourseDetails> getCourses(){
       return courseService.getCourseAll();
   }
   @GetMapping("/getCourseById/{id}")
   public String getCourseById(String id){
       String courseById = courseService.getCourseById(id);
       return courseById;
   }



    @PutMapping("/Update/{id}")
    public ResponseEntity<String> updateCourseById(@RequestBody CourseDetails courseDetails ){
       return new ResponseEntity<>("Hello updated",HttpStatus.OK);
    }

}
