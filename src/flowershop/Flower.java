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
public class Flower
{
    private String name;
    private String productCode;
    
    public Flower(String name, String productCode)
    {
        this.name = name;
        this.productCode = productCode;
    }
    
    public String getName()
    {
        return name;    
    }
    
    public String getProductCode()
    {
        return productCode;   
    }
  
}


