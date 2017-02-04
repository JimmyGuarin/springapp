package com.jimmyguarin.springapp.domain;

import java.io.Serializable;

public class Producto implements  Serializable{
    
    private static final Long serialVersionUID= 1L;
    
    private String description;
    private Double price;

    public Producto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double precio) {
        this.price = precio;
    }


    public String toString() {
        return "Producto{" + "description=" + description + ", price=" + price + '}';
    }
    
    
    
}
