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
    public ResponseEntity<String> createInsitute(@Valid @RequestBody Institute institute) {
        institueService.addInstitute(institute);
        return new ResponseEntity<>("institute added", HttpStatus.CREATED);
    }

    @GetMapping("/getInstitute")
    public List<Institute> getInstitute() {

        return institueService.getInstituteAll();
    }

    @GetMapping("/getInstitue/{id}")
    public String getInstituteById(String id) {
        institueService.getInstituteById(id);
        return id;
    }
}
