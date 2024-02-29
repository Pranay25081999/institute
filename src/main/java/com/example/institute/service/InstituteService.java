package com.example.institute.service;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteService {
    @Autowired
    InstituteRepo instituteRepo;
    public String addCourse(Institute institute){
        instituteRepo.save(institute);
        return "add";
    }
    public int getCourseById(int id){
        instituteRepo.findById(id);
        return id;
    }
}
