package com.example.Ecoomerce.excepasion;

public class ApiExcepasion extends RuntimeException {
    
    public ApiExcepasion(String message){
        super(message);
    }
}
