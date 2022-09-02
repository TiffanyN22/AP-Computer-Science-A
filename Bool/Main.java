//Author: Tiffany Nguyen
//Acknowledgement: the use of a 2D array to test if the 2 functions return the same value for all 8 test cases came from Mr. Kuszmaul.  Tiffany wrote the for loop to test if the values returned are accurate, and the ifElse() and elseIf() methods in the Bool class.  The concept of entailment, which is used in the bool class, comes from the Stanford logic curriculum

/*
The following are the requirements of the assignment:
Conforming to the documentation standard (authorship, acknowledgement, method comments, testing) please turn in a repl link as well as the Main.java and the Bool.java files for the following:

Write a class called Bool that has two non static public boolean methods that each take three boolean arguments. One method should be named ifElse and the other names elseIf. Each method should be invoked twice from the main method in Main.java in the usual fashion for test cases. Thus "passed 4/4 tests" would be a plausible correct output for your program.

The methods ifElse and elseif should function as equivalent boolean expressions. However, they should not be identical code. ifElse should include an if statement that has an else clause, but no else if clause. elseIf should on the other hand include an if statement with an else if clause, but no else clause. 

The methods should return true the when their first and third arguments are both true, or when the second argument entails the first argument, but in all other cases they should return false.

The following truth table may be of use.

Desired result:
arg1    arg2     arg3     result
0        0        0        1
0        0        1        1
0        1        0        0
0        1        1        0
1        0        0        1
1        0        1        1
1        1        0        1
1        1        1        1
*/


class Main {
  public static void main(String[] args) {
    int equivalentTest = 0;
    int equivalentPass = 0;

    Bool booleanExpression = new Bool();

    boolean[][] testCases = {{false, false, false}, {false, false, true}, {false, true, false}, {false, true, true}, {true, false, false}, {true, false, true}, {true, true, false}, {true, true, true}};
    boolean[] intendedResult = {true, true, false, false, true, true, true, true};

    System.out.println ("Testing function equivalence");
    for (boolean[] tcase : testCases){
      if (booleanExpression.elseIf(tcase[0], tcase[1], tcase[2])
      == booleanExpression.ifElse(tcase[0], tcase[1], tcase[2])){
        equivalentPass++;
        System.out.println(" Passed for test case " + tcase[0] + ", " + tcase[1] + ", " + tcase[2]);
      }

      equivalentTest++;
    }
    System.out.println("The two functions are equivalent-Passed " + equivalentPass + " out of " + equivalentTest);
    System.out.println();

    System.out.println("Testing if fuctions evaluate as intended");
    int correctValueTest = 0;
    int correctValuePass = 0;
    for (int i = 0; i < intendedResult.length; i++){
      //test elseIf
      correctValueTest++;
      if (booleanExpression.elseIf(testCases[i][0], testCases[i][1], testCases[i][2]) == intendedResult[i]){
        correctValuePass++;
        System.out.println(" elseIf passed for " + testCases[i][0] + ", " + testCases[i][1] + ", " + testCases[i][2]);
      }
      else{
        System.out.println(" elseIf failed for " + testCases[i][0] + ", " + testCases[i][1] + ", " + testCases[i][2]);
      }

      //test ifElse
      correctValueTest++;
      if (booleanExpression.ifElse(testCases[i][0], testCases[i][1], testCases[i][2]) == intendedResult[i]){
        correctValuePass++;
        System.out.println(" ifElse passed for " + testCases[i][0] + ", " + testCases[i][1] + ", " + testCases[i][2]);
      }
      else{
        System.out.println(" ifElse failed for " + testCases[i][0] + ", " + testCases[i][1] + ", " + testCases[i][2]);
      }
    }
    System.out.println("The functions work as intended-Passed " + correctValuePass + " out of " + correctValueTest);

  }
}