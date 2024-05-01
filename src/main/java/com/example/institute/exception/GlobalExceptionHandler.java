package com.example.institute.exception;

import com.example.institute.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DetailsNotFound.class)
    public ResponseEntity<ApiResponse> handleDetailsNotFound(DetailsNotFound detailsNotFound, WebRequest webRequest){
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
