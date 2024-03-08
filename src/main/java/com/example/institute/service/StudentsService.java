package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import com.example.institute.validations.StudentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    @Autowired
    StudentsRepo studentsRepo;
    @Autowired
    StudentValidation studentValidation;
    public String addStudent(Stundents stundents) throws Exception {
        studentValidation.studentValidation(stundents);
        String emailId = stundents.getEmailId();
        if (studentsRepo.findByEmailId(emailId)!=null) {
            throw new Exception("This emailId is already registered ");
        } else {
            studentsRepo.save(stundents);
        }
        return "";
    }

    public String getStudentById(String id) throws Exception {
        Optional<Stundents> byId = studentsRepo.findById(id);
        if(!byId.isEmpty()) {
            return byId.get().getStudentId();
        }
        else{
            throw new Exception("There is no student with this id");
        }
    }
    public List<Stundents> getAllStudents()
    {
        return studentsRepo.findAll();
    }
}
