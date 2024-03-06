package com.example.institute.service;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitueService {
    @Autowired
    InstituteRepo instituteRepo;

    public String addInstitute(Institute institute){
        instituteRepo.save(institute);
        return "";
    }
    public List<Institute> getInstituteAll(){
        return instituteRepo.findAll();
    }
}
