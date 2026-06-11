package com.example.Ecoomerce.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;

    @NotBlank
    public  String name;

    @NotBlank
    @Email
    @Column(unique = true)

    public  String email;

    @NotBlank
    @Column(unique = true)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "must be 8-20 characters long one in include small letter,include capital letter,include special ,include number "
    )
    public  String password;

    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^[1-9][0-9]{9}$")
    public  String phoneNumber;

    @NotBlank
    @Pattern(regexp ="^[1-9][0-9]{5}$")
    public  String pinCode;
    
 
    @ManyToMany(cascade ={ CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    public Set<Role> roles = new HashSet<>();

    public User(String name,String email,String password){
        this.name = name;
        this.email=email;
        this.password = password;
    }
}
