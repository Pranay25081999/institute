package com.example.institute.exception;

public class DetailsNotFound extends RuntimeException{
    private static final long serialVersionUID=1l;
    public DetailsNotFound(String message){
        super(message);
    }


}
