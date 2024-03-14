package com.example.institute.controller;

import com.example.institute.apiRespponse.ApiResponseBuilder;
import com.example.institute.entity.CourseDetails;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.CourseService;

import jakarta.validation.Valid;
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
   public ResponseEntity<String> createCourse(@Valid @RequestBody CourseDetails courseDetails) throws Exception {
       try{
           courseService.addCourse(courseDetails);
           return new ResponseEntity<>(courseDetails.getInstituteId(), HttpStatus.CREATED);
       }
       catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
    @GetMapping("/getCourse")
   public ResponseEntity<ApiResponse> getCourses(){
    try {
        return new ResponseEntity<>(ApiResponseBuilder.successResponse(courseService.getCourseAll()), HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(ApiResponseBuilder.failureResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
   }
   @GetMapping("/getCourseById/{id}")
   public ResponseEntity<ApiResponse> getCourseById(@PathVariable String id) throws Exception {
       try {
           return new ResponseEntity<>(ApiResponseBuilder.successResponse(courseService.getCourseById(id)),HttpStatus.OK);
       }
       catch (Exception e){
             return  new ResponseEntity<>(ApiResponseBuilder.failureResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
}
