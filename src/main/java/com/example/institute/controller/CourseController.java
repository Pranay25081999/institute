package com.example.institute.controller;

import com.example.institute.entity.CourseDetails;
import com.example.institute.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;
   @PostMapping("/addCourse")
   public ResponseEntity<String> createCourse(@RequestBody CourseDetails courseDetails){
       courseService.addCourse(courseDetails);
        return new ResponseEntity<>("course is added", HttpStatus.CREATED);
    }
    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Integer> getCourseById(@PathVariable int id){
        courseService.getCourseById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<String> updateCourseById(@RequestBody CourseDetails courseDetails ){
       return new ResponseEntity<>("Hello updated",HttpStatus.OK);
    }

}
