package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users_table")
public class UsersModel extends Model {

    @NotBlank(message = "Name should not be empty.")
    @Size(min = 3, max = 16, message = "Wrong name size")
    //pattern="(?=.*[A-z]).{3,}"
    //title="Must contain at least 3 or more characters"
    private String login;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$")
    private String password;
    private String name;
    @Email(message = "Email should be valid.")
    private String email;
    private String fileName;
    private String filePath;

}
