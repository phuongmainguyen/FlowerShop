/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.*;

/**
 * The Bundles class contains a list of bundles.
 * 
 * @author nmp
 */
public class Bundles 
{
    private ArrayList<Bundle> bundles;
    
    /**
    * Constructor to instantiate the Bundles object.
    */
    public Bundles()
    {
        bundles = new ArrayList<Bundle>();
    }
    
    /**
    * Constructor to instantiate the Bundles object.
    * 
    * @param bundles An ArrayList of Bundle objects
    */
    public Bundles(ArrayList<Bundle> bundles)
    {
        if (bundles != null)
            this.bundles = bundles;
    }
    
    /**
    * This method adds a bundle to the list.
    * 
    * @param bundle A bundle to be added
    */
    public void addBundle(Bundle bundle)
    {
        if(bundle != null)
            bundles.add(bundle);
    }
    
    /**
    * Retrieves the bundle that matches the criteria of product code and quantity.
    * 
    * @param productCode The product code of the bundle to be retrieved
    * @param quantity The quantity of the bundle
    * @return Bundle An object representing the bundle. Null if not found.
    */
    public Bundle getBundle(String productCode, int quantity)
    {
        // ASSUMPTION: Bundles are unique in code and quantity.
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
    
    /**
    * Retrieves the list of bundles that matches the criteria of product code.
    * 
    * @param productCode The product code of the bundle to be retrieved
    * @return A list of Bundle. Null if not found.
    */
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
    
    /**
    * Retrieves the list of bundles that matches the criteria of quantities
    * saved in an array of ints.
    * 
    * @param quantities An array of integers representing quantities of the bundles, e.g. 3, 4, 5
    * @return Bundles An object representing the bundles. Null if not found.
    */
    public Bundles getBundles(int[] quantities)
    {
        ArrayList<Bundle> innerBundles = null;
        
        if (bundles != null && bundles.size() > 0)
        {
            for(Bundle b : bundles)
            {
                for(int i : quantities)
                {
                    if(b.getQuantity() == i)
                    {
                        if (innerBundles == null)
                            innerBundles = new ArrayList<Bundle>();
                    
                        innerBundles.add(b);
                    }
                }
            }
        }
        
        if(innerBundles != null && innerBundles.size() > 0)
            return new Bundles(innerBundles);
        
        return null;
    }
    
    /**
    * Retrieves the size of the current Bundles object.
    * 
    * @return The number of bundles
    */
    public int getSize()
    {
        if (bundles != null)
            return bundles.size();
        
        return 0;
    }
    
    /**
    * Retrieves all the quantities as an array list of integers based on the product
    * code.
    * 
    * @param productCode The product code of the bundle to be retrieved
    * @return An array list of integers
    */
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
    
    /**
    * Retrieves the bundle cost.
    * 
    * @return The bundle cost
    */
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
    
    /**
    * Group all the bundles in the current object into type, e.g. quantity and price
    * 
    * @return A map of the grouped bundles.
    */
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
    
    /**
    * Setup all the default bundles available for sale.
    * 
    * @return Bundle An object representing the bundle. Null if not found.
    */
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
