package com.jimmyguarin.springapp.service;

import com.jimmyguarin.springapp.domain.Producto;
import java.util.List;

/**
 * @author Jimmy Alejandro Guarín Cortés
 */
public class SimpleProductManager implements IProductManager{

    private List<Producto> products;
    
    @Override
    public void increasePrice(int percentage) {
       
        if(products!=null){
            for(Producto product: products){               
                double newPrice=product.getPrice()*(100+percentage)/100;
                product.setPrice(newPrice);
            }
        }
    }

    @Override
    public List<Producto> getProducts() {
        
        return products;
    }

    @Override
    public void setProducts(List<Producto> productos) {
        this.products=productos;
    }

}
