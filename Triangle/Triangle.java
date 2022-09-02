import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Triangle{
  ArrayList<Point> coordinates = new ArrayList<Point>(); //must have size of 3

  //input: none
  //output: default constructor
  //effect: adds 3 points to coordinates for each point of the triangle; default triangle is equilateral, centered around origin, and passes through (1, 0) 
  public Triangle(){
    coordinates.add(new Point(1,0));

    double point2X = Math.cos(2*Math.PI/3.0);
    double point2Y = Math.sin(2*Math.PI/3.0);
    point2X = Math.round(point2X * 1000.0) / 1000.0;
    point2Y = Math.round(point2Y * 1000.0) / 1000.0;
    coordinates.add(new Point(point2X, point2Y));
    //coordinates.add(new Point(-0.5, 0.866));
    
    coordinates.add(new Point(-0.5, -0.866));
  }

  //input: points from each point of the triangle
  //output: constructor
  //effect: adds the passed in points into coordinates
  public Triangle(Point point1, Point point2, Point point3){
    coordinates.add(point1);
    coordinates.add(point2);
    coordinates.add(point3);
  }

  //input:none
  //output:a string with the triangle's coordinates properly formated 
  //effect: calls Point's toString method
  public String toString(){
    return coordinates.get(0) + ", " + coordinates.get(1)+ ", " + coordinates.get(2);
  }

  //input: a triangle object to compare to
  //output: a boolean stating whether or not the triangles are the same (all coordiantes match in same order)
  //effect: calls Point's veryClose method
  public boolean equals(Triangle other){
    boolean samePoint1 = other.coordinates.get(0).veryClose(this.coordinates.get(0));
    boolean samePoint2 = other.coordinates.get(1).veryClose(this.coordinates.get(1));
    boolean samePoint3 = other.coordinates.get(2).veryClose(this.coordinates.get(2));

    return samePoint1 && samePoint2 && samePoint3;
  }

  //input: an integer to scale the triangle by
  //output: an object of Triangle with the orginal triangle scaled by the scale factor
  //effect: calls Point's scale method for all points in coordinates
  public Triangle scale(int scaleFactor){
    Point coordinate1 = coordinates.get(0).scale(scaleFactor);
    Point coordinate2 = coordinates.get(1).scale(scaleFactor);
    Point coordinate3 = coordinates.get(2).scale(scaleFactor);

    return new Triangle(coordinate1, coordinate2, coordinate3);
  }

  //input: a double for the x translation and a double for the y translation
  //output: an object of the Triangle class with the coordiatnes of the original triangle translated
  //effect: calls Point's translate method (shouldn't have a side effect)
  public Triangle translate(double xTranslation, double yTranslation){
    Point coordinate1 = coordinates.get(0).translate(xTranslation, yTranslation);
    Point coordinate2 = coordinates.get(1).translate(xTranslation, yTranslation);
    Point coordinate3 = coordinates.get(2).translate(xTranslation, yTranslation);

    return new Triangle(coordinate1, coordinate2, coordinate3);
  }

  //input: a point on the unit circle to rotate the triangle around
  //output: a new triangle object with the calling triangle's coordinates rotated
  //effect: no side effect besides Point's rotate() method being called
  public Triangle rotate(Point rotatePoint){
    Point coordinate1 = coordinates.get(0).rotate(rotatePoint);
    Point coordinate2 = coordinates.get(1).rotate(rotatePoint);
    Point coordinate3 = coordinates.get(2).rotate(rotatePoint);

    return new Triangle(coordinate1, coordinate2, coordinate3);
  }

  //input: an integer for the point to change (1 to 3 to indicate one of the triangle's three points), a Point object
  //output: void method
  //effect: changes the trianngle's changedPoint coordinate to the passed in pointn
  public void setPoint(int changedPoint, Point newPoint){
    if (changedPoint > 3 || changedPoint <=0){
      System.out.println("triangle setPoint can only change point 1, 2, or 3");
    }
    else{
      coordinates.set(changedPoint - 1, newPoint);
    }
  }

  //input: no input
  //output: returnns an arraylist of points with all of triangle's coordinates
  //effect: no side effect
  public ArrayList<Point> getCoordinates(){
    return coordinates;
  }

  //input: a triangle object to compare to
  //output: a boolean statign whether or not the two triangles are congruent
  //effect: calls calculateSideLength() and getX and getY methods
  public boolean congruent(Triangle other){
    //get coordinate x/y values
    double pointA1X = getX1(); //x value of point 1 ("a") of triangle 1
    double pointB1X = getX2();
    double pointC1X = getX3();
    double pointA1Y = getY1();
    double pointB1Y = getY2();
    double pointC1Y = getY3();

    double pointA2X = other.getX1();
    double pointB2X = other.getX2();
    double pointC2X = other.getX3();
    double pointA2Y = other.getY1();
    double pointB2Y = other.getY2();
    double pointC2Y = other.getY3();


    //get slide length for triangle 1
    double sideAB1 = calculateSideLength(pointA1X,pointB1X, pointA1Y,pointB1Y);
    double sideBC1 = calculateSideLength(pointB1X,pointC1X, pointB1Y,pointC1Y);
    double sideCA1 = calculateSideLength(pointC1X,pointA1X, pointC1Y,pointA1Y);
    ArrayList<Double> triangle1SideLength = new ArrayList<Double>(Arrays.asList(sideAB1, sideBC1, sideCA1));

    //get slide length for triangle 2
    double sideAB2 = calculateSideLength(pointA2X,pointB2X, pointA2Y,pointB2Y);
    double sideBC2 = calculateSideLength(pointB2X,pointC2X, pointB2Y,pointC2Y);
    double sideCA2 = calculateSideLength(pointC2X,pointA2X, pointC2Y,pointA2Y);
    ArrayList<Double> triangle2SideLength = new ArrayList<Double>(Arrays.asList(sideAB2, sideBC2, sideCA2));

    //compare side lengths of both triangles (uses side, side, side to determine triangle congruency)
    for(int i = 0; i < triangle1SideLength.size(); i++){
      for (int j = 0; j < triangle2SideLength.size(); j++){
        if (triangle1SideLength.get(i).equals( triangle2SideLength.get(j))){
          triangle2SideLength.remove(j);
          break;
        }
      }
    }
    
    //since the code removes sides that match, a congruent triangle should have no unmatched sides
    if (triangle2SideLength.size() == 0){
      return true;
    } else{
      return false;
    }
  }

  //input: doubles for the x and y coordiantes for 2 poitns of a triangle side
  //output: a double for the side length
  //effect: no side effect
  public double calculateSideLength(double x1, double x2, double y1, double y2){
    return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
  }

  //input: none
  //output: a double for the x coordinate of point 1
  //effect: no side effect
  public double getX1(){
    return coordinates.get(0).getX();
  }

  //input: none
  //output: a double for the x coordinate of point 2
  //effect: no side effect
  public double getX2(){
    return coordinates.get(1).getX();
  }

  //input: none
  //output: a double for the x coordinate of point 3
  //effect: no side effect
  public double getX3(){
    return coordinates.get(2).getX();
  }

  //input: none
  //output: a double for the y coordinate of point 1
  //effect: no side effect
  public double getY1(){
    return coordinates.get(0).getY();
  } 

  //input: none
  //output: a double for the y coordinate of point 2
  //effect: no side effect
  public double getY2(){
    return coordinates.get(1).getY();
  } 

  //input: none
  //output: a double for the y coordinate of point 3
  //effect: no side effect
  public double getY3(){
    return coordinates.get(2).getY();
  }
}