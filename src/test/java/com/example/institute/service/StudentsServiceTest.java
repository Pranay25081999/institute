package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import com.example.institute.validations.StudentValidation;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class StudentsServiceTest {
    @InjectMocks
    StudentsService studentsService;
    @Mock
    StudentsRepo studentsRepo;
    @Mock
    StudentValidation studentValidation;
    Stundents stundents = new Stundents();
    @Test
    @BeforeEach
    void setUp(){
        stundents.setEmailId("vis@gmail.com");
        stundents.setStudentName("vishwa");
        stundents.setCourseId("1");
        stundents.setStudentId("1");
    }
    @Test
     void addStudentTest() throws Exception {
        studentValidation.studentValidation(stundents);
        when(studentsRepo.save(stundents)).thenReturn(stundents);
        String s = studentsService.addStudent(stundents);
        assertEquals(stundents.getStudentId(),s);
    }
    @Test
    void addStudentTestWithFindThrow() throws Exception {
        studentValidation.studentValidation(stundents);
        when(studentsRepo.findByEmailId(stundents.getEmailId())).thenReturn(stundents);
        assertThrows(Exception.class,()->{studentsService.addStudent(stundents);});
    }
    @Test
    void addStudentTestWithNegative() throws Exception {
        studentValidation.studentValidation(stundents);
        when(studentsRepo.save(stundents)).thenReturn(null);
        assertThrows(Exception.class,()->{studentsService.addStudent(stundents);});
    }

    @Test
    void getStudentByIdTest() throws Exception {
        when(studentsRepo.findById(stundents.getStudentId())).thenReturn(Optional.of(stundents));
        String studentId = studentsService.getStudentById(stundents.getStudentId()).getStudentId();
        assertEquals("1",studentId);
    }

    @Test
     void givenStudentByIdWithNegative() throws Exception {
        when(studentsRepo.findById(stundents.getStudentId())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class,() ->{studentsService.getStudentById(stundents.getCourseId());});
    }

    @Test
     void getAllStudentsTest() throws Exception {
        String id = "1";
        Stundents stundents = new Stundents();
        stundents.setStudentId("1");
        when(studentsRepo.findAll()).thenReturn((List.of(stundents)));
        boolean empty = studentsService.getAllStudents().isEmpty();
        assertEquals(false, empty);
    }
}