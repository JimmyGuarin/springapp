/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jimmyguarin.springapp.service;

import com.jimmyguarin.springapp.domain.Producto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jimmy Alejandro Guarín Cortés
 */
public interface IProductManager extends Serializable{
    
    public void increasePrice(int percentage);
    
    public List<Producto> getProducts();
    
    public void setProducts(List<Producto> productos);
}
