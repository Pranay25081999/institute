package com.example.institute.controller;

import com.example.institute.entity.Institute;
import com.example.institute.service.InstitueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InstituteController.class)
public class InstituteIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    InstitueService institueService;
    @Test
    void createInstituteTestIntegration() throws Exception {
        Institute institute=new Institute();
        institute.setInstituteId("1");
        institute.setInstituteEmail("tech@gmail.com");
        institute.setInstituteName("tech");
        institute.setInstituteMobileNumber("+91 7654328911");
       ResultActions resultActions= mockMvc.perform(post("/api/addInstitute").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(institute)));
       resultActions.andDo(print()).andExpect(status().isCreated());
    }
    @Test
    void getAllInstitue() throws Exception {
        mockMvc.perform(get("/api/getInstitute")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    void getInstituteById() throws Exception {
        String id="1";
        mockMvc.perform(get("/api/getInstitute/{id}",id)).andDo(print()).andExpect(status().isOk());
    }
}
