package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentsService {
    @Autowired
    StudentsRepo studentsRepo;
    public String addStudent(Stundents stundents){
        studentsRepo.save(stundents);
        return "";
    }
    public int getStudentById(int id){
        Optional<Stundents> byId =studentsRepo.findById(id);
        return byId.get().getStudentId();
    }
}
