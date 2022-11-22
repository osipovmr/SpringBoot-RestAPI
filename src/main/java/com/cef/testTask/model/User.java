package com.cef.testTask.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_table")
public class User  {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles;



}