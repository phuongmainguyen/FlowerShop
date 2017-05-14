/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.ArrayList;

/**
 * This class used the Subset Sum technique to find all combinations of numbers
 * that can sum up to the target number.
 * 
 * @author nmp
 */
public class SubsetSum 
{
    /**
    * Find all combinations of numbers that can sum up the target number.
    * 
    * @param numbers A list of numbers used to sum up
    * @param target The target sum wanted.
    * 
    * @return An array of integers that can sum up to the target
    */
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

            // Convert from ArrayList of Integer to array of int[] for easier reference
            intBestSolution = convertToInt(bestSolution);
        }
        
        return intBestSolution;
    }
    
    /**
    * Out of all the available combinations, retrieves the shortest one, i.e. the
    * one contains the least numbers.
    * 
    * @param solutions A 2D list of integers contain all combinations
    * 
    * @return The shortest combination
    */
    private static ArrayList<Integer> getLeastElements(ArrayList<ArrayList<Integer>> solutions)
    {
        ArrayList<Integer> bestSolution = null;
        
        if(solutions != null && solutions.size() > 0)
        {
            // Compare to see which is the shortest size
            bestSolution = solutions.get(0);
            for(ArrayList<Integer> s : solutions)
            {
                if(s.size() < bestSolution.size())
                    bestSolution = s;
            }
        }
        
        return bestSolution;
    }
    
    /**
    * Repeats all numbers in the list so that they can be repeated several times 
    * when summing up.
    * E.g. If we have 3, 5, 9 as the list of integers. We want to repeat these
    * numbers several times to sum up to 13. So we will have 3,3,3,3,5,5,9.
    * 
    * @param numbers An array list of integers
    * @param target The target sum we want
    * 
    * @return An array list of integers that are repeated.
    */
    private static ArrayList<Integer> repeatNumbers(ArrayList<Integer> numbers, int target)
    {
        ArrayList<Integer> newNumbers = null;
        
        if(numbers != null && numbers.size() > 0)
        {
            newNumbers = new ArrayList<Integer>();
            
            for(int i : numbers)
            {
                // Only repeat these numbers when they are not 0
                if( i != 0)
                {
                    for(int j=0; j<target/i; ++j)
                    {
                        newNumbers.add(i);
                    }
                }
            }
        }
        
        return newNumbers;
    }
    
    /**
    * Uses SubSet Sum technique to find all combinations of numbers that sum up to 
    * the target number.
    * 
    * @param numbers List of numbers
    * @param target The target sum
    * @param The numbers that are not used yet
    * @param solutions The current combinations
    * 
    * @return A list of numbers representing all combinations
    */
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
           
           solutions.add(partial);  // Add a combination to the list of combinations
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
            
            solutions = sumUpRecursive(remaining, target, partial_rec, solutions);
       }
       
       return solutions;
    }
    
    /**
    * Converts the ArrayList of integers to primitive array of ints.
    * 
    * @param integers Array list of integers
    * 
    * @return Primitive array of ints
    */
    public static int[] convertToInt(ArrayList<Integer> integers)
    {
        int[] result = null;
        
        if(integers != null && integers.size() > 0)
        {
            result = new int[integers.size()];
            for (int i=0; i < integers.size(); i++)
            {
                result[i] = integers.get(i);
            }
        }
        
        return result;
    }
}
