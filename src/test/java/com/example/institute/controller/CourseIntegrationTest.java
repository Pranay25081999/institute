package com.example.institute.controller;

import com.example.institute.entity.CourseDetails;
import com.example.institute.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
public class CourseIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    CourseService courseService;
    @Test
    public void createCourseIntegrationTest() throws Exception {
        CourseDetails courseDetails=new CourseDetails();
        courseDetails.setInstituteId("1");
        courseDetails.setCourseName("java");
        courseDetails.setCourseDuration(3);
        mockMvc.perform(post("/api/addCourse").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(courseDetails))).andDo(print()).andExpect(status().isCreated());
    }
    @Test
    public void getCourseIntegrationTest() throws Exception {
        mockMvc.perform(get("/api/getCourse")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void getCourseByIdIntegrationTest() throws Exception {
        String id="1";
        mockMvc.perform(get("/api/getCourseById/{id}",id)).andDo(print()).andExpect(status().isOk());
    }
}
