package com.example.institute.controller;

import com.example.institute.apiRespponse.ApiResponseBuilder;
import com.example.institute.entity.Stundents;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.StudentsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
 private static final Logger logInfo= LoggerFactory.getLogger(StudentController.class);
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
            logInfo.info("Entered into getStudentById method id: "+id);

            return new ResponseEntity<>(ApiResponseBuilder.successResponse(studentsService.getStudentById(id)),HttpStatus.OK);
        } catch (Exception e) {
            logInfo.error("Exception occured in getStudentById --->"+e.getMessage());
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


