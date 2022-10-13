package com.cef.testTask.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "orders_table")
public class OrdersModel extends Model{

    String product;
    Integer value;
    String city;

}
