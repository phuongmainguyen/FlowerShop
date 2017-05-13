/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author nmp
 */
public class SubsetSum 
{
    public static int[] sumUp(ArrayList<Integer> numbers, int target) 
    {
        ArrayList<Integer> bestSolution = null;
        int[] intBestSolution = null;
        
        // Modify numbers to include repetitive set of numbers 
        numbers = repeatNumbers(numbers, target);
        
        ArrayList<ArrayList<Integer>> solutions = null;
        solutions = sumUpRecursive(numbers, target, new ArrayList<Integer>(), solutions);
        
        // Check that the solutions are available before finding the solution with the least elements
        if (solutions != null && solutions.size() > 0)
        {
            // Get least number of elements
            bestSolution = getLeastElements(solutions);

            intBestSolution = convertToInt(bestSolution);
        }
        
        return intBestSolution;
    }
    
    private static ArrayList<Integer> getLeastElements(ArrayList<ArrayList<Integer>> solutions)
    {
        ArrayList<Integer> bestSolution = null;
        
        if(solutions != null && solutions.size() > 0)
        {
            bestSolution = solutions.get(0);
            for(ArrayList<Integer> s : solutions)
            {
                if(s.size() < bestSolution.size())
                    bestSolution = s;
            }
        }
        
        return bestSolution;
    }
    
    private static ArrayList<Integer> repeatNumbers(ArrayList<Integer> numbers, int target)
    {
        ArrayList<Integer> newNumbers = null;
        
        if(numbers != null && numbers.size() > 0)
        {
            newNumbers = new ArrayList<Integer>();
            
            for(int i : numbers)
            {
                // TODO: check i not 0
                for(int j=0; j<target/i; ++j)
                {
                    newNumbers.add(i);
                }
            }
        }
        
        return newNumbers;
    }
    
    private static ArrayList<ArrayList<Integer>> sumUpRecursive(ArrayList<Integer> numbers, int target, 
            ArrayList<Integer> partial, ArrayList<ArrayList<Integer>> solutions) 
    {
       int s = 0;
       
       for (int x : partial) 
           s += x;
       
       if (s == target)
       {
           if (solutions == null)
               solutions = new ArrayList<ArrayList<Integer>>();
           
           solutions.add(partial);
           System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
       }
           
       if (s >= target)
            return solutions;
       
       for(int i=0;i<numbers.size();i++) 
       {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) 
                remaining.add(numbers.get(j));
            
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            
            solutions = sumUpRecursive(remaining,target,partial_rec, solutions);
       }
       
       return solutions;
    }
    
    public static int[] convertToInt(ArrayList<Integer> integers)
    {
        int[] result = null;
        
        if(integers != null && integers.size() > 0)
        {
            result = new int[integers.size()];
            for (int i=0; i < integers.size(); i++)
            {
                result[i] = integers.get(i).intValue();
            }
        }
        
        return result;
    }
}
