package com.example.institute.service;

import com.example.institute.entity.CourseDetails;
import com.example.institute.repository.CourseRepo;
import com.example.institute.validations.CourseValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
    @Mock
    CourseRepo courseRepo;
    @Mock
    CourseValidation courseValidation;
    @InjectMocks
    CourseService courseService;
    CourseDetails courseDetails=new CourseDetails();
    @BeforeEach
    void setUp(){
        String courseName="Java";
        String id="1";
        courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
    }
    @Test
    void getCourseByIdTest() throws Exception {

        when(courseRepo.findById(courseDetails.getInstituteId())).thenReturn(Optional.of(courseDetails));
        CourseDetails courseDetails1 = courseService.getCourseById(courseDetails.getInstituteId());
        assertEquals("1",courseDetails1.getInstituteId());
    }
    @Test
    void getCourseByIdTestWithNegative(){
        when(courseRepo.findById(courseDetails.getInstituteId())).thenReturn(Optional.empty());
        assertThrows(Exception.class,()->{courseService.getCourseById(courseDetails.getInstituteId());});
    }
    @Test
    public void getAllCourseTest() throws Exception {
        when(courseRepo.findAll()).thenReturn(List.of(courseDetails));
        boolean empty = courseService.getCourseAll().isEmpty();
        assertEquals(false,empty);
    }
    @Test
     void getAllCourseTestWithNegative() throws Exception {
        when(courseRepo.findAll()).thenThrow(new RuntimeException());
        assertThrows(Exception.class,() ->courseService.getCourseAll().isEmpty());
    }
    @Test
     void addCourseTest() throws Exception {
        courseValidation.courseValidation(courseDetails);
        when(courseRepo.save(courseDetails)).thenReturn(courseDetails);
        String s = courseService.addCourse(courseDetails);
        assertEquals(courseDetails.getInstituteId(),s);
    }
    @Test
    void addCourseWithNegative() throws Exception {
        courseValidation.courseValidation(courseDetails);
        when(courseRepo.findByCourseName(courseDetails.getCourseName())).thenReturn(courseDetails);
        assertThrows(Exception.class,()->{courseService.addCourse(courseDetails);});
    }
    @Test
    void addCourseWithNegativeThrow() throws Exception {
        courseValidation.courseValidation(courseDetails);
        when(courseRepo.findByCourseName(courseDetails.getCourseName())).thenReturn(null);
        assertThrows(Exception.class,()->{courseService.addCourse(courseDetails);});
    }
}
