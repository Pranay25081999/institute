package com.example.institute.model;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
       String message;
         Object data;
      int statusCode;

}
