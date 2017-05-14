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
public class BundleTest 
{
    private Bundle bundle = null;
    
    public BundleTest() 
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
        bundle = new Bundle("T58", 9, 16.99f);
    }

    /**
     * Test of getProductCode method, of class Bundle.
     */
    @Test
    public void testGetProductCode() 
    {
        System.out.println("getProductCode");
        
        String expResult = "T58";
        String result = bundle.getProductCode();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of getQuantity method, of class Bundle.
     */
    @Test
    public void testGetQuantity() 
    {
        System.out.println("getQuantity");
        
        int expResult = 9;
        int result = bundle.getQuantity();
        
        assertEquals(expResult, result);    
    }

    /**
     * Test of getCost method, of class Bundle.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        
        float expResult = 16.99F;
        float result = bundle.getCost();
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Bundle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "9 $16.99";
        String result = bundle.toString();
        
        assertEquals(expResult, result);
    }
    
}
