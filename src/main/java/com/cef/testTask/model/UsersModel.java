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

    //@NotEmpty(message = "Email should not be empty.")
    //@Size(min =2, max = 32, message = "Wrong name size")
    String email;

    //@NotEmpty(message = "Login should not be empty.")
    //@Size(min =2, max = 32, message = "Wrong login size")
    String login;

    //@NotEmpty(message = "Password should not be empty.")
    //@Size(min =6, max = 32, message = "Minimum 6 symbols.")
    String password;




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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, login, password);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", userName='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
