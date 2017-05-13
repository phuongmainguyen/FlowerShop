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
public class Order 
{
    private ArrayList<OrderLine> orderLines;
    
    public Order()
    {
        orderLines = new ArrayList<OrderLine>();
    }
    
    public void addOrderLine(String line)
    {
        OrderLine o = OrderLine.NewOrderLine(line);
        if(o != null)
        {
            orderLines.add(o);
        }
    }
    
    public void processOrder(Bundles bundles)
    {
        if(orderLines != null && orderLines.size() > 0)
        {
            for(OrderLine line : orderLines)
            {
                ArrayList<Bundle> b = bundles.getBundles(line.getProductCode());
                line.processOrderLine(new Bundles(b));
            }
        }
    }
    
    @Override
    public String toString()
    {
        String str = "";
        
        if(orderLines != null && orderLines.size() > 0)
        {
            for(OrderLine o : orderLines)
            {
                str += o + "\n";
            }
        }
        
        return str;
    }
    
    
}
