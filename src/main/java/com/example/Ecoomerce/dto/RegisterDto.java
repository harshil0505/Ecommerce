package com.example.Ecoomerce.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {


    public  String name;
    public  String email;
    public  String password;
    public  String phoneNumber;
    public  String pinCode;
}