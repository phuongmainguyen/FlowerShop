Flower Shop Order Generator

What is it?
-----------

The Flower Shop Order Calculator takes order details from a CSV file and calculates the minimal number of bundles and display to the screen along with the cost. The FlowerShop class contains the main method in which the program starts.

The program starts by asking user to enter the filename of the order. A sample filename is saved in the DIST folder whose name is "order.csv". Once the user enters the filename, it will read through all order lines in the file and calculates the least bundles and have these displayed to the screen with the cost. The user can quit the program by entering 'q' or 'quit'.

The program uses SUBSET SUM technique to find all available combinations of numbers that can sum up to the target number. However, because the numbers could be repeated several times, I have to write a method to repeat them in a given array list of numbers. For more info, go to the javadoc and read about SUBSET SUM class.

The latest version
------------------
Details of the latest version can be found on Github https://github.com/phuongmainguyen/FlowerShop

Documentation
-------------
The documentation available as of the date of this release is included in HTML format in the disc/javadoc/ directory.

How to run
----------
To run the project from the command line, go to the DIST folder and type the following:

java -jar "FlowerShop.jar"

A sample order file in CSV format called "order.csv" is saved in the DIST folder for your testing. Feel free to change it. Run the program and enter "order.csv" and the program will calculate the least no. of bundles and display to the screen.

Contacts
--------
If you want to be informed about new code releases, bug fixes, security fixes, general news and information about the Flower Shop program subscribe to my GitHub account or follow me on Twitter @mai_isthebest.

By the way, my name is Mai Phuong Nguyen and I love coding!!! Thank you for downloading this program.
