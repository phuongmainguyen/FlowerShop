/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nmp
 */
public class FlowerTest 
{
    
    public FlowerTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        Flower flower =
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }

    /**
     * Test of getName method, of class Flower.
     */
    @Test
    public void testGetName() 
    {
        System.out.println("getName");
        Flower instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductCode method, of class Flower.
     */
    @Test
    public void testGetProductCode() {
        System.out.println("getProductCode");
        Flower instance = null;
        String expResult = "";
        String result = instance.getProductCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
