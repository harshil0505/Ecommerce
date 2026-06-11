package com.example.Ecoomerce.Security;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.Ecoomerce.Security.Jwt.AuthTokenFilter;
import com.example.Ecoomerce.model.AppRole;
import com.example.Ecoomerce.model.Role;
import com.example.Ecoomerce.model.User;
import com.example.Ecoomerce.repository.RoleRepository;
import java.util.Optional;
import java.util.Set;

import com.example.Ecoomerce.repository.UserRepository;

@Configuration
public class WebSecurity {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthTokenFilter authTokenFilter;

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated()
        )
        .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
                    return http.build();
                }
            

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,RoleRepository rolepRepository,PasswordEncoder passwordEncoder){
        Role admin = rolepRepository.findByRoleName(AppRole.ADMIN)
              .orElseGet(() -> {
                 Role newAdmin = new Role(AppRole.ADMIN);
                 return rolepRepository.save(newAdmin);
            });
          
            Role user = rolepRepository.findByRoleName(AppRole.USER)
              .orElseGet(() -> {
                 Role newUser = new Role(AppRole.USER);
                 return rolepRepository.save(newUser);
            });

            Role seller = rolepRepository.findByRoleName(AppRole.SELLER)
              .orElseGet(() -> {
                 Role newSeller = new Role(AppRole.SELLER);
                 return rolepRepository.save(newSeller);
            });

           Set<Role> admins = Set.of(admin);
           Set<Role> Users = Set.of(user);
           Set<Role> Sellers = Set.of(seller);

           if(userRepository.existsByUserName("user1")){
                User user1 = new User("User1", "User546@mail.com", passwordEncoder.encode("Test?336"));
                   userRepository.save(user1);             
                  

                   if(userRepository.existsByUserName("user1")){
                    User admin1 = new User("admin1", "Admin123@mail.com", passwordEncoder.encode("Admin?336"));
                       userRepository.save(admin1);             
                      
                       if(userRepository.existsByUserName("user1")){
                        User seller1 = new User("seller1", "Seller123@mail.com", passwordEncoder.encode("Selle45?336"));
                           userRepository.save(seller1);             
                          
                        
                             }
                          }
         
         
             
         
         
    }
               return null;

    }
}