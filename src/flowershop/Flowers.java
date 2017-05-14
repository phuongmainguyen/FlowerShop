/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.*;

/**
 *
 * @author nmp
 */
public class Flowers 
{
    private ArrayList<Flower> flowers;
    
    public Flowers()
    {
        flowers = new ArrayList<Flower>();
    }
    
    public void addFlower(Flower flower)
    {
        this.flowers.add(flower);
    }
    
    public ArrayList<Flower> getFlowers()
    {
        return flowers;
    }
    
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
    
    public static Flowers setupFlowers()
    {
        Flowers newFlowers = new Flowers();
        newFlowers.addFlower(new Flower("Rose", "R12"));
        newFlowers.addFlower(new Flower("Lily", "L09"));
        newFlowers.addFlower(new Flower("Tulip", "T58"));
        
        return newFlowers;
    }
    
}
