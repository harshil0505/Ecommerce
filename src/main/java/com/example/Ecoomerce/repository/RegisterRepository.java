package com.example.Ecoomerce.repository;


import com.example.Ecoomerce.model.Login;
import com.example.Ecoomerce.model.Register;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {


    Login findByName(String name);
}
