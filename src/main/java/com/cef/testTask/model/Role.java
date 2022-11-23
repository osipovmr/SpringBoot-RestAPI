package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Role_table")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
