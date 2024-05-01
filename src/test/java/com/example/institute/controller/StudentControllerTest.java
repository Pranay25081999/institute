package com.example.institute.controller;
import com.example.institute.entity.Stundents;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.StudentsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
  class StudentControllerTest {
    @Mock
    StudentsService studentsService;
    @InjectMocks
    StudentController studentController;
    Stundents stundents;
    @BeforeEach
    void setUp(){
        stundents=new Stundents();
        stundents.setStudentId("1");
        stundents.setStudentName("vishu");
    }

    @Test
     void getStudentByIdTest() throws JsonProcessingException {
        String studentId = stundents.getStudentId();
        when(studentsService.getStudentById(studentId)).thenReturn(stundents);
        ResponseEntity<ApiResponse> studentById = studentController.getStudentById(studentId);
        Stundents data =(Stundents) studentById.getBody().getData();
        assertEquals(studentId,data.getStudentId());
    }
    @Test
     void getStudentByIdTestWithNegative() throws Exception {
        String studentId = stundents.getStudentId();
        when(studentsService.getStudentById(studentId)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,studentController.getStudentById(studentId).getStatusCode());
    }
    @Test
     void getAllStudentsTest() throws Exception {
        when(studentsService.getAllStudents()).thenReturn(List.of(stundents));
        ResponseEntity<ApiResponse> allStudents = studentController.getAllStudents();
       List<Stundents> data =(List<Stundents>)allStudents.getBody().getData();
        assertEquals(1,data.size());
    }
    @Test
     void getAllStudentsTestWithNegative() throws Exception {
        when(studentsService.getAllStudents()).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,studentController.getAllStudents().getStatusCode());
    }
    @Test
     void createStudentTest() throws Exception {
        when(studentsService.addStudent(stundents)).thenReturn(stundents.getStudentId());
        String body = studentController.createStudent(stundents).getBody();
        assertEquals("studentId is : "+stundents.getStudentId(),body);
    }
    @Test
     void createStudentTestWithNegative() throws Exception {
        when(studentsService.addStudent(stundents)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,studentController.createStudent(stundents).getStatusCode());
    }

@Test
    void listof(){
        List<String> stringsList=List.of("a","b","c","d");
           List<String> list = stringsList.stream().filter((n) -> !n.equals("b") )
                   .filter(n->!n.equals("d")).map(String::toUpperCase).toList();
           System.out.println(list);
    }
}
