package com.example.institute.validations;

import com.example.institute.entity.Institute;
import com.example.institute.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Institutevalidation {


    public void instituteValidation(Institute institute) throws Exception {
        if(institute==null){
            throw new Exception(institute+"should not be null");
        }
        String instituteEmail = institute.getInstituteEmail();
        if(instituteEmail==null){
            throw new Exception("institute Email should not null");
        }



        if(institute.getInstituteName()==null){
            throw new Exception("instituteName should not be null");
        }
        if(institute.getInstitueAddress()==null){
            throw new Exception("instituteAddress should not be null");
        }
        if(institute.getInstituteMobileNumber()==null){
            throw new Exception("institueMobileNumber should not be null");
        }
        if(institute.getInstituteWebSite()==null){
            throw new Exception("institute website should not be null");
        }
        final Pattern VALID_EMAIL=Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        if(!instituteEmail.matches(String.valueOf(VALID_EMAIL))){
            throw new Exception("Please provide correct email");
        }



    }
}
