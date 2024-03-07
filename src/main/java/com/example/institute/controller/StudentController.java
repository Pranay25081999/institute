package com.example.institute.controller;

import com.example.institute.entity.Stundents;
import com.example.institute.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentsService studentsService;

    @PostMapping("/addStudent")
    public ResponseEntity<String> createStudent(@RequestBody Stundents stundents) throws Exception {
        try{
            studentsService.addStudent(stundents);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<String> getStudentById(@PathVariable String id){
        studentsService.getStudentById(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public List<Stundents> getAllStudents(){
        return studentsService.getAllStudents();
    }
}
