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
public class FlowerTest 
{
    private Flower instance;
    
    public FlowerTest() 
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
        instance = new Flower("Rose", "R12");
    }
    
    /**
     * Test of getName method, of class Flower.
     */
    @Test
    public void testGetName() 
    {
        System.out.println("getName");
        
        String result = instance.getName();
        assertEquals("Rose", result);
        
    }

    /**
     * Test of getProductCode method, of class Flower.
     */
    @Test
    public void testGetProductCode() 
    {
        System.out.println("getProductCode");
        
        String result = instance.getProductCode();
        assertEquals("R12", result);
        
    }
    
}
