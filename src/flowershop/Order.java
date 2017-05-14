/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.*;

/**
 * The Order class contains a list of order lines.
 * An order can have many order lines:
 * e.g. 
 * 10 R12
 * 15 T58
 * 19 L09
 * 
 * @author mai
 */
public class Order 
{
    private ArrayList<OrderLine> orderLines;
    
    /**
    * Constructs an order
    */
    public Order()
    {
        orderLines = new ArrayList<OrderLine>();
    }
    
    /**
    * Add an order line to the Order object.
    * 
    * @param quantity Quantity of the order line
    * @param productCode Product code of the flower
    * @param flowers The list of flowers available
    */
    public void addOrderLine(String quantity, String productCode, Flowers flowers)
    {
        OrderLine o = OrderLine.NewOrderLine(quantity, productCode, flowers);
        if(o != null)
        {
            orderLines.add(o);
        }
    }
    
    /**
    * Process the order
    * 
    * @param bundles List of all bundles available
    */
    public void processOrder(Bundles bundles)
    {
        if(orderLines != null && orderLines.size() > 0)
        {
            for(OrderLine line : orderLines)
            {
                ArrayList<Bundle> b = bundles.getBundles(line.getProductCode());
                if (b != null && b.size() > 0)
                    line.processOrderLine(new Bundles(b));
            }
        }
    }
    
    /**
    * Retrieves number of order lines in the order.
    * 
    * @return Number of lines
    */
    public int getSize()
    {
        if(orderLines != null)
            return orderLines.size();
        
        return 0;
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
