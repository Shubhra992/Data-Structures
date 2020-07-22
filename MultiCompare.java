/*
MultiCompare.java

Create an application to compare sort methods across the same size of random number
samples and trials, then SORT those results to get a better understanding of which
sort methods perform best for these types of number sets.

by Shubhra Bhardwaj, California Lutheran University

Updated 22 SEP 2019

*/

import edu.princeton.cs.algs4.StdOut;

public class MultiCompare {
    public static void main(String[] args) {
        int n = 10000;                          // Number of random numbers generated for each test
        int trials = 100;                       // Number of trials for each test
        String[] sortTypes = new String[6];     // Array defined for the number of sort types available
        sortTypes[0] = "Insertion";
        sortTypes[1] = "Selection";
        sortTypes[2] = "Shell";
        sortTypes[3] = "Merge";
        sortTypes[4] = "Quick";
        sortTypes[5] = "Heap";
        Double[] sortTimes = new Double[6];     // Storing the sortTimes of the number of sort times mentioned

        // Print a header so the user knows it's working...
        StdOut.println("Running " + trials + " trials of " + n + " random numbers each...");
        StdOut.println("---------------------------------------------------");

        // Perform each of the sorts in the sortTypes array...
        for (int i = 0; i <= sortTypes.length - 1; i++) {
            sortTimes[i] = SortCompare.timeRandomInput(sortTypes[i], n, trials);
        }

        double tempTime;
        String tempType;

        // THIS IS THE MAIN PART OF MY ASSIGNMENT!
        // Sort the sortTimes and the corresponding sortTypes using Insertion sort
        //Sort done in ascending order

        for (int i = 1; i < sortTypes.length; ++i) {
            for (int j = i; j > 0 && (sortTimes[j] < sortTimes[j - 1]); j--) {
                tempTime = sortTimes[j - 1];        // Saving value of Time in a temporary variable
                tempType = sortTypes[j - 1];       // Saving value of Type in a temporary variable
                sortTimes[j - 1] = sortTimes[j];  //Sorting Time
                sortTypes[j - 1] = sortTypes[j]; // Sorting Types
                sortTimes[j] = tempTime;
                sortTypes[j] = tempType;

            }
        }
// Printing Output
        for (
                int i = 0;
                i <= sortTypes.length - 1; i++) {
            String pad = new String();
            for (int c = 12 - sortTypes[i].length(); c > 0; c--) {
                pad += " ";
            }
            StdOut.print(pad + sortTypes[i]);
            if (sortTimes[i] < 0.1) {
                StdOut.println(" < 1/10 second (avg)");
            } else if (sortTimes[i] < 10) {
                StdOut.printf(" =  %.3f seconds (avg)\n", sortTimes[i]);
            } else {
                StdOut.printf(" = %.3f seconds (avg)\n", sortTimes[i]);
            }
        }
    }
}
