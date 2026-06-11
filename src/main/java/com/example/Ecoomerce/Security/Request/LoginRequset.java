package com.example.Ecoomerce.Security;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class LoginRequset {

 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userId;

    @NotBlank
    public  String userName;

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
    
}
