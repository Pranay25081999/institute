package com.example.institute.controller;


import com.example.institute.entity.Institute;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.InstitueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class InstitueControllerTest {

    @Mock
    InstitueService institueService;
    @InjectMocks
    InstituteController instituteController;
    Institute institute;

    @BeforeEach
    void setUp(){
        institute=new Institute();
        String id="1";
        institute.setInstituteId(id);
        institute.setInstituteEmail("hello@gmail.com");
    }


    @Test
     void getInstitueTest() {
        when(institueService.getInstituteAll()).thenReturn(List.of(institute));
        ResponseEntity<ApiResponse> institute1 = instituteController.getInstitute();
        List<Institute> data = (List<Institute>) institute1.getBody().getData();
        assertEquals(1, data.size());
    }

    @Test
     void getInstituteTestWithNegative() {
        when(institueService.getInstituteAll()).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,instituteController.getInstitute().getStatusCode());
    }

   @Test
     void createInstitueTest() throws Exception {
        when(institueService.addInstitute(institute)).thenReturn(institute.getInstituteId());
       assertEquals(HttpStatus.CREATED,instituteController.createInsitute(institute).getStatusCode());
    }

    @Test
    void createInstitueTestWithNegative() throws Exception {
        when(institueService.addInstitute(institute)).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,instituteController.createInsitute(institute).getStatusCode());
    }
   @Test
    void getInstituteByIdTest() throws Exception {
        when(institueService.getInstituteById(institute.getInstituteId())).thenReturn(institute);
       ResponseEntity<ApiResponse> instituteById = instituteController.getInstituteById(institute.getInstituteId());
       Institute data =(Institute) instituteById.getBody().getData();
       assertEquals("1",data.getInstituteId());
    }
   @Test
    void getInstituteByIdTestWithNegative() throws Exception {
        when(institueService.getInstituteById(institute.getInstituteId())).thenThrow(new RuntimeException());
       ResponseEntity<ApiResponse> instituteById = instituteController.getInstituteById(institute.getInstituteId());
       assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,instituteById.getStatusCode());
    }
}
