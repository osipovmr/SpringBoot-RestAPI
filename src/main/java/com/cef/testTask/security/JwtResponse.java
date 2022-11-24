package com.cef.testTask.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor

public class JwtResponse {

    private String accessToken;
    private String refreshToken;

    @Override
    public String toString() {
        return "Сгенерированные токены: "
                +"<br>"+
                "accessToken = " + accessToken
                +"<br>"+
                "refreshToken = " + refreshToken;
    }
}
