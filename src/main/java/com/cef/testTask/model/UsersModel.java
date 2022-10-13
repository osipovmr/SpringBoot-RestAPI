package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_table")
public class UsersModel extends Model {

    private String login;
    private String password;
    private String name;
    private String email;
    private String image;
}
