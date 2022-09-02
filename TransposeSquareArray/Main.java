/*
Author: Tiffany Nguyen
Acknowledgements: Tiffany wrote this code by herself using instructions from Mr. Kuszmaul

Instructions:
Write a class called Like2dArray and a class called TestL2A
The Like2DArray class has a field that is an array of type int[][] and a size of 10x10.
The Like2DArray class has a constructor that takes an argument of a *one* dimensional array of 100 ints.
The Like2DArray  class has a method called transpose that returns a Like2dArray that is the transpose of the implicit argument.


The TestL2A class tests the Like2dArray class. It has *at a minimum* the following:


   1 A static method called hardTestConstructor that takes no arguments and has a locally defined  10x10 array we will call twoD and a locally defined one dimensional array of size 100 called oneD hard coded into it such that:
oneD[i] == twoD[i/10][i%10] for all i from 0 thru 99. The method passes oneD into the constructor for Like2DArray and compares the returned object's field that is an int[][] to twoD. The two should have the same contents. 


   2 A static method called hardTestTranspose that similarly to hardTestConstructor has a locally defined 10x10 array called original and a locally defined 10x10 array called originalT defined such that original[i][j] == originalT[j][i] for all i and j from 0 thru 9, and also no two elements of original have the same value. 


  Each of the two methods discussed above should perform a test in the usual way (increment a pass and/or fail counter) showing that your Like2dArray class can construct and transpose as described. 
  The usual acknowledgements and documentation standards must be met.
*/

class Main {
  public static void main(String[] args) {
    TestL2A.hardTestConstructor();
    TestL2A.hardTestTranspose();

    System.out.println("Passed " + TestL2A.getPass() + " out of " + (TestL2A.getPass() + TestL2A.getFail()));
  }
}