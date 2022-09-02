/*
@author: Tiffany Nguyen
Ackowledgements: The concept of the CompareMe class comes from Mr. Kuszmaul in class, though I added an additional constructor to initialize CompareMe with a String and integer, instantiated additional colors and objects of CompareMe, and implemented the for loop to test equals().
This was the summative assignment on iterations.

Instructions:
Create a class with three fields of type Color, int, and String.
Initialize the fields for ten instances of this class.

Create an array that holds the ten instance of the class. 
Create a method that compares every pair of objects in the array, reporting when they have the same Color.
Be sure to properly comment, acknowledge, and test your code.
The int and String fields are initialized, but not used in the comparisons in any way
*/

import java.awt.Color;
class Main {
  static int pass = 0;
  static int totalTestCases = 0;

  public static void main(String[] args) {
    System.out.println("Hello world!");

    Color clGreenl = new Color(0, 255,0);
    Color clGreen2 = new Color(0, 255,0); //same Color
    Color clRed1 = new Color(255, 0,0);
    Color clBlue1 = new Color(0, 0,255);
    Color clMagenta1 = new Color(255, 0,255);
    Color clCyan1 = new Color(0, 255,255);
    Color clViolet1 = new Color(125, 0,255);
    Color clViolet2 = clViolet1;
    
    CompareMe likeColor1 = new CompareMe(clGreenl, 1, "likeColor1");
    CompareMe likeColor2 = new CompareMe(clGreenl, 1, "likeColor2");
    CompareMe likeColor3 = new CompareMe(clGreen2, 1, "likeColor3");
    CompareMe likeColor4 = new CompareMe(clRed1, 1, "likeColor4");
    CompareMe likeColor5 = new CompareMe(clBlue1, 1, "likeColor5");
    CompareMe likeColor6 = new CompareMe(clMagenta1, 1, "likeColor6");
    CompareMe likeColor7 = new CompareMe(clCyan1, 1, "likeColor7");
    CompareMe likeColor8 = new CompareMe(clViolet1, 1, "likeColor8");
    CompareMe likeColor9 = new CompareMe(clViolet2, 1, "likeColor9");
    CompareMe likeColor10 = new CompareMe(clViolet2); //unnamedColor

    CompareMe[] allLikeColors = {likeColor1, likeColor2, likeColor3, likeColor4,likeColor5,likeColor6,likeColor7,likeColor8,likeColor9,likeColor10};

    compareArray(allLikeColors);

    System.out.println("Passed " + pass + " out of " + totalTestCases + " test cases");

    /* 
    Testing code: 
    System.out.println(clGreenl.equals(clGreen2));
    System.out.println(clGreenl == clGreen2);
    System.out.println(likeColor1.equals(likeColor2));
    System.out.println(likeColor1 == likeColor2);
    */
  }

  //input: two objects of the CompareMe class to compare
  //output: a boolean returning true or false based on whether or not the objects have the same color using CompareMe's equals method
  //effect: increments the totalTestCases every time, increments pass if the result of CompareMe's equals method matches the result of directly using Color's equals method on the CompareMe object's color, and prints out a statement if the two CompareMe objects have the same color.
  public static boolean compareColors(CompareMe color1, CompareMe color2){
    boolean sameColorWithCMEquals = color1.equals(color2); //compare using Compare Me's Equal Method

    //to test pass/fail, directly compares the color using equals() from the Color class and see if CompareMe's equals() method returns the same result
    boolean directColorComparison = color1.getColor().equals(color2.getColor());
    if (directColorComparison == sameColorWithCMEquals){
      pass++;
    }
    totalTestCases++;

    //print out if they have the same color
    if (sameColorWithCMEquals){
      System.out.println(color1.getColorName() + " and " + color2.getColorName() + " have the same color");
      return true;
    }
    return false;
  }

  //input: an array with the type CompareMe
  //output: this is a void method (no output)
  //effect: calls the compareColors method for all pairs within the passed in array
  public static void compareArray(CompareMe[] arr){
    for(int i = 0; i < arr.length; i++){
      for (int j = i+1; j < arr.length; j++){
        compareColors(arr[i], arr[j]);
      }
    }
  }
}