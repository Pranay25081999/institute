package com.example.institute.controller;

import com.example.institute.entity.Stundents;
import com.example.institute.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Stundents> getStudentById(@PathVariable String id) throws Exception {
        try {
            Optional<Stundents> studentById = studentsService.getStudentById(id);
            return new ResponseEntity<>(studentsService.getStudentById(id).get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(studentsService.getStudentById(id).get(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Stundents>> getAllStudents() throws Exception {
        Stundents stundents = null;
        try {
            stundents = new Stundents();
            List<Stundents> allStudents = studentsService.getAllStudents();
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }
}
