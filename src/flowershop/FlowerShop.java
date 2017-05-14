/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;

import java.util.Scanner;
import java.io.*;

/**
 * The Flower Shop Order Calculator takes order details from a CSV file 
 * and calculates the minimal number of bundles and display to the screen
 * along with the cost.
 * 
 * The FlowerShop class contains the main method in which the program starts.
 * 
 * The program starts by asking user to enter the filename of the order. A sample 
 * filename is saved in the SRC folder whose name is "order.csv". Once the user enters 
 * the filename, it will read through all order lines in the file and calculates
 * the least bundles and have these displayed to the screen with the cost.
 * 
 * The user can quit the program by entering 'q' or 'quit'.
 * 
 * @author Mai Phuong Nguyen
 */
public class FlowerShop 
{
    /**
     * @param args the command line arguments. Not used for this program.
     */
    public static void main(String[] args) 
    {   
        System.out.println("Welcome to Flower Shop Order Calculator!");

        while (true)
        {
            // Prompt for input file
            System.out.println("\nEnter filename of order in CSV format (or 'q' to quit):");
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();

            // If user enters q or quit then exit the program
            if (filename.equals("q") || filename.equals("quit"))
                break;

            ProcessRequest(filename);
        }

        System.out.println("See you soon!");
    }
    
    /**
    * Process the order file by calculating all order lines in the file. 
    * The filename argument must specify an absolute path.  
    * 
    * @param  filename  an absolute path including the file name
    */
    private static void ProcessRequest(String filename) 
    {
        // Load order lines from csv using format: quantity, product code
        BufferedReader br = null;
        String line = "";
        String separator = ","; // separator of the CSV is assumed to be comma
        int counter = 0;        // keeps track of the line number in the csv
        
        // Setup all available bundles and flowers
        Bundles bundles = Bundles.setupBundles();
        Flowers flowers = Flowers.setupFlowers();

        try 
        {
            File tmpFile = new File(filename);
            
            // Check to make sure input file exists, of the right CSV format
            if (!tmpFile.exists())
                throw new FileNotFoundException("File not found!");
            else if (!getFileExtension(tmpFile).equals("csv"))
                throw new InvalidFileException("File is not of CSV format!");
            
            br = new BufferedReader(new FileReader(tmpFile));
            Order order = new Order();
            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(separator);
                
                // Check the number of elements in the file is correct, i.e. 2 elements in each line
                if (data.length != 2)
                    throw new InvalidFileException("Invalid structure (quantity, product code)");
                
                // Add the order line to the order
                order.addOrderLine(data[0], data[1], flowers);
            }
            
            // The order gets processed only when there is at least one available and valid order line
            if(order.getSize() > 0)
            {
                order.processOrder(bundles);
                System.out.println(order);
            }
            else
                System.out.println("Order has no order line. Check the file and try again!");
        }
        catch (IllegalArgumentException | IOException | InvalidFileException e)
        {
            System.out.println("Error processing file: " + e.getMessage());
        }
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }       
    }

    /**
     * Get the extension of the file.
     * 
     * @param  file A File object  
     * @return  String  The file extension, e.g. csv
     */
    private static String getFileExtension(File file) 
    {
        String name = file.getName();
        try 
        {
            return name.substring(name.lastIndexOf(".") + 1);
        } 
        catch (Exception e) 
        {
            return "";
        }
    }   
}

class InvalidFileException extends Exception 
{
    public InvalidFileException(String message) { super(message); }
}
