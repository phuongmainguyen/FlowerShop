/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nmp
 */
public class OrderTest 
{
    Flowers flowers = null;
    
    public OrderTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }

    @Before
    public void setUp()
    {
        flowers = Flowers.setupFlowers();
    }
    
    /**
     * Test of addOrderLine method, of class Order.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddOrderLine() 
    {
        System.out.println("addOrderLine");
        
        String quantity = "";
        String productCode = "";
        
        Order instance = new Order();
        instance.addOrderLine(quantity, productCode, flowers);
        assertEquals(instance.getSize(), 0);
        
        quantity = "15";
        productCode = "xyz";
        instance.addOrderLine(quantity, productCode, flowers);
        assertEquals(instance.getSize(), 0);
        
        quantity = "15";
        productCode = "T58";
        instance.addOrderLine(quantity, productCode, flowers);
        assertEquals(instance.getSize(), 1);
    }

    /**
     * Test of getSize method, of class Order.
     */
    @Test
    public void testGetSize() 
    {
        System.out.println("getSize");
        
        Order instance = new Order();
        int result = instance.getSize();
        assertEquals(0, result);
        
        instance.addOrderLine("15", "T58", flowers);
        result = instance.getSize();
        assertEquals(1, result);
    }
    
}
