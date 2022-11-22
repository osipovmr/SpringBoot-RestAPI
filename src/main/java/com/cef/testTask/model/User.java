package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    private String fileName;

    private String filePath;

}
