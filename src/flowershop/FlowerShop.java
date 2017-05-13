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
public class FlowerShop 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Bundles bundles = Bundles.setupBundles();
        
        Order order = new Order();
        order.addOrderLine("10 R12");
        order.addOrderLine("15 L09");
        order.addOrderLine("13 T58");
        
        order.processOrder(bundles);
                
        System.out.println(order);
    }
    
}
