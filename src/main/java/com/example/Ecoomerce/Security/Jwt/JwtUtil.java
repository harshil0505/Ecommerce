package com.example.Ecoomerce.Security.Jwt;



import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.web.util.WebUtils;

import com.example.Ecoomerce.Security.SecurityService.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class JwtUtil  {
   
  @Value("${spring.app.secretKey}")   
  private String secretKey;  

  @Value("${spring.app.jwtCookie}")   
  private String jwtCookie;  

  @Value("${spring.app.expirationTimeMillis}")   
  private String  expirationTimeMillis;  
  
;  


public String generateFromCookie(HttpServletRequest request){
    Cookie cookies=WebUtils.getCookie(request,jwtCookie);
    if(cookies != null){
        return cookies.getValue();
    }else{
        return null;
    }
    }


    public ResponseCookie generateJwtToken(UserDetailsImpl userDetailsImpl){
        String jwt = generateFromUserToCookie(userDetailsImpl.getUsername());
                ResponseCookie responseCookie = ResponseCookie.from(jwtCookie, jwt)
                                            .path("/api")
                                            .maxAge(24 * 60 * 60) 
                                            .build();

                                            return responseCookie; 
                                    }

     public String getUserNameFromJwtToken(String token){
        Claims claims = Jwts.parserBuilder()
                            .setSigningKey(key())
                            .build()
                            .parseClaimsJws(token)
                            .getBody();
        return claims.getSubject();
     }                              
                                    
     public String generateFromUserToCookie(String name) {
           return Jwts.builder()
                      .setSubject(name)
                      .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)))
                      .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                      .signWith(key())
                      .compact();
                     
           
     }

   
     private Key key() {
       return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
     }                         
                                               
        
        
            
}
