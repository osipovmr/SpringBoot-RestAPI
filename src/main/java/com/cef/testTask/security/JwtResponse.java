package com.cef.testTask.security;

import lombok.Data;

@Data
public class JwtResponse {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
