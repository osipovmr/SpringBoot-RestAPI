package com.cef.testTask.security;

import com.cef.testTask.model.Role;
import com.cef.testTask.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class JwtCreate {

    Map<String, Object> claims = new HashMap<>();

    //короткий токен
    public String accessToken(@NonNull User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        List<String> roles = user.getRoles().stream().map(Role::getName).toList();
        claims.put("roles", roles);
        claims.put("login", user.getLogin());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(accessExpiration)
                .signWith(SignatureAlgorithm.HS512, "hello")
                .compact();
    }
    //долгий токен
    public String refreshToken(@NonNull User user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        List<String> roles = user.getRoles().stream().map(Role::getName).toList();
        claims.put("roles", roles);
        claims.put("login", user.getLogin());
        claims.put("email", user.getEmail());
        claims.put("name", user.getName());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(refreshExpiration)
                .signWith(SignatureAlgorithm.HS512, "privet")
                .compact();
    }

}
