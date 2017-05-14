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
public class OrderLineTest {

    private OrderLine instance;

    public OrderLineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new OrderLine("T58", 13);
    }

    /**
     * Test of getCost method, of class OrderLine.
     */
    @Test
    public void testGetCost() 
    {
        System.out.println("getCost");

        float result = instance.getCost();
        assertEquals(0, result, 0.0f);

    }

    /**
     * Test of getProductCode method, of class OrderLine.
     */
    @Test
    public void testGetProductCode() 
    {
        System.out.println("getProductCode");

        String result = instance.getProductCode();
        assertEquals("T58", result);
    }

    /**
     * Test of processOrderLine method, of class OrderLine.
     */
    @Test
    public void testProcessOrderLine() 
    {
        System.out.println("processOrderLine");

        Bundles bundles = Bundles.setupBundles();
        instance.processOrderLine(new Bundles(bundles.getBundles(instance.getProductCode())));
        float result = instance.getCost();
        assertEquals(2*9.95 + 5.95, result, 0.02);
        
        instance = new OrderLine("R12", 10);
        instance.processOrderLine(new Bundles(bundles.getBundles(instance.getProductCode())));
        result = instance.getCost();
        assertEquals(12.99, result, 0.02);
        
        instance = new OrderLine("L09", 15);
        instance.processOrderLine(new Bundles(bundles.getBundles(instance.getProductCode())));
        result = instance.getCost();
        assertEquals(24.95 + 16.95, result, 0.02);
    }

}
