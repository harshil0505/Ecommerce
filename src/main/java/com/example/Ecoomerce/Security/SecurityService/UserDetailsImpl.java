package com.example.Ecoomerce.Security.SecurityService;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Ecoomerce.model.User;

import jakarta.servlet.http.HttpServletRequest;

public class UserDetailsImpl implements UserDetails{

    private String name;
    private String password;
    private String phoneNumber;
    private String pinCode;
    private Collection<? extends GrantedAuthority> authorities;

     public UserDetailsImpl(String name, String password, String phoneNumber, String pinCode,Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.password = password;
        this.phoneNumber=phoneNumber;
        this.pinCode=pinCode;
        this.authorities = authorities;
    }

    public static UserDetails build(User user) {
      List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.roleName.name()))
            .toList();
      return new UserDetailsImpl(
            user.getName(),
            user.getPassword(),
            user.getPhoneNumber(),
            user.getPinCode(),
            authorities
      );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
    } 

    @Override
    public String getUsername(){
        return name;
    }

    public String getPassword() {
            return password;
    }

 
    public String getPhoneNumber() {
       return phoneNumber;
    }
    
    public String getPinCode(){
        return pinCode;
    }

    public boolean isAccountNonLocked(){
        return true;
    }

    public boolean isAccountNonExpired(){
        return true;
    }
     
    public boolean isEnabled(){
        return true;
    }

    public boolean isCredentialsNonExpired(){
        return true;
    }

  

   

   
    
    
   
}
