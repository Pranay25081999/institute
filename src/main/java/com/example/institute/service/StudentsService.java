package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    @Autowired
    StudentsRepo studentsRepo;
    public String addStudent(Stundents stundents) throws Exception{

            if (stundents.getStudentName() != null && !stundents.getStudentName().isEmpty()) {
                 studentsRepo.save(stundents);
                 return "";
            } else {

                throw new Exception("studentName should not be empty");

            }
    }
    public int getStudentById(int id){
        Optional<Stundents> byId =studentsRepo.findById(id);
        return byId.get().getStudentId();
    }
    public List<Stundents> getAllStudents(){
        return studentsRepo.findAll();
    }
}
