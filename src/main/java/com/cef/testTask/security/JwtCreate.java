package com.cef.testTask.security;

import com.cef.testTask.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtCreate {

    //короткий токен
    public String accessToken(@NonNull User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);


        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(accessExpiration)
                //.signWith(SignatureAlgorithm.ES512)
                .claim("roles", user.getRoles())
                .compact();
    }
    //долгий токен
    public String refreshToken(@NonNull User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        String s = "1234";
        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(refreshExpiration)
                .claim("roles", user.getRoles())
                //.signWith(SignatureAlgorithm.ES256)
                .compact();
    }

}
