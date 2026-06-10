package com.example.Ecoomerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name")
    public  Register register;


    @OneToOne
    @JoinColumn(name = "password")
    public Register registerPassword;


    public UserPrincipalNotFoundException orElseThrow(Object o) {
        return new UserPrincipalNotFoundException(o.toString());
    }
}
