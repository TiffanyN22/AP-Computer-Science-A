public class Bool{

  //input: 3 booleans to compare
  //output: returns true if the first and thrrid arguments are both true or if the second argument entails the first argument.  Otherwise, it returns false
  //effect: no side effect (just returns the value based on comparisons)
  public boolean ifElse(boolean a, boolean b, boolean c){
    if (a && c) return true;
    else return (!(b && !a));  
    //entailmennt returns true unless the first number is true and the second number is false
  }

  //input: 3 booleans to compare
  //output: returns true if the first and thrrid arguments are both true or if the second argument entails the first argument.  Otherwise, it returns false
  //effect: no side effect
  public boolean elseIf(boolean a, boolean b, boolean c){
    if (a && c) return true;
    else if (!(b && !a)) return true;

    return false;
  }  
}