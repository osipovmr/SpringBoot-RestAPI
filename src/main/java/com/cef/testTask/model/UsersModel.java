package com.cef.testTask.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users_table")
public class UsersModel extends Model {

    String login;
    String password;
    String name;
    String email;
    String image;


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UsersModel(){}

    public UsersModel(String login, String password, String name, String email, String image) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.image = image;
    }
}
