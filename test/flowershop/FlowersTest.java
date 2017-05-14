/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nmp
 */
public class FlowersTest 
{
    
    public FlowersTest() 
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

    /**
     * Test of addFlower method, of class Flowers.
     */
    @Test
    public void testAddFlower() 
    {
        System.out.println("addFlower");
        
        Flower flower = null;
        Flowers instance = new Flowers();
        instance.addFlower(flower);
        assertEquals(instance.getSize(), 0);
        
        flower = new Flower("Rose", "R12");
        instance.addFlower(flower);
        assertEquals(instance.getSize(), 1);
    }

    /**
     * Test of getFlowers method, of class Flowers.
     */
    @Test
    public void testGetFlowers() 
    {
        System.out.println("getFlowers");
        
        Flowers instance = new Flowers();
        
        ArrayList<Flower> result = instance.getFlowers();
        assertEquals(result.size(), 0);
        
        instance.addFlower(new Flower("Rose", "R12"));
        instance.addFlower(new Flower("Lily", "L09"));
        instance.addFlower(new Flower("Tulip", "T58"));
        
        assertEquals(result.size(), 3);
        
    }

    /**
     * Test of getFlowerBasedOnProductCode method, of class Flowers.
     */
    @Test
    public void testGetFlowerBasedOnProductCode() 
    {
        System.out.println("getFlowerBasedOnProductCode");
        
        String productCode = "";
        Flowers instance = new Flowers();
        Flower rose = new Flower("Rose", "R12");
        Flower lily = new Flower("Lily", "L09");
        Flower tulip = new Flower("Tulip", "T58");
        instance.addFlower(rose);
        instance.addFlower(lily);
        instance.addFlower(tulip);
        
        Flower result = instance.getFlowerBasedOnProductCode(productCode);
        assertNull(result);
        
        productCode = "R12";
        result = instance.getFlowerBasedOnProductCode(productCode);
        assertSame(result, rose);
        
        productCode = "Rxxxx12";
        result = instance.getFlowerBasedOnProductCode(productCode);
        assertNull(result);
        
    }

    /**
     * Test of setupFlowers method, of class Flowers.
     */
    @Test
    public void testSetupFlowers() 
    {
        System.out.println("setupFlowers");
        
        Flowers result = Flowers.setupFlowers();
        assertEquals(3, result.getSize());
    }
    
}
