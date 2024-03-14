package com.example.institute.service;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import com.example.institute.validations.Institutevalidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
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

    Institute institute = new Institute();
    @BeforeEach
    void setUp(){
        String id = "1";
        institute.setInstituteId(id);
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
    }

    @Test
     void getInstitueByIdTest() {
        when(instituteRepo.findById(institute.getInstituteId())).thenReturn(Optional.of(institute));
        String instituteId = institueService.getInstituteById(institute.getInstituteId()).getInstituteId();
        assertEquals("1", instituteId);
    }

    @Test
    void getInsituteByIdWithNegativeTest() {
        when(instituteRepo.findById(institute.getInstituteId())).thenReturn(Optional.empty());
        assertThrows(Exception.class,() ->{institueService.getInstituteById(institute.getInstituteId());});
    }
    @Test
     void getAllInstituteTest() throws Exception {
        when(instituteRepo.findAll()).thenReturn(List.of(institute));
        List<Institute> instituteAll = institueService.getInstituteAll();
        assertEquals(false, instituteAll.isEmpty());
    }
    @Test
     void getAllInstituteTestWithNegative() throws Exception {
        when(instituteRepo.findAll()).thenThrow(new RuntimeException());
        assertThrows(Exception.class,() ->institueService.getInstituteAll());
    }
    @Test
     void addInstituteTest() throws Exception {
        String id = "1";
        Institute institute = new Institute();
        institute.setInstituteEmail("pra@gmail.com");
        institute.setInstituteMobileNumber("+91 876543219");
        when(instituteRepo.save(institute)).thenReturn(institute);
        boolean empty = institueService.addInstitute(institute).isEmpty();
        assertEquals(false, empty);
    }

    @Test
     void addInstituteTestWithNegative() {
        when(instituteRepo.save(institute)).thenThrow(new RuntimeException());
        assertThrows(Exception.class, () -> institueService.addInstitute(institute));
    }
    @Test
    void addInstituteTestWithThrow(){
        when(instituteRepo.findByInstituteEmail(institute.getInstituteEmail())).thenReturn(institute);
        assertThrows(Exception.class,()->{institueService.addInstitute(institute);});
    }
}