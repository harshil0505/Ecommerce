package com.example.Ecoomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long roleId;

    public AppRole roleName;

    @Enumerated(EnumType.STRING)
    public AppRole role;  

    public Role(AppRole roleName){
        this.roleName=roleName;
}

}
