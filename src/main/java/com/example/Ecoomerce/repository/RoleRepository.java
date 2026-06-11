package com.example.Ecoomerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ecoomerce.model.AppRole;
import com.example.Ecoomerce.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

  Optional<Role>  findByRoleName(AppRole adnin);

}
