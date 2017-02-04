package com.jimmyguarin.springapp.service;

import com.jimmyguarin.springapp.domain.Producto;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jimmy Alejandro Guarín Cortés
 */
public class SimpleProductManagerTests {

    private SimpleProductManager productManager;
    
    private List<Producto> products;
    
    private static int PRODUCT_COUNT = 2;
    
    private static Double CHAIR_PRICE = new Double(20.50);
    private static String CHAIR_DESCRIPTION = "Chair";
    
    private static String TABLE_DESCRIPTION = "Table";
    private static Double TABLE_PRICE = new Double(150.10); 
    
    private static int POSITIVE_PRICE_INCREASE = 10; 
    
    @Before
    public void setUp()throws Exception{
        productManager= new SimpleProductManager();
         products = new ArrayList<Producto>();
        
        // stub up a list of products
        Producto product = new Producto();
        product.setDescription("Chair");
        product.setPrice(CHAIR_PRICE);
        products.add(product);
        
        product = new Producto();
        product.setDescription("Table");
        product.setPrice(TABLE_PRICE);
        products.add(product);
        
        productManager.setProducts(products);

    }
    
    @Test
    public void testGetProductsWithNoProducts() {
        productManager = new SimpleProductManager();
        assertNull(productManager.getProducts());
    }
    
    
    @Test
    public void testGetProductsWithProducts(){        
        List<Producto> products = productManager.getProducts();
        assertNotNull(products);        
        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
    
        Producto product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals(CHAIR_PRICE, product.getPrice()); 
        
        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals(TABLE_PRICE, product.getPrice());
    }
    
     @Test
    public void testIncreasePriceWithNullListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Products list is null.");
        }
    }

    @Test
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
            productManager = new SimpleProductManager();
            productManager.setProducts(new ArrayList<Producto>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Products list is empty.");
        }           
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;
        
        List<Producto> products = productManager.getProducts();      
        Producto product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);
        
        product = products.get(1);      
        assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);       
    }
}
