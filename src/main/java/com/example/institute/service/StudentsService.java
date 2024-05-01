package com.example.institute.service;

import com.example.institute.controller.StudentController;
import com.example.institute.entity.Stundents;
import com.example.institute.exception.DetailsNotFound;
import com.example.institute.repository.StudentsRepo;
import com.example.institute.validations.StudentValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StudentsService {

    private final StudentsRepo studentsRepo;

    private final StudentValidation studentValidation;
    @Autowired
    ObjectMapper objectMapper;
    private static final Logger logInfo= LoggerFactory.getLogger(StudentsService.class);
    public String addStudent(Stundents stundents) throws Exception {
        studentValidation.studentValidation(stundents);
        String emailId = stundents.getEmailId();
        if (studentsRepo.findByEmailId(emailId) != null) {
            throw new Exception("This " + emailId + " is already registered");
        }
        Stundents savedStudent = studentsRepo.save(stundents);
        if (savedStudent != null) {
            return savedStudent.getStudentId();
        } else {
            throw new NoSuchElementException("Unable to save User : " + emailId);
        }

    }

    public Stundents getStudentById(String id) throws JsonProcessingException {
        Optional<Stundents> byId = studentsRepo.findById(id);
        if (!byId.isPresent()) {
           // return byId.get();
            throw new DetailsNotFound("There is no student with this id : "+id);
        }
       // } else {
          //  throw new NoSuchElementException("There is no student with this id");
       // }
        logInfo.debug("student details"+  objectMapper.writeValueAsString(byId.get()));
      ;
        return byId.get();
    }

    public List<Stundents> getAllStudents() {
        return studentsRepo.findAll();

    }
}
