package com.example.institute.service;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InstitueService {
    @Autowired
    InstituteRepo instituteRepo;
    public String addInstitute(Institute institute){
        instituteRepo.save(institute);
        return "";
    }
    public String getInstituteById(int id){
        instituteRepo.findById(id);
        return "";
    }
}
