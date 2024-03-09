package com.example.institute.service;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import com.example.institute.validations.Institutevalidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InstituteServiceTest {
    @InjectMocks
    InstitueService institueService;
    @Mock
    InstituteRepo instituteRepo;
    @Mock
    Institutevalidation institutevalidation;

    @Test
    public void getInstitueByIdTest() throws Exception {
        String id = "1";
        Institute institute = new Institute();
        institute.setInstituteId("1");
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.findById(id)).thenReturn(Optional.of(institute));
        Institute institute1 = institueService.getInstituteById(institute.getInstituteId()).get();
        assertEquals("1", institute1.getInstituteId());
    }

    @Test
    public void getInsituteByIdWithNegativeTest() {
        String id = "1";
        Institute institute = new Institute();
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.findById(id)).thenReturn(Optional.of(institute));
        assertThrows(Exception.class, () -> {
            institueService.getInstituteById(institute.getInstituteId()).get();
        });
    }
    @Test
    public void getAllInstituteTest() throws Exception {
        String id = "1";
        Institute institute = new Institute();
        institute.setInstituteId("1");
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.findAll()).thenReturn(List.of(institute));
        List<Institute> instituteAll = institueService.getInstituteAll();
        assertEquals(false, instituteAll.isEmpty());
    }
    @Test
    public void getAllInstituteTestWithNegative() throws Exception {
        String id = "1";
        Institute institute = new Institute();
       // institute.setInstituteId("1");
        //institute.setInstituteEmail("pra@gmail.com");
        //institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.findAll()).thenThrow(new RuntimeException());
        assertThrows(Exception.class,() ->institueService.getInstituteAll());
    }
    @Test
    public void addInstituteTest() throws Exception {
        String id = "1";
        Institute institute = new Institute();
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.save(institute)).thenReturn(institute);
        boolean empty = institueService.addInstitute(institute).isEmpty();
        assertEquals(false, empty);
    }

    @Test
    public void addInstituteTestWithNegative() throws Exception {
        String id = "1";
        Institute institute = new Institute();
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.save(institute)).thenThrow(new RuntimeException());
        assertThrows(Exception.class, () -> institueService.addInstitute(institute));

    }
}