package com.example.institute.controller;

import com.example.institute.entity.CourseDetails;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CourseControllerTest {
    @Mock
    CourseService courseService;
    @InjectMocks
    CourseController courseController;

    CourseDetails courseDetails=new CourseDetails();

    @BeforeEach
    void setUp(){
        String id="1";
        courseDetails.setInstituteId(id);
        courseDetails.setCourseName("Java");
        courseDetails.setCourseDuration(3);
    }

    @Test
     void getCourseByIdTest() throws Exception {
        when(courseService.getCourseById(courseDetails.getInstituteId())).thenReturn(courseDetails);
        ResponseEntity<ApiResponse> courseById = courseController.getCourseById(courseDetails.getInstituteId());
        CourseDetails data =(CourseDetails) courseById.getBody().getData();
        assertEquals("Java",data.getCourseName());
    }
    @Test
     void getCourseByIdTestWithNegative() throws Exception {
        when(courseService.getCourseById(courseDetails.getInstituteId())).thenThrow(new RuntimeException());
        HttpStatusCode statusCode = courseController.getCourseById(courseDetails.getInstituteId()).getStatusCode();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,statusCode);
    }
    @Test
     void getCourseTest() throws Exception {
        when(courseService.getCourseAll()).thenReturn(List.of(courseDetails));
        assertEquals(HttpStatus.OK,courseController.getCourses().getStatusCode());
    }
    @Test
     void getCourseTestWithNegative() throws Exception {
        when(courseService.getCourseAll()).thenThrow(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,courseController.getCourses().getStatusCode());
    }
    @Test
     void createCourseTest() throws Exception {
        when(courseService.addCourse(courseDetails)).thenReturn(null);
        assertEquals(HttpStatus.CREATED,courseController.createCourse(courseDetails).getStatusCode());
    }
    @Test
     void createCourseTestWithNegative() throws Exception {
        CourseDetails courseDetails=new CourseDetails();
        when(courseService.addCourse(courseDetails)).thenThrow(new RuntimeException());
        HttpStatusCode statusCode = courseController.createCourse(courseDetails).getStatusCode();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,statusCode);
    }

}
