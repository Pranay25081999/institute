package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import com.example.institute.validations.StudentValidation;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class StudentsServiceTest {
    @InjectMocks
    StudentsService studentsService;
    @Mock
    StudentsRepo studentsRepo;
    @Mock
    StudentValidation studentValidation;

    @Test
    public void addInstituteTest() throws Exception {

        Stundents stundents = new Stundents();
        stundents.setEmailId("vis@gmail.com");
        stundents.setStudentName("vishwa");
        stundents.setCourseId("1");
        stundents.setStudentId("1");
        studentValidation.studentValidation(stundents);
        when(studentsRepo.save(stundents)).thenReturn(stundents);
        String s = studentsService.addStudent(stundents);
        assertEquals(false, !s.isEmpty());

    }

    @Test
    public void addInstituteTestWithNegative() throws Exception {
        Stundents stundents = new Stundents();
        String id = "1";
        String emailId = "vishwa@gmail.com";
        stundents.setEmailId(emailId);
        stundents.setStudentName("vishwa");
        stundents.setCourseId("1");
        stundents.setStudentId("1");
        //  Stundents stundents1 = studentsService.getStudentById(stundents.getCourseId()).get();
        when(studentsRepo.save(stundents)).thenThrow(new RuntimeException());


        assertThrows(Exception.class, () -> {
            studentsService.addStudent(stundents);
        });
    }

    @Test
    public void getStudentByIdTest() throws Exception {
        String id = "1";
        Stundents stundents = new Stundents();
        stundents.setStudentId(id);
        stundents.setCourseId(id);
        when(studentsRepo.findById(id)).thenReturn(Optional.of(stundents));
        Stundents stundents1 = studentsService.getStudentById(stundents.getCourseId()).get();
        assertEquals("1", stundents1.getStudentId());
    }

    @Test
    public void givenStudentByIdWithNegative() throws Exception {
        String id = "1";
        Stundents stundents = new Stundents();
        stundents.setStudentId(id);
        when(studentsRepo.findById(id)).thenReturn(Optional.of(stundents));
        assertThrows(Exception.class, () -> {
            studentsService.getStudentById(stundents.getCourseId()).get();
        });
    }

    @Test
    public void getAllStudentsTest() throws Exception {
        String id = "1";
        Stundents stundents = new Stundents();
        stundents.setStudentId("1");
        when(studentsRepo.findAll()).thenReturn((List.of(stundents)));
        boolean empty = studentsService.getAllStudents().isEmpty();
        assertEquals(false, empty);
    }

    @Test
    public void getAllStudentsTestWithNegative() throws Exception {
        String id = "1";
        Stundents stundents = new Stundents();
        when(studentsRepo.findAll()).thenThrow(new RuntimeException());
         assertThrows(Exception.class,() ->studentsService.getAllStudents().isEmpty());
    }
}