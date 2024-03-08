package com.example.institute.service;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import com.example.institute.validations.Institutevalidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitueService {
    @Autowired
    InstituteRepo instituteRepo;
    @Autowired
    Institutevalidation institutevalidation;

    public String addInstitute(Institute institute) throws Exception {
        institutevalidation.instituteValidation(institute);
        String instituteEmail = institute.getInstituteEmail();
        if(instituteRepo.findByInstituteEmail(instituteEmail)!=null){
            throw new Exception("This Email is already exist");
        }else{
            instituteRepo.save(institute);
            return "institute is added";
        }

    }
    public List<Institute> getInstituteAll(){

        return instituteRepo.findAll();
    }
    public String getInstituteById(String id) throws Exception {

        if(!instituteRepo.findById(id).isEmpty()) {
            return "get isntitute";
        }
       else{
            throw new Exception("There is no institute with this id");
        }
    }
}
