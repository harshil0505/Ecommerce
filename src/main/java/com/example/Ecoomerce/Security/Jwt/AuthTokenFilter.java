package com.example.Ecoomerce.Security.Jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.Ecoomerce.model.User;
import com.example.Ecoomerce.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtil jwtUtil;

    private final Logger logger =LoggerFactory.getLogger(AuthTokenFilter.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
      try{
            String requestTokenHeader = request.getHeader("Authorization");
            if(requestTokenHeader == null || requestTokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
    }

        String token = requestTokenHeader.split("Bearer")[1];
        String name = jwtUtil.getUserNameFromJwtToken(token);

        if(name != null || SecurityContextHolder.getContext().getAuthentication() == null ){
            User user = userRepository.findByUserName(name)
                 .orElseThrow(() -> new UsernameNotFoundException("name" + name));
             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(name,  null,user.getAuthorities());
             SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken) ;   
        }
       
         }catch (Exception e) {
                logger.error("Cannot set user authentication: {}", e);
            }
            
         filterChain.doFilter(request, response);
        }
}
