package com.cef.testTask.dto;


public class OrdersDto {
    private String product;
    private Integer value;
    private String city;

    public OrdersDto(String product, Integer value, String city) {
        this.product = product;
        this.value = value;
        this.city = city;
    }
    public OrdersDto(){}

    @Override
    public String toString() {
        return '{' +
                "product='" + product + '\'' +
                ", value=" + value +
                ", city='" + city + '\'' +
                '}';
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
