public class Like2dArray{
  private int[][] array = new int[10][10];

  //intput: a 1D array, should have a size of 100
  //output: this is a constructor that returns an object of Like2dArray
  //effect: fills in Like2dArray's array object with the passed in array.  If the pass in _array's length is not 100, it prints out a message, fills up array as far as it can or until it reaches the 100th index, and sets any remaining spaces to 0
  public Like2dArray(int[] _array){ //can we make this size 100?
    if (_array.length == 100){
      for(int i = 0; i < 100; i++){
        array[i/10][i%10] = _array[i];
      }
    }
    else{
      System.out.println("Array passed into Like2dArray should have a size of 100");
      for(int i = 0; i < 100 && i < _array.length; i++){
        array[i/10][i%10] = _array[i];
      }
      //fills leftover with 0
      for (int i =_array.length; i < 100; i++){
        array[i/10][i%10] = 0;
      }
    }
  }

  //input: a two dimentional array
  //output: this is a constructor
  //effect: sets the field array equal to the passed in _array
  public Like2dArray(int[][] _array){
    array = _array;
  }

  //input: none
  //output: an object of Like2dArray with the calling Like2dArray's array field transposed so that the new array[i][j] will be equal to the original array[j][i]
  //effect: no side effect
  public Like2dArray transpose(){
    int[][] newArray = new int [10][10];
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < 10; j++){
        newArray[i][j] = array[j][i];
      }
    }
    return new Like2dArray(newArray);
  }

  //input: none
  //output: a 2 dimentional array that is the array field
  //effect: no side effect
  public int[][] getArray(){
    return array;
  }
}