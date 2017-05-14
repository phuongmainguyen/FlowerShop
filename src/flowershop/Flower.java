/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

/**
 * The Flower class with all details like name and product code.
 * 
 * @author mai
 */
public class Flower
{
    private String name;
    private String productCode;
    
    /**
    * Constructor to instantiate the flower
    * 
    * @param name Flower name like "Rose"
    * @param productCode The product code of the bundle to be retrieved
    */
    public Flower(String name, String productCode)
    {
        this.name = name;
        this.productCode = productCode;
    }
    
    /**
    * Retrieves flower name.
    * 
    * @return Flower name
    */
    public String getName()
    {
        return name;    
    }
    
    /**
    * Retrieves flower code.
    * 
    * @return Flower code
    */
    public String getProductCode()
    {
        return productCode;   
    }
  
}


