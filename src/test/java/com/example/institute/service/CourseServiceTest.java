package com.example.institute.service;

import com.example.institute.entity.CourseDetails;
import com.example.institute.repository.CourseRepo;
import com.example.institute.validations.CourseValidation;
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
public class CourseServiceTest {
    @Mock
    CourseRepo courseRepo;
    @Mock
    CourseValidation courseValidation;
    @InjectMocks
    CourseService courseService;
    @Test
    public void getCourseByIdTest() throws Exception {
        CourseDetails courseDetails=new CourseDetails();
        String courseName="Java";
        String id="1";
        courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
        when(courseRepo.findById(id)).thenReturn(Optional.of(courseDetails));
        CourseDetails courseDetails1 = courseService.getCourseById(courseDetails.getInstituteId()).get();
        assertEquals("1",courseDetails1.getInstituteId());
    }
    @Test
    public void getCourseByIdTestWithNegative(){
        CourseDetails courseDetails=new CourseDetails();
        String id="1";
     //   courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
        when(courseRepo.findById(id)).thenThrow(new RuntimeException());
        assertThrows(Exception.class,() ->{courseService.getCourseById(id);});
    }
    @Test
    public void getAllCourseTest() throws Exception {
        CourseDetails courseDetails= new CourseDetails();
        String courseName="Java";
        String id="1";
        courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
        when(courseRepo.findAll()).thenReturn(List.of(courseDetails));
        boolean empty = courseService.getCourseAll().isEmpty();
        assertEquals(false,empty);

    }
    @Test
    public void getAllCourseTestWithNegative() throws Exception {
        CourseDetails courseDetails= new CourseDetails();
        String courseName="Java";
        String id="1";
       // courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
        when(courseRepo.findAll()).thenThrow(new RuntimeException());
        assertThrows(Exception.class,() ->courseService.getCourseAll().isEmpty());

    }
    @Test
    public void addCourseTest() throws Exception {
        CourseDetails courseDetails=new CourseDetails();
        String courseName="Java";
        String id="1";
        courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
        when(courseRepo.save(courseDetails)).thenReturn(courseDetails);
        CourseDetails courseDetails1 = courseService.addCourse(courseDetails);
        assertEquals("Java",courseDetails1.getCourseName());
    }
    @Test
    public void addCourseWithNegative() {
        CourseDetails courseDetails = new CourseDetails();
        String id = "1";
        String courseName = "Java";
        courseDetails.setCourseName(courseName);
        courseDetails.setInstituteId(id);
        when(courseRepo.save(courseDetails)).thenThrow(new RuntimeException());
        assertThrows(Exception.class, () -> {
            courseService.addCourse(courseDetails);
        });

    }
}
