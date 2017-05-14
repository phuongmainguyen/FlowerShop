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
public class SubsetSumTest 
{
    
    public SubsetSumTest() 
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
     * Test of sumUp method, of class SubsetSum.
     */
    @Test
    public void testSumUp() 
    {
        System.out.println("sumUp");
        
        ArrayList<Integer> numbers = null;
        int target = 0;
        int[] expResult = null;
        int[] result = SubsetSum.sumUp(numbers, target);
        assertArrayEquals(expResult, result);
        
        numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(9);
        target = 15;
        expResult = new int[]{6,9};
        result = SubsetSum.sumUp(numbers, target);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of convertToInt method, of class SubsetSum.
     */
    @Test
    public void testConvertToInt() 
    {
        System.out.println("convertToInt");
        
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(3);
        integers.add(6);
        integers.add(9);
        int[] expResult = new int[]{3,6,9};
        int[] result = SubsetSum.convertToInt(integers);
        assertArrayEquals(expResult, result);
        
    }
    
}
