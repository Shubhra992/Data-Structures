/*
QuickTester.java

Part 1-
Create an application to take an integer input from user.
Assign a random integer between 1 and the length of the array into each spot.
Perform Quick sort on the created array and print the results.

by Shubhra Bhardwaj, California Lutheran University

Updated 25 SEP 2019

*/

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickTester {
    public static void main(String[] args) {
        Integer n;  //Variable that defines the length of the Array.

        StdOut.println("Hello!\n This program has been created by Shubhra Bhardwaj" +
                "\n Under Guidance of Professor Sean Harrington" +
                "\n Course: IT 516- Data Structures and Algorithms");

        StdOut.println("\nEnter The length of the array:");

        n = StdIn.readInt();    //Inserting integer value in variable as desired by user

        Integer[] a = new Integer[n];   //Creating an Array of length 'n'

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(1, n + 1); //Adding random values between 1 to n in Array
        }
// Printing Output
        StdOut.println("The values provided are:");
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");   //Print the Array with random values
        }

        Quick.sort(a);  //Performing Quick sort on array 'a'

        StdOut.println("\n \nThe arranged values after using Quick sort are:");

        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");       //Generating output of the sorted array
        }
        StdOut.println("\n\nThank You! Have a Good Day!!");

    }
}
