package com.example.institute.controller;

import com.example.institute.entity.Institute;
import com.example.institute.service.InstitueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InstituteController {
    @Autowired
    InstitueService institueService;
    @PostMapping("/addInstitute")
    public ResponseEntity<String> createInsitute(@RequestBody Institute institute){
        institueService.addInstitute(institute);
        return new ResponseEntity<>("institute added", HttpStatus.CREATED);
    }
    @GetMapping("/getInstituteById/{id}")
    public ResponseEntity<String> getInstitute(@PathVariable int id){
        institueService.getInstituteById(id);
        return new ResponseEntity<>("get institute details",HttpStatus.OK);
    }
}
