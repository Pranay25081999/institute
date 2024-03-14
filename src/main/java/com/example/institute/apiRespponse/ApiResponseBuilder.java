package com.example.institute.apiRespponse;

import com.example.institute.model.ApiResponse;

public class ApiResponseBuilder {



    public  static ApiResponse successResponse(Object data) {
        return ApiResponse.builder().data(data).statusCode(200).build();
    }

    public static ApiResponse failureResponse(String message) {

        return ApiResponse.builder().message(message).statusCode(500).build();
    }
}