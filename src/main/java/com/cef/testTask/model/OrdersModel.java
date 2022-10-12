package com.cef.testTask.model;

import javax.persistence.*;

@Entity
@Table(name = "orders_table")
public class OrdersModel extends Model{

    String product;
    Integer value;
    String city;

    public OrdersModel(){}

    public OrdersModel(String product, Integer value, String city) {
        this.product = product;
        this.value = value;
        this.city = city;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
