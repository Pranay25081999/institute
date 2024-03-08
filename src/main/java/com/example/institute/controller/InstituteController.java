package com.example.institute.controller;

import com.example.institute.entity.Institute;
import com.example.institute.service.InstitueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstituteController {
    @Autowired
    InstitueService institueService;

    @PostMapping("/addInstitute")
    public ResponseEntity<String> createInsitute(@Valid @RequestBody Institute institute) throws Exception {
        try {
            institueService.addInstitute(institute);
            return new ResponseEntity<>("institute added", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getInstitute")
    public List<Institute> getInstitute() {

        return institueService.getInstituteAll();
    }

    @GetMapping("/getInstitute/{id}")
    public ResponseEntity<String> getInstituteById(@PathVariable String id) throws Exception {
        try{
            institueService.getInstituteById(id);
            return new ResponseEntity<>(id,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
