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
public class Bundles 
{
    private ArrayList<Bundle> bundles;
    
    public Bundles()
    {
        bundles = new ArrayList<Bundle>();
    }
    
    public Bundles(ArrayList<Bundle> bundles)
    {
        this.bundles = bundles;
    }
    
    public void addBundle(Bundle bundle)
    {
        bundles.add(bundle);
    }
    
    public Bundle getBundle(String productCode, int quantity)
    {// ASSUMPTIONS: ONly one bundle matches this.
        if (bundles != null && bundles.size() > 0)
        {
            for(Bundle b : bundles)
            {
                if(b.getProductCode().equals(productCode) && b.getQuantity() == quantity)
                    return b;
            }
        }
        
        return null;
    }
    
    public ArrayList<Bundle> getBundles(String productCode)
    {
        ArrayList<Bundle> innerBundles = null;
        
        if (bundles != null && bundles.size() > 0)
        {
            innerBundles = new ArrayList<Bundle>();
            for(Bundle b : bundles)
            {
                if(b.getProductCode().equals(productCode))
                    innerBundles.add(b);
            }
        }
        
        return innerBundles;
    }
    
    public Bundles getBundles(int[] quantities)
    {
        ArrayList<Bundle> innerBundles = null;
        
        if (bundles != null && bundles.size() > 0)
        {
            innerBundles = new ArrayList<Bundle>();
            for(Bundle b : bundles)
            {
                for(int i : quantities)
                {
                    if(b.getQuantity() == i)
                        innerBundles.add(b);
                }
            }
        }
        
        return new Bundles(innerBundles);
    }
    
    public int getSize()
    {
        if (bundles != null)
            return bundles.size();
        
        return 0;
    }
    
    public ArrayList<Integer> getQuantitiesAsList(String productCode)
    {
        ArrayList<Integer> list = null;
        ArrayList<Bundle> innerBundles = getBundles(productCode);
        
        if(innerBundles != null && innerBundles.size() > 0)
        {
            list = new ArrayList<Integer>();
            
            for(Bundle b : innerBundles)
                list.add(b.getQuantity());
        }
        
        return list;
    }
    
    public float getBundleCost()
    {
        float cost = 0.0f;
        
        if (bundles != null && bundles.size() > 0)
        {
            for(Bundle b : bundles)
            {
                cost += b.getCost();
            }
        }
        
        return cost;
    }
    
    private Map groupBundlesByType()
    {
        Map<String, Integer> map = new TreeMap<String, Integer>(Collections.reverseOrder());
        bundles.forEach((b) -> 
        {
            if(map.containsKey(b.toString()))
            {
                int qty = map.get(b.toString()) + 1;
                map.put(b.toString(), qty);
            }
            else
            {
                map.put(b.toString(), 1);
            }
        });
        
        return map;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        Map map = null;
        
        map = groupBundlesByType();
        
        if(map != null)
        {
            // Getting a Set of key-value pairs and obtaining an iterator for the entry set
            Set entrySet = map.entrySet();
            Iterator it = entrySet.iterator();

            // Iterate through map entries and get the string representation 
            while(it.hasNext())
            {
               Map.Entry me = (Map.Entry)it.next();
               str += String.format("\n\t%d x %s", me.getValue(), me.getKey());
            }
        }
        
        return str;
    }
    
    public static Bundles setupBundles()
    {
        Bundles newBundles = new Bundles();
        
        // Add rose's bundles
        newBundles.addBundle(new Bundle("R12", 10, 12.99f));
        newBundles.addBundle(new Bundle("R12", 5, 6.99f));
        
        // Add lily's bundles
        newBundles.addBundle(new Bundle("L09", 9, 24.95f));
        newBundles.addBundle(new Bundle("L09", 6, 16.95f));
        newBundles.addBundle(new Bundle("L09", 3, 9.95f));
        
        // Add tulip's bundles
        newBundles.addBundle(new Bundle("T58", 9, 16.99f));
        newBundles.addBundle(new Bundle("T58", 5, 9.95f));
        newBundles.addBundle(new Bundle("T58", 3, 5.95f));
        
        return newBundles;
    }
    
}
