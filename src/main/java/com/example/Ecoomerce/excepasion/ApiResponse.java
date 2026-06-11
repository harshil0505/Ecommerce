package com.example.Ecoomerce.excepasion;

public class ApiResponse {

    public String message;
    public boolean statusCode;

    public ApiResponse(String message,boolean statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }
}
