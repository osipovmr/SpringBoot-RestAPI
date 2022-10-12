package com.cef.testTask.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users_table")
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String login;
    String password;
    String name;
    String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public UsersModel(){}

    public UsersModel(Integer id, String login, String password, String name, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
