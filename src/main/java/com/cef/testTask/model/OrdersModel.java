package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "orders_table")
public class OrdersModel extends Model{

    @NotEmpty(message = "Product name should not be empty.")
    @Size(min = 3, max = 32, message = "Set product name from 3 to 32 letters.")
    String product;
    @NotNull(message = "Value should not be empty.")
    @Min(value = 1, message = "Minimum value = 1.")
    Integer value;
    @NotEmpty(message = "City should not be empty.")
    String city;

}
