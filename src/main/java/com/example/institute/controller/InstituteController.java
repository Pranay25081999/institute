package com.example.institute.controller;

import com.example.institute.entity.Institute;
import com.example.institute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institute")
public class InstituteController {
    @Autowired
    InstituteService instituteService;
   @PostMapping("/addCourse")
   public ResponseEntity<String> createCourse(@RequestBody Institute institute){
        instituteService.addCourse(institute);
        return new ResponseEntity<>("course is added", HttpStatus.CREATED);
    }
    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Integer> getCourseById(@PathVariable int id){
        instituteService.getCourseById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
    @PutMapping("/Update/{id}")
    public ResponseEntity<String> updateCourseById(@RequestBody Institute institute){
       return new ResponseEntity<>("Hello updated",HttpStatus.OK);
    }

}
