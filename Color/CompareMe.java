import java.awt.Color;

public class CompareMe{
  private Color myColor;
  private int numberOfColors;
  private String colorName;

  //input: an instance of the Color class 
  //output: this is a constructor 
  //effect: sets myColor based on the parameter and sets default values for the other variables
  CompareMe(Color _initialShade){
     myColor = _initialShade;
     colorName = "unnamedColor";
     numberOfColors = 0;
  }

  //input: an instance of the Color class, an integer, and a String for the object's name
  //output: this is a constructor 
  //effect: sets all fields of the CompareMe class based on the parameters
  CompareMe(Color _initialShade, int _numberOfColors, String _colorName){
     myColor = _initialShade;
     numberOfColors = _numberOfColors;
     colorName = _colorName;
  }

  //input: instance of the class CompareMe with the myColor field set
  //output: a boolean that shows if the myColor field of the two objects are the same using the color equals method
  //Effect: no side effects
  public boolean equals(CompareMe other){ 
    return myColor.equals(other.myColor);
  }

  //input: no input
  //output: a string that returns the colorName of the object
  //effect: no side effect
  public String getColorName(){
    return colorName;
  }

  //input: no input
  //output: an object of the ColorClass that represent myColor of the CompareMe object
  //effect: no side effect
  public Color getColor(){
    return myColor;
  }
}