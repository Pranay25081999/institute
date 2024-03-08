package com.example.institute.validations;

import com.example.institute.entity.Stundents;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class StudentValidation {
    public void studentValidation(Stundents stundents) throws Exception {
        if(stundents==null){
            throw new Exception("students should not be null");
        }
        if(stundents.getStudentName()==null){
            throw new Exception("studentName should not be null");
        }
        if(stundents.getCourseId()==null){
            throw new Exception("courseId should not be null");
        }
        if(stundents.getEmailId()==null){
            throw new Exception("emailId should not be null");
        }
        String emailId = stundents.getEmailId();
        final Pattern VALID_EMAIL=Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        if(!emailId.matches(String.valueOf(VALID_EMAIL))){
            throw new Exception("Please provide correct email");
        }
    }
}
