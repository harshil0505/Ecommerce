package com.example.Ecoomerce.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    public  String userName;
    public  String email;
    public  String password;
    public  String phoneNumber;
    public  String pinCode;
}