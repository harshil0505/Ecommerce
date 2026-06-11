package com.example.Ecoomerce.excepasion;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GolbalExcepasionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> myMethodNotValidasion(MethodArgumentNotValidException e){
        Map<String,String> response = new HashMap<>();
        e .getBindingResult().getAllErrors().forEach(error ->{
        String fieldName = ((FieldError) error) .getField();
        String message =error.getDefaultMessage();
        response.put(fieldName,message);
    });
            return new  ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
}

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ApiExcepasion> myResoureceNotFound(ResourceNotFoundException e){
    String message = e.getMessage();
    ApiResponse apiResponse = new ApiResponse( message,true );
    return new  ResponseEntity<>(apiResponse,HttpStatus.BAD_REQUEST);
   }
}
