package com.example.institute.controller;

import com.example.institute.entity.Institute;
import com.example.institute.service.InstitueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Institute>> getInstitute() {
    try{
        return new ResponseEntity<>(institueService.getInstituteAll(),HttpStatus.OK);
    }catch (Exception e){
        return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    }

    @GetMapping("/getInstitute/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable String id) throws Exception {
        try{
         Optional<Institute> institute= institueService.getInstituteById(id);
            return new ResponseEntity<>(institute.get(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
