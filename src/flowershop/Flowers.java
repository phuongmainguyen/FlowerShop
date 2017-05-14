/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.*;

/**
 * This class contains a collection of flower.
 * 
 * @author nmp
 */
public class Flowers 
{
    private ArrayList<Flower> flowers;
    
    /**
    * Constructs flowers class
    */
    public Flowers()
    {
        flowers = new ArrayList<Flower>();
    }
    
    /**
    * Add flower to the collection.
    * 
    * @param flower A flower to be added
    */
    public void addFlower(Flower flower)
    {
        if(flower != null)
            flowers.add(flower);
    }
    
    /**
    * Retrieves flowers in the collection.
    * 
    * @return List of flowers
    */
    public ArrayList<Flower> getFlowers()
    {
        return flowers;
    }
    
    /**
    * Retrieves the flower with the specified code.
    * 
    * @param productCode The code of the flower
    * @return The flower if found. Otherwise null.
    */
    public Flower getFlowerBasedOnProductCode(String productCode)
    {
        if (flowers != null && flowers.size() > 0)
        {
            for(Flower f : flowers)
            {
                if(f.getProductCode().equals(productCode))
                    return f;
            }
        }
        
        return null;
    }
    
    /**
    * Retrieves the number of flowers in the collection.
    * 
    * @return Number of flowers
    */
    public int getSize()
    {
        if(flowers != null)
            return flowers.size();
        
        return 0;
    }
    
    /**
    * Setup all available flowers.
    * 
    * @return All the flowers that have been setup.
    */
    public static Flowers setupFlowers()
    {
        Flowers newFlowers = new Flowers();
        newFlowers.addFlower(new Flower("Rose", "R12"));
        newFlowers.addFlower(new Flower("Lily", "L09"));
        newFlowers.addFlower(new Flower("Tulip", "T58"));
        
        return newFlowers;
    }
    
}
