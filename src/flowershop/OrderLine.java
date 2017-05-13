/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.*;

/**
 *
 * @author mai
 */
public class OrderLine 
{
    private String productCode;
    private int quantity;
    private Bundles bundles;
    private float cost;
    
    public OrderLine(String productCode, int quantity)
    {
        this.productCode = productCode;
        this.quantity = quantity;
    }
    
    public float getCost()
    {
        return cost;
    }
    
    public String getProductCode()
    {
        return productCode;
    }
    
    public void processOrderLine(Bundles bundles)
    {
        this.bundles = getLeastBundles(bundles);
        cost = getBundleCost();    
    }
    
    private Bundles getLeastBundles(Bundles bundles)
    {
        Bundles leastBundles = null;
        
        // Convert bundle objects to integers
        ArrayList<Integer> numbers = bundles.getQuantitiesAsList(productCode);
        
        int[] leastBundleOption = SubsetSum.sumUp(numbers, quantity);
        
        if (leastBundleOption != null && leastBundleOption.length > 0)
            leastBundles = bundles.getBundles(leastBundleOption);
        
        return leastBundles;
    }
    
    private float getBundleCost()
    {
        if(bundles != null)
            return bundles.getBundleCost();
        
        return 0f;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        str = String.format("%d %s $%2.2f", quantity, productCode, cost);
        if(bundles != null)
        {
            str += bundles;
        }
        else
        {
            str += " no bundle available";
        }
        
        return str;
    }
    
    public static OrderLine NewOrderLine(String line)
    {
        String[] str = line.split(" ");
        Integer qty = 0;
        String code = "";
        
        qty = tryParseInt(str[0]);
        if (qty == null || qty <=0)
            throw new IllegalArgumentException("#Quantity is not integer or negative");
        
        code = str[1];
            
        return new OrderLine(code, qty);                
    }
    
    /**
    * Try to convert a string to integer.

    * @param str A string
    * 
    * @return Integer The number that was converted from the string. Null for not numeric.
    */
    public static Integer tryParseInt(String str) 
    {
        try 
        {
           return Integer.parseInt(str);
        } 
        catch (NumberFormatException e) 
        {
           return null;
        }
    }
    
}
