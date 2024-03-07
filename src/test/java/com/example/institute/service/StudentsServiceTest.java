package com.example.institute.service;

import com.example.institute.entity.Stundents;
import com.example.institute.repository.StudentsRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class StudentsServiceTest {
    @InjectMocks
    StudentsService studentsService;
    @Mock
    StudentsRepo studentsRepo;
  @Test
  public void getStudentByIdTest(){
        int id=1;
      Stundents stundents = new Stundents();
      stundents.setStudentId("");
      when(studentsRepo.findById("")).thenReturn(Optional.of(stundents));
      String data = studentsService.getStudentById("id");
      assertEquals(1,data);
    }

}