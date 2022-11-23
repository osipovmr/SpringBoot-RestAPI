package com.cef.testTask.model;

import lombok.Data;


import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "role_table")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public String getName(int id) {
        return name;
    }
}
