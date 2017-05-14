/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.*;

/**
 * The OrderLine class represents a line of order in the CSV file.
 * E.g. 10 R12 is a line of order
 * 
 * @author mai
 */
public class OrderLine 
{
    private String productCode;
    private int quantity;
    private Bundles bundles;
    private float cost;
    
    /**
    * Constructs the order line.
    * 
    * @param productCode Product code of the flower
    * @param quantity The quantity
    */
    public OrderLine(String productCode, int quantity)
    {
        this.productCode = productCode;
        this.quantity = quantity;
    }
    
    /**
    * Retrieves cost of the order line.
    * 
    * @return Order line cost
    */
    public float getCost()
    {
        return cost;
    }
    
    /**
    * Retrieves product code of the order line.
    * 
    * @return Product code
    */
    public String getProductCode()
    {
        return productCode;
    }
    
    /**
    * Process the order line by calculating the minimal no. of bundles and
    * calculating the cost.
    * 
    * @param bundles A list of bundles
    */
    public void processOrderLine(Bundles bundles)
    {
        this.bundles = getLeastBundles(bundles);
        cost = getBundleCost();    
    }
    
    /**
    * Calculate the least no. of bundles.
    * 
    * @param bundles All bundles available
    * @return The object with least no. of bundles
    */
    private Bundles getLeastBundles(Bundles bundles)
    {
        Bundles leastBundles = null;

        if (bundles != null)
        {
            // Convert bundle objects to integers
            ArrayList<Integer> numbers = bundles.getQuantitiesAsList(productCode);

            int[] leastBundleOption = SubsetSum.sumUp(numbers, quantity);

            if (leastBundleOption != null && leastBundleOption.length > 0)
                leastBundles = bundles.getBundles(leastBundleOption);
        }
        
        return leastBundles;
    }
    
    /**
    * Retrieves the bundle cost.
    * 
    * @return Bundle cost
    */
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
    
    /**
    * Create a new order line.
    * 
    * @param quantity Quantity of the order line
    * @param productCode Code of the flower
    * @param flowers list of flowers available. Used for checking the code is valid.
    * @return OrderLine object that is created. Null if not.
    */
    public static OrderLine NewOrderLine(String quantity, String productCode, Flowers flowers)
    {
        Integer qty = 0;
        
        qty = tryParseInt(quantity);
        if (qty == null || qty <=0)
            throw new IllegalArgumentException(String.format("Quantity is not numeric or negative: %s", quantity));
        
        if(flowers != null && flowers.getFlowerBasedOnProductCode(productCode) == null)
            throw new IllegalArgumentException(String.format("No such product code: %s", productCode));
        
        return new OrderLine(productCode, qty);                
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
