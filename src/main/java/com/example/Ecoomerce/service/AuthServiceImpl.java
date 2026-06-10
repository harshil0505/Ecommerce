package com.example.Ecoomerce.service;


import com.example.Ecoomerce.dto.LoginDto;
import com.example.Ecoomerce.dto.RegisterDto;

import com.example.Ecoomerce.model.Login;
import com.example.Ecoomerce.model.Register;
import com.example.Ecoomerce.repository.RegisterRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Objects;


@Service
public class AuthServiceImpl implements AuthService {


    private ModelMapper modelMapper;

    @Autowired
    private RegisterRepository  registerRepository;

    @Override
    public Register storeRegister(RegisterDto registerDto) {
       Register register = EntityToDto(registerDto);
       return registerRepository.save(register);

    }

    @Override
    public Login loginToUser(LoginDto loginDto, RegisterDto registerDto)throws UserPrincipalNotFoundException {


       // Login login=  registerRepository.findByName(registerDto.name).orElseThrow(() -> new ("User " +registerDto.name + "not found "));


        if (Objects.equals(registerRepository.equals(registerDto.name) ,loginDto.getName()) &&  Objects.equals(registerRepository.equals(registerDto.password), loginDto.getPassword())) {
           System.out.println("Login Success");

       }else{
           System.out.println("Login Fail");
       }
       return  null;
    }

    public Register EntityToDto(RegisterDto registerDto) {
    Register register = new Register();
    register.setName(registerDto.getName());
    register.setEmail(registerDto.getEmail());
    register.setPassword(registerDto.getPassword());
    register.setPhoneNumber(registerDto.getPhoneNumber());
    register.setPinCode(registerDto.getPinCode());


    return register ;
    }




}
