package com.example.institute.controller;

import com.example.institute.apiRespponse.ApiResponseBuilder;
import com.example.institute.entity.Stundents;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentsService studentsService;
    @PostMapping("/addStudent")
    public ResponseEntity<String> createStudent(@RequestBody Stundents stundents) {
        try {
            return new ResponseEntity<>("studentId is : "+ studentsService.addStudent(stundents), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<ApiResponse> getStudentById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(ApiResponseBuilder.successResponse(studentsService.getStudentById(id)),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponseBuilder.failureResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllStudents(){
        try{
            return new ResponseEntity<>(ApiResponseBuilder.successResponse( studentsService.getAllStudents()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(ApiResponseBuilder.failureResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


