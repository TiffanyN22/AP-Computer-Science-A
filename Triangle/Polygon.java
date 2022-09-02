import java.util.ArrayList;

public class Polygon{
  ArrayList<Point> coordinates = new ArrayList<Point>(); 

  //input: none
  //output: this is a constructor (outputs object of the polygon class)
  //effect: adds default poitns into Polygon
  public Polygon(){
    coordinates.add(new Point(2,2));
    coordinates.add(new Point(2,-2));
    coordinates.add(new Point(-2,-2));
    coordinates.add(new Point(-2,2));
  }

  //input: an arraylist of points for coordinates
  //output: this is a constructor
  //effect: if the passed in arraylist has fewer than 2 points, it prints out a warnign statign that a polygon must have at least 3 points.  otherwise, no side effect
  public Polygon(ArrayList<Point> _coordinates){
    if(_coordinates.size()<=2){
      System.out.println("Warning: Polygon must have at least 3 points");
    }

    coordinates = _coordinates;
  }

  //input: none
  //output: a string with all of the polygon'ns coordiatnes properly formated
  //effect: no side effect
  public String toString(){
    String result = coordinates.get(0).toString();
    for (int i = 1; i < coordinates.size(); i++){
      result = result + ", " + coordinates.get(i).toString();
    }
    return result;
  }

  //input: a polygon object to compare the calling object to
  //output: a boolean stating whether or not the two polygons have the same coordinates
  //effect: no side effect
  public boolean equals(Polygon other){
    if (coordinates.size() != other.coordinates.size()){
      return false;
    }

    for (int i = 0; i < coordinates.size(); i++){
      if (!coordinates.get(i).veryClose(other.coordinates.get(i))){
        return false;
      }
    }
    return true;
  }

  //input: an integer to scale the polygon by
  //output: a new polygon object with the calling polygon's coordiantes scaled
  //effect: no side effect
  public Polygon scale(int scaleFactor){
    ArrayList<Point> newCoordinates = new ArrayList<Point>();

    for(int i = 0; i < coordinates.size(); i++){
      newCoordinates.add(coordinates.get(i).scale(scaleFactor));
    }
    return new Polygon(newCoordinates);
  }

  //input: two doubles for the polygon's x and y translations
  //output: a new polygon obeject with the calling polygon translated
  //effect: no side effect
  public Polygon translate(double xTranslation, double yTranslation){
    ArrayList<Point> newCoordinates = new ArrayList<Point>();

    for(int i = 0; i < coordinates.size(); i++){
      newCoordinates.add(coordinates.get(i).translate(xTranslation, yTranslation));
    }

    return new Polygon(newCoordinates);
  }

  //input: a point on the unit circle to rotate the polygon around
  //output: a new polygon object with the rotated points
  //effect: no side effect
  public Polygon rotate(Point rotatePoint){
    ArrayList<Point> newCoordinates = new ArrayList<Point>();

    for(int i = 0; i < coordinates.size(); i++){
      newCoordinates.add(coordinates.get(i).rotate(rotatePoint));
    }

    return new Polygon(newCoordinates);
  }
}
