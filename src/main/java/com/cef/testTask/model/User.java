package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "users_table")
public class User extends Model {

    @Size(min = 3, max = 32, message = "Set login from 3 to 32 letters.")
    private String login;

    private String password;

    @Size(min = 3, max = 32, message = "Set name 3 to 32 letters.")
    private String name;

    @Email(message = "Email should be valid.")
    private String email;

    private String fileName;

    private String filePath;

}
