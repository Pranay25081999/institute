package com.example.institute.controller;
import com.example.institute.apiRespponse.ApiResponseBuilder;
import com.example.institute.entity.Institute;
import com.example.institute.model.ApiResponse;
import com.example.institute.service.InstitueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InstituteController {
    @Autowired
    InstitueService institueService;

    @PostMapping("/addInstitute")
    public ResponseEntity<String> createInsitute(@Valid @RequestBody Institute institute) throws Exception {
        try {
            institueService.addInstitute(institute);
            return new ResponseEntity<>(institute.getInstituteId(), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getInstitute")
    public ResponseEntity<ApiResponse> getInstitute(){
    try{
        return new ResponseEntity<>(ApiResponseBuilder.successResponse(institueService.getInstituteAll()),HttpStatus.OK);
    }catch (Exception e){
        return  new ResponseEntity<>(ApiResponseBuilder.failureResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/getInstitute/{id}")
    public ResponseEntity<ApiResponse> getInstituteById(@PathVariable String id) throws Exception {
        try{
            return new ResponseEntity<>(ApiResponseBuilder.successResponse(institueService.getInstituteById(id)),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(ApiResponseBuilder.failureResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
