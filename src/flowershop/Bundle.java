/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 *
 * @author mai
 */

public class Bundle 
{
    private String productCode;
    private int quantity;
    private float cost;
    
    public Bundle(String productCode, int quantity, float cost)
    {
        this.productCode = productCode;
        this.quantity = quantity;
        this.cost = cost;
    }
    
    public String getProductCode()
    {
        return productCode;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
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
