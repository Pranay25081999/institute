package com.example.institute.controller;

import com.example.institute.entity.Stundents;
import com.example.institute.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentsService studentsService;
    @PostMapping("/addStudent")
    public ResponseEntity<String> createStudent(@RequestBody Stundents stundents){
        studentsService.addStudent(stundents);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Integer> getStudentById(@PathVariable int id){
        studentsService.getStudentById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
}
