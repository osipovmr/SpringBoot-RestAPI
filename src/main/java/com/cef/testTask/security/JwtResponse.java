package com.cef.testTask.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
    private String login;

    @Override
    public String toString() {
        return "Сгенерированные токены: "
                +"<br>"+
                "accessToken = " + accessToken
                +"<br>"+
                "refreshToken = " + refreshToken;
    }
}
