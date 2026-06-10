package com.example.Ecoomerce.controller;

import com.example.Ecoomerce.dto.LoginDto;
import com.example.Ecoomerce.dto.RegisterDto;
import com.example.Ecoomerce.model.Login;
import com.example.Ecoomerce.model.Register;
import com.example.Ecoomerce.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/api")
public class AuthController {


    @Autowired
    private AuthService  authService;

    @PostMapping("/register")
    public ResponseEntity<Register> register(@RequestBody  RegisterDto registerDto){
        Register dto = authService.storeRegister(registerDto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody  LoginDto loginDto, RegisterDto registerDto) throws UserPrincipalNotFoundException {
        Login dto = authService.loginToUser(loginDto,registerDto);
        return ResponseEntity.ok(dto);
    }
}
