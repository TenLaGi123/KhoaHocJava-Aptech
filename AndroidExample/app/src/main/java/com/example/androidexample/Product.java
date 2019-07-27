package com.example.androidexample;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private Double price;
    private Integer model;

    public Product(String name, Double price, Integer model) {
        this.name = name;
        this.price = price;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "name = " + name + ", price = " + price + ", model = " + model;
    }
}
