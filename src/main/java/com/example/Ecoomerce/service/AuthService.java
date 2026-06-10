package com.example.Ecoomerce.service;

import com.example.Ecoomerce.dto.LoginDto;
import com.example.Ecoomerce.dto.RegisterDto;
import com.example.Ecoomerce.model.Login;
import com.example.Ecoomerce.model.Register;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public interface AuthService {


    Register storeRegister(RegisterDto registerDto);

    Login loginToUser(LoginDto loginDto, RegisterDto registerDto) throws UserPrincipalNotFoundException;
}
