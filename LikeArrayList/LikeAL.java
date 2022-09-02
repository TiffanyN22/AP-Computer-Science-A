public class LikeAL{
  private int[] repArray; 
  private int usedSize; //holds size of array without counting extra positions from append, which adds multiple spaces at once to make it more efficient

  //input: an integer for the size of the array
  //output: this is a constructor (makes the object)
  //effect: instatiates repArray by calling the array constructor 
  public LikeAL(int size){
    repArray = new int[size];
    usedSize = size;
  }

  //input: no input
  //output: an integer representing the size of repArray
  //effect: no side effect 
  public int size(){
    //return repArray.length;
    return usedSize;
  }

  //input: an integer for the index (must be a possible index between 0 and repArray's length - 1)
  //output: the value in repArray at the passed in index
  //effect: no side effect
  public int get(int index){
    return repArray[index];
  }

  //input: an integer for the index and an integer for the value
  //output: this is a void method
  //effect: changes the value of repArray at the passed in index to the passed in value
  public void set(int index, int value){
    repArray[index] = value;
  }

  //input: an integer to add to repArray
  //output: this is a void method
  //effect: if repArray is full, increases the size of repArray by 5 and adds the passed in value at the first new position.  Otherwise, it adds the passed in value at the next available position using usedSize.  In both cases, increment usedSize to account for the newly added value
  public void append(int value){
    if (usedSize == repArray.length){
      int lastIndex = repArray.length;
      int[] oldRepArrray = repArray;
      repArray = new int[lastIndex + 5];  //now, can change size of array by creating array of new size, +5 so this doesn't need to run every time append is called
      for(int i = 0; i < lastIndex; i++){
        repArray[i] = oldRepArrray[i];
      }
      repArray[lastIndex] = value;
      usedSize++;
    }
    else{
      repArray[usedSize] = value;
      usedSize++;
    }
     //System.out.println("append end: used size = " + usedSize + ", arrray length = " + repArray.length);
  }

  //input: none
  //output: an integer representing the actual length of repArray (to test append);
  //effect: no side effect
  public int getActualLength(){
    return repArray.length;
  }

  //input: an integer representing the value to search repArray for 
  //output: a boolean stating whether or not the searchedValue is in any index of repArray
  //effect: no side effect
  public boolean contains(int searchedValue){
    for (int i = 0; i < repArray.length; i++){
      if(repArray[i] == searchedValue){
        return true;
      }
    }
    return false;
  }

  //input: none
  //output: an integer representing the value of usedSize (the length of the repArray array not counting extra unused values at the end)
  //effect: no side effect
  public int getLength(){
    //return repArray.length;
    return usedSize;
  }

  //input: an integer for the number being searched for
  //output: returns the index of searchedValue withinn the object's repArray.  If the searchedValue is not within repArray, it returnns -1
  //effect: no side effect
  public int indexOf(int searchedValue){
    for (int i = 0; i < repArray.length; i++){
      if (repArray[i] == searchedValue){
        return i;
      }
    }
    return -1;
  }
}

