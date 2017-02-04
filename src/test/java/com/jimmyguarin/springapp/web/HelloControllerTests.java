/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jimmyguarin.springapp.web;


import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jimmy
 */
public class HelloControllerTests {
    
    @Test
    public void TesthandleRequestView() throws Exception{
        
        HelloController controller = new HelloController();
        ModelAndView modelandView= controller.handleRequest(null,null);
        assertEquals("hello",modelandView.getViewName());
        assertNotNull(modelandView.getModel());
        String nowValue=(String) modelandView.getModel().get("now");
        assertNotNull(nowValue);
    }
}
