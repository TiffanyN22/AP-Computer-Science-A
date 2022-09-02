import java.util.Arrays;

public class TestL2A{
  private static int pass = 0;
  private static int fail = 0;

  //input: none
  //output: none
  //effect: makes of object of Like2dArray by passing in a one dimentional array into the connstructor and sees its array field matches the expected result.  Inncrements pass if it does, increments fail and prints out the Like2dArray object's array field if it doesn't match. 
  public static void hardTestConstructor(){
    int[]oneD = {0, 1,2,3,4,5,6,7,8,9,
                10,11,12,13,14,15,16,17,18,19,
                20,21,22,23,24,25,26,27,28,29,
                30,31,32,33,34,35,36,37,38,39,
                40,41,42,43,44,45,46,47,48,49,
                50,51,52,53,54,55,56,57,58,59,
                60,61,62,63,64,65,66,67,68,69,
                70,71,72,73,74,75,76,77,78,79,
                80,81,82,83,84,85,86,87,88,89,
                90,91,92,93,94,95,96,97,98,99};
    int[][]twoD = {{0,1,2,3,4,5,6,7,8,9},
                   {10,11,12,13,14,15,16,17,18,19},
                   {20,21,22,23,24,25,26,27,28,29},
                   {30,31,32,33,34,35,36,37,38,39},
                   {40,41,42,43,44,45,46,47,48,49},
                   {50,51,52,53,54,55,56,57,58,59},
                   {60,61,62,63,64,65,66,67,68,69},
                   {70,71,72,73,74,75,76,77,78,79},
                   {80,81,82,83,84,85,86,87,88,89},
                   {90,91,92,93,94,95,96,97,98,99}};

    Like2dArray testArray = new Like2dArray(oneD);

    boolean passing = true;
    for(int i = 0; i < testArray.getArray().length; i++){
      if (!Arrays.equals(testArray.getArray()[i], twoD[i])){
        passing = false;
      }
    }
    
    if (passing){
      pass++;
    }
    else{
      System.out.println("failed hardTestConstructor");
      System.out.println("Test Array: ");
      for(int i = 0; i < testArray.getArray().length; i++){
        for (int j = 0; j < testArray.getArray()[i].length; j++){
          System.out.print(testArray.getArray()[i][j] + " "); 
        }
        System.out.println();
      }
      fail++;
    }
    
  }

  //input: none
  //output: none
  //effect: calls Like2dArray's transpose method and sees if the new object's array field matches the expected result.  Increments pass if it matches, and, if it doesn't match, increments fail and displays the original and transposed array value at the first failed location
  public static void hardTestTranspose(){
    int[][]ar = {{0,1,2,3,4,5,6,7,8,9},
                 {10,11,12,13,14,15,16,17,18,19},
                 {20,21,22,23,24,25,26,27,28,29},
                 {30,31,32,33,34,35,36,37,38,39},
                 {40,41,42,43,44,45,46,47,48,49},
                 {50,51,52,53,54,55,56,57,58,59},
                 {60,61,62,63,64,65,66,67,68,69},
                 {70,71,72,73,74,75,76,77,78,79},
                 {80,81,82,83,84,85,86,87,88,89},
                 {90,91,92,93,94,95,96,97,98,99}};
    Like2dArray originalArray = new Like2dArray(ar);
    Like2dArray transposedArray = originalArray.transpose();

    boolean passing = true;

    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        if(originalArray.getArray()[i][j] != transposedArray.getArray()[j][i]){
          System.out.println("error with testing transpose array");
          System.out.println(" transposed array: " + originalArray.getArray()[i][j]);
          System.out.println(" original array: " + transposedArray.getArray()[j][i]);
          passing = false;
          break;
        }
      }
    }

    if(passing){
      pass++;
    } else{
      fail++;
    }
  }

  //input: none
  //output: an integer for the number of pass
  //effect: none
  public static int getPass(){
    return pass;
  }

  //input: none
  //output: an integer for the number of fail
  //effect: none
  public static int getFail(){
    return fail;
  }
}