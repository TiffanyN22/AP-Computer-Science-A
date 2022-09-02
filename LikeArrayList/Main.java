/*
Author: Tiffany Nguyen
//Acknowledgemet: this is a exploration of a class that is like an ArrayList of String.  The basic code for LikeAL comes from Mr. Kuszmaul in class, but Tiffany wrote the test cases in Main and the methods they use, including the optimized append

Instructions: 
Implement a class names LikeAL that matches the functionality of an Arraylist<String>  in four ways (see below), using arrays as the underlying representation. For extra credit implement  LikeAL *without* using arrays (or arraylists).

The following four ArrayList methods should be implemented for LikeAL in the same way as they are supported for by ArrayList.
  add //here, it is append()
  contains
  get
  indexOf

The challenging part of this assignment will involve coping with the fact that the size of an array is fixed, while the size of an arraylist is not. One way to cope with this will be shown in class!
*/

import java.util.ArrayList; 

class Main {
  static int pass = 0;
  static int fail = 0;

  public static void main(String[] args) {
    ArrayList<Integer> als = new ArrayList<Integer>();
    LikeAL lals = new LikeAL(0);

    als.add(1);
    lals.append(1);
    als.add(7);
    lals.append(7);

    testEquals(als, lals);
    testSize(als, lals);

    als.set(0, 5);
    lals.set(0, 5);

    testEquals(als, lals);
    testSize(als, lals);

    testGetNumbers(lals, 0, 5);
    testGetNumbers(lals, 1, 7);

    testContains(lals, 1, false);
    testContains(lals, 5, true);
    testContains(lals, 10, false);

    testIndexOf(lals, 5, 0);
    testIndexOf(lals, 7, 1);
    testIndexOf(lals, 9, -1);

    testOptimizedAppend(lals, 5, 3, 5);
    testOptimizedAppend(lals, 3, 4, 5);
    testOptimizedAppend(lals, 2, 5, 5);
    testOptimizedAppend(lals, 10, 6, 10);
    testOptimizedAppend(lals, 7, 7, 10);

    System.out.println("passed "+ pass + " out of " + (pass + fail));

  }

  //input: an ArrayList<Integer> object and a LikeAL obejct
  //output: this is a void method
  //effect: increments pass if the two passed in arrays have the same size, increments fail if they don't.
  public static void testSize(ArrayList<Integer> als, LikeAL lals){
    if (als.size() == lals.size()){
      pass++;
    }else{
      System.out.println("Failed size test");
      fail++;
    }
  }

  //input: an object of ArrayList<Integer> and an object of the  LikeAL class
  //output: this is a void method
  //effect: if the two passed in lists have different lengths, it prints out an error message and increments fail.  Additionally, a for loop checks every object in both arrays and, for each index, increments pass if they match or increments fail and print out the result of both if they don't match
  public static void testEquals(ArrayList<Integer> als, LikeAL lals){
    //to avoid index out of bound error, searches for the shorter of the two lists passed in
    int shorterLength = lals.getLength();
    if (als.size() > shorterLength){
      shorterLength = als.size();
      fail += (lals.getLength() - als.size()); //adds fail for all positions in lals that is not in als
      System.out.println ("Error - als size is " + als.size() + ", but lals size is" + lals.getLength());
    }

    for (int i = 0; i < shorterLength; i++){
      if(als.get(i) == lals.get(i)){
      pass++;
      } 
      else{
        System.out.println("failed get " + i + " test");
        System.out.println(" als is" + als.get(i));
        System.out.println(" lals is " + lals.get(i));
        fail++;
      }
    }
  }

  //input: an object of LikeAL, an integer representing the index to check, and an interger representing the expected result
  //output: this is a void method
  //effect: increments pass if calling LikeAL's get() method with the index returns the same integer as the expected result
  public static void testGetNumbers(LikeAL lals, int index, int expectedResult){
    //numbers match intended numbers:
    if (lals.get(index) == expectedResult){
      pass++;
    }
    else{
      fail++;
      System.out.println ("Failed get test at " + index + " - expected " + expectedResult + ", but got " + lals.get(index));
    }
  }

  //input: a LikeAL object, an integer with the value to search in LikeAL object, and a boolean stating the expected result.
  //ouput: this is a void method
  //effect: increments pass if the result of calling LikeAL's contains() method with the LikeAL object and passing in the searchedValue integer matches the expectedResult.  Otherwise, it increments fail and prints out the expected and actual result
  public static void testContains(LikeAL lals, int searchedValue, boolean expectedResult){
    if (lals.contains(searchedValue) == expectedResult){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed contains test - expected " + expectedResult + ", but got " + lals.contains(searchedValue));
    }
  }

  //input: an object of LikeAL, an integer for the searched for value, and an integer representing the expected result (the index of searchedValue in lals)
  //output: this is a void method
  //effect: increments pass if calling LikeAL's indexOf() method returns the same integer as the expectedResult.  Otherwise, increments fail and prints out the expected and actual result
  public static void testIndexOf(LikeAL lals, int searchedValue, int expectedResult){
    if (lals.indexOf(searchedValue) == expectedResult){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testIndexOf - expected " + expectedResult + " but got " + lals.indexOf(searchedValue));
    }
  }

  //input: an object of LikeAL, an integer to add to the LikeAL object using append, an integer for the expected new size after appending the value, an integer for the actual new size after appending the value
  //output: void method
  //effect: calls LikeAL's append() method on lals (which adds the value and changes size), increments pass if both the new size and new actual size of lals matches the expected value, increments fail otherwise and prints out the actual vs expected value
  public static void testOptimizedAppend(LikeAL lals, int newValue, int newSizeExpected, int newActualSizeExpected){
    lals.append(newValue);

    boolean passedSize = (newSizeExpected == lals.getLength());
    boolean passedActualSize = (newActualSizeExpected == lals.getActualLength());

    if(passedSize && passedActualSize){
      pass++;
    }
    else{
      fail++;
      if (!passedSize){
        System.out.println("Append failed size - expected " + newSizeExpected + " but got " + lals.getLength());
        }
        if (!passedActualSize){
        System.out.println("Append failed actual size - expected " + newActualSizeExpected + " but got " + lals.getActualLength());
        }
    }
  }
}