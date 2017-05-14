/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nmp
 */
public class BundlesTest 
{
    public BundlesTest() 
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
    }

    /**
     * Test of addBundle method, of class Bundles.
     */
    @Test
    public void testAddBundle() 
    {
        System.out.println("addBundle");
        
        Bundle bundle = null;
        Bundles instance = new Bundles();
        instance.addBundle(bundle);
        
        assertEquals(instance.getSize(), 0);
    }

    /**
     * Test of getBundle method, of class Bundles.
     */
    @Test
    public void testGetBundle() 
    {
        System.out.println("getBundle");
        
        Bundle result = null;
        Bundle expResult = null;
        
        String productCode = "";
        int quantity = 0;
        
        Bundles instance = new Bundles();
        instance.addBundle(new Bundle("R12", 5, 6.99f));
        instance.addBundle(new Bundle("L09", 6, 16.95f));
        instance.addBundle(new Bundle("T58", 9, 16.99f));
        
        result = instance.getBundle(productCode, quantity);
        assertNull(result);
        
        productCode = "L09";
        quantity = 9;
        expResult = new Bundle("L09", 9, 24.95f);
        instance.addBundle(expResult);
        result = instance.getBundle(productCode, quantity);
        assertEquals(result, expResult);
        
        productCode = "L09";
        quantity = 20;
        result = instance.getBundle(productCode, quantity);
        assertNull(result);
        
        productCode = "XXX";
        quantity = 20;
        result = instance.getBundle(productCode, quantity);
        assertNull(result);
    }

    /**
     * Test of getBundles method, of class Bundles.
     */
    @Test
    public void testGetBundles_String() 
    {
        System.out.println("getBundles");
        
        Bundles instance = new Bundles();
        
        String productCode = "";
        ArrayList<Bundle> result = instance.getBundles(productCode);
        assertNull(result);
        
        Bundle a = new Bundle("T58", 9, 16.99f);
        Bundle b = new Bundle("T58", 25, 34.99f);
        
        instance.addBundle(new Bundle("R12", 5, 6.99f));
        instance.addBundle(new Bundle("L09", 6, 16.95f));
        instance.addBundle(a);
        instance.addBundle(b);
        
        ArrayList<Bundle> expResult = null;
        expResult = new ArrayList<Bundle>();
        expResult.add(a);
        expResult.add(b);
        
        productCode = "T58";
        result = instance.getBundles(productCode);
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getBundles method, of class Bundles.
     */
    @Test
    public void testGetBundles_intArr() 
    {
        System.out.println("getBundles_intArr");
        
        int[] quantities = null;
        Bundles instance = new Bundles();
        Bundles result = instance.getBundles(quantities);
        assertNull(result);
        
        quantities = new int[]{3, 6};
        Bundle a = new Bundle("R12", 3, 6.99f);
        Bundle b = new Bundle("R12", 6, 16.95f);
        instance.addBundle(a);
        instance.addBundle(b);
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        result = instance.getBundles(quantities);
        Bundles expResult = new Bundles();
        expResult.addBundle(a);
        expResult.addBundle(b);
        assertTrue(result.getSize() == expResult.getSize());
        
    }

    /**
     * Test of getSize method, of class Bundles.
     */
    @Test
    public void testGetSize() 
    {
        System.out.println("getSize");
        
        Bundles instance = new Bundles();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        instance.addBundle(new Bundle("R12", 13, 26.95f));
        result = instance.getSize();
        expResult = 2;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getQuantitiesAsList method, of class Bundles.
     */
    @Test
    public void testGetQuantitiesAsList() 
    {
        System.out.println("getQuantitiesAsList");
        
        String productCode = "";
        Bundles instance = new Bundles();
        
        ArrayList<Integer> result = instance.getQuantitiesAsList(productCode);
        assertNull(result);
        
        productCode = "R12";
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        expResult.add(9);
        expResult.add(13);
        expResult.add(15);
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        instance.addBundle(new Bundle("R12", 13, 26.95f));
        instance.addBundle(new Bundle("R12", 15, 29.95f));
        result = instance.getQuantitiesAsList(productCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBundleCost method, of class Bundles.
     */
    @Test
    public void testGetBundleCost() 
    {
        System.out.println("getBundleCost");
        
        Bundles instance = new Bundles();
        float expResult = 0.0F;
        float result = instance.getBundleCost();
        assertEquals(expResult, result, 0.0);
        
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        instance.addBundle(new Bundle("R12", 13, 26.95f));
        result = instance.getBundleCost();
        expResult = 16.95f + 16.95f + 26.95f;
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Bundles.
     */
    @Test
    public void testToString() 
    {
        System.out.println("toString");
        Bundles instance = new Bundles();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        instance.addBundle(new Bundle("R12", 9, 16.95f));
        result = instance.toString();
        expResult = "\n\t2 x 9 $16.95";
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setupBundles method, of class Bundles.
     */
    @Test
    public void testSetupBundles() 
    {
        System.out.println("setupBundles");
        
        Bundles result = Bundles.setupBundles();
        assertTrue(result.getSize() == 8);
        
    }
    
}
