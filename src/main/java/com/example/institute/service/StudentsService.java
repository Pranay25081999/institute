package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import com.example.institute.validations.StudentValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentsService {

    private final StudentsRepo studentsRepo;

    private final StudentValidation studentValidation;

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

    public Stundents getStudentById(String id) {
        Optional<Stundents> byId = studentsRepo.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NoSuchElementException("There is no student with this id");
        }
    }

    public List<Stundents> getAllStudents() {
        return studentsRepo.findAll();

    }
}
