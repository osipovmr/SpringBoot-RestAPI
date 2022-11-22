package com.cef.testTask.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//пользователь присылает свои данные
public class JwtRequest {
    private String login;
    private String password;
}
