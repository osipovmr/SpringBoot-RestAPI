package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.List;


@Data
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 32, message = "Set login from 3 to 32 letters.")
    private String login;

    private String password;
    @Transient
    private String passwordConfirm;

    @Size(min = 3, max = 32, message = "Set name 3 to 32 letters.")
    private String name;

    @Email(message = "Email should be valid.")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    private String fileName;

    private String filePath;

}
