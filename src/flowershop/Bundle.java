/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 * The Bundle class contains details of a bundle including product code,
 * quantity and cost.
 * 
 * @author Mai Phuong Nguyen
 */

public class Bundle 
{
    private String productCode;
    private int quantity;
    private float cost;
    
    /**
    * Constructor to instantiate Bundle object
    * 
    * @param productCode  product code, e.g. T58
    * @param quantity quantity in the bundle, e.g. 5 flowers per bundle
    * @param cost cost of the bundle, e.g. 15.99
    */
    public Bundle(String productCode, int quantity, float cost)
    {
        this.productCode = productCode;
        this.quantity = quantity;
        this.cost = cost;
    }
    
    /**
    * Get the product code of the bundle
    * 
    * @return String product code of the bundle, e.g. T58
    */
    public String getProductCode()
    {
        return productCode;
    }
    
    /**
    * Get the quantity/number of flowers in this bundle
    * 
    * @return int number of flowers in the bundle, e.g. 3
    */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
    * Get the cost of the bundle
    * 
    * @return float cost of the bundle, e.g. 15.99
    */
    public float getCost()
    {
        return cost;
    }
    
    @Override
    public String toString()
    {
        return String.format("%d $%2.2f", quantity, cost); 
    }
    
}
