package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "order_table")
public class Order extends Model{

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Product name should not be empty.")
    @Size(min = 3, max = 32, message = "Set product name from 3 to 32 letters.")
    String product;
    @NotNull(message = "Value should not be empty.")
    @Min(value = 1, message = "Minimum value = 1.")
    Integer value;
    @NotEmpty(message = "City should not be empty.")
    String city;

}
