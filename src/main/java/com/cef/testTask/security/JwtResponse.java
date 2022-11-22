package com.cef.testTask.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
//ответ пользователю
public class JwtResponse {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;


    }

