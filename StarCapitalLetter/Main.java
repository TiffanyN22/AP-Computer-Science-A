/*
Author: Tiffany Nguyen
Acknowledgements: the logic for both the for loop and while loop to identify capital letters and replace them was taken from Mr. Kuszmaul during class.  However, I made the edits needed to the forVersion() and whileVersion() methods to replace capital letters with an * and added additional test cases.  This assignment was for a formative on while vs for loops.

Instructions:
I wrote the methods forVersion and whileVerrsion;
Write two equivalent methods that each iterate through a string (the argument to the method).
Each method shall be static, and will return a string that has a * in place of any capitalized letters in the argument. 
Each method should use an index variable in the iterating loop to access a different  character of the argument on each iteration.
The purpose of the assignment is to demonstrate the difference between a for loop and while loop while showing that each can perform the functionality of the other.

Be sure to properly comment, identify, and test your methods.
*/

class Main {
  public static void main(String[] args) {
    int pass = 0;
    int testCases = 0;

    //test case 1 - all lowercase
    String whileResult = whileVersion("hello");
    String forResult = forVersion("hello");
    if (forResult.equals(whileResult)){
      pass++;
    }
    else{
      System.out.println("Failed test case, whileversion gave " + whileResult + " and for version gave " + forResult);
    }
    testCases++;

    //test case 2 - all uppercase
    whileResult = whileVersion("HELLO");
    forResult = forVersion("HELLO");
    if (forResult.equals(whileResult)){
      pass++;
    }
    else{
      System.out.println("Failed test case, whileversion gave " + whileResult + " and for version gave " + forResult);
    }
    testCases++;

    //test case 3 - no text in string
    whileResult = whileVersion("");
    forResult = forVersion("");
    if (forResult.equals(whileResult)){
      pass++;
    }
    else{
      System.out.println("Failed test case, while version gave " + whileResult + " and for version gave " + forResult);
    }
    testCases++;

    //test case 4 - capital is lowercase
    whileResult = whileVersion("hElLo WoRlD");
    forResult = forVersion("hElLo WoRlD");
    if (forResult.equals(whileResult)){
      pass++;
    }
    else{
      System.out.println("Failed test case, while version gave " + whileResult + " and for version gave " + forResult);
    }
    testCases++;

    System.out.println("passed " + pass + " out of " + testCases);
  }


  //input: a string
  //output: the string, with all uppercase letters replaced with a *
  //effect: no side effect, the code only uses strings and a for loop to replace the with capitals with an *
  public static String forVersion(String arg){
    String retval = "";
    String allCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = 0; i<arg.length(); i++){
      String currentSubstring = arg.substring(i,i+1);
      String toBeAdded = currentSubstring;
      if(allCaps.contains(currentSubstring)){
        toBeAdded = "*";
        //arg.substring(i,i+1)
      }
      retval += toBeAdded;;
    }
    System.out.println(" Result of for loop for " + arg + " is " + retval);
    return retval;
  }

  //input: a string
  //output: the string, with all uppercase letters replaced with a *
  //effect: no side effect, the code only uses strings and a while loop to replace the with capitals with an *
  public static String whileVersion(String arg){
    String result = "";
    String allCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    int i = 0;
    boolean notDone = true;
    
    if (arg.length() == 0) notDone = false; //done if string length 1

    while (notDone){
      String currentSubstring = arg.substring(i,i+1);
      String toBeAdded = currentSubstring;
      if(allCaps.contains(currentSubstring)){
        toBeAdded = "*";
      }
      result += toBeAdded;

      i++;
      notDone = (i!=arg.length());
    }
    System.out.println(" Result of while loop for " + arg + " is " + result);
    return result;
  }
}