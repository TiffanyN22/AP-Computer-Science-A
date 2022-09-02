/*
//Author: Tiffany Nguyen
//Acknowledgement: the code for the Point class and logic for the triangle class came from Mr. Kuszmaul in class, though Tiffany wrote the rest of the code herself, including code for the triangle and polygon classes and their test cases.  Tiffany also collaborated with Parnika to figure out the congruent method in the Triangle class. 


Instructions:
In this assignment you are to create a class called Triangle. An instance of a Triangle supports methods that get the x and y coordinates of each of three points in the xy plane that define the triangle. 
   
It must be possible to create an instance of a Triangle that by default is an equilateral triangle centered on the origin where one of the points has an x coordinate of one. and a y coordinate of zero.  
It must be possible to compare two Triangles using the equals method, and for that method to return true when the triangles are congruent. 
The toString method must be supported so that a default instance will return "(1,0), ( -0.5 ,0.866), (-0.5, -0.866)"  

It should be possible to set the  position of the vertices of a Triangle.
  
It should also be possible to scale any triangle centered on the origin.

It should also be possible to translate any triangle in any direction.

It should also be possible to rotate any triangle about the origin.
*/

import java.util.ArrayList;
import java.util.Arrays;

class Main {
  static int pass = 0;
  static int fail = 0;

  public static void main(String[] args) {
    //point
    Point origin = new Point();
    Point oneOne = new Point(1, 1);
    Point twoTwo = oneOne.scale(2);
    System.out.println("origin point: " + origin);
    System.out.println("oneOne point: " + oneOne);
    System.out.println("twoTwo point: " + twoTwo); 
    
    testPoint(origin, oneOne, twoTwo);
    

    //triangle
    Triangle triangle1 = new Triangle(new Point (0,2), new Point(2,-2), new Point(-2,-2));
    Triangle triangle2 = new Triangle(origin, oneOne, twoTwo);
    Triangle triangle3 = triangle1.translate(-1, 2);
    Triangle triangle4 = triangle1.rotate(new Point(0,1));
    Triangle triangle5 = new Triangle();
    System.out.println("triangle1: " + triangle1);
    System.out.println("triangle2: " + triangle2);
    System.out.println("triangle3: " + triangle3);
    System.out.println("triangle4: " + triangle4);
    System.out.println("triangle5: " + triangle5);

    testTriangle(triangle1, triangle2, triangle3, triangle4, triangle5);


    //polygon
    Polygon polygon1 = new Polygon();
    
    ArrayList<Point> polygon2Points = new ArrayList<Point>(Arrays.asList(origin, oneOne, new Point(0,1), new Point(3,2), new Point(5,3)));
    Polygon polygon2 = new Polygon(polygon2Points);

    System.out.println("polygon1: " + polygon1);
    System.out.println("polygon2: " + polygon2);

    testPolygon(polygon1, polygon2);

    //all
    System.out.println("\nPassed " + pass + " out of " + (pass + fail));
  }

  //input: three objects of points
  //output: this is a void method
  //effect: calls all methods to test Point (hard-coded expected result)
  public static void testPoint(Point origin, Point oneOne, Point twoTwo){

    testPointToString(origin, "(0.0,0.0)");
    testPointToString(oneOne, "(1.0,1.0)");
    testPointToString(twoTwo, "(2.0,2.0)");

    testPointEquals(origin, oneOne, false);
    testPointEquals(oneOne, oneOne, true);
    testPointEquals(twoTwo, new Point(2,2), true);
    testPointEquals(new Point(), new Point(0.0, 0.0), true);

    testPointTranslate(origin, 1, 1, oneOne);
    testPointTranslate(origin, 2, 5, new Point(2, 5));
    testPointTranslate(twoTwo, 1, -3, new Point(3, -1));

    testPointScale(oneOne, 2, twoTwo);
    testPointScale(oneOne, 3, new Point(3,3));
    testPointScale(twoTwo, 2, new Point(4,4));
  }

  //input: 3 objects of Triangle
  //output: this is a void method
  //effect: calls all triangle test methods with hard-coded expected results
  public static void testTriangle(Triangle triangle1, Triangle triangle2, Triangle triangle3, Triangle triangle4, Triangle triangle5){
    testTriangleToString(triangle1, "(0.0,2.0), (2.0,-2.0), (-2.0,-2.0)");
    testTriangleToString(triangle2, "(0.0,0.0), (1.0,1.0), (2.0,2.0)");
    testTriangleToString(triangle5, "(1.0,0.0), (-0.5,0.866), (-0.5,-0.866)");
    
    testTriangleEquals(triangle1, new Triangle(new Point(0,2), new Point(2,-2), new Point(-2,-2)), true);
    testTriangleEquals(triangle5, new Triangle(), true);
    testTriangleEquals(triangle1, triangle2, false);
    testTriangleEquals(triangle2, triangle2, true);
    testTriangleEquals(triangle1, triangle3, false);

    testTriangleScale(triangle1, 2, new Triangle(new Point(0,4), new Point(4,-4), new Point(-4,-4)));
    testTriangleScale(triangle2, 1, triangle2);

    testTriangleTranslate(triangle1, -1, 2, triangle3);
    testTriangleTranslate(triangle1, 1, 0, new Triangle(new Point(1,2), new Point(3, -2), new Point (-1, -2)));
    testTriangleTranslate(triangle2, 5, 3, new Triangle(new Point(5,3), new Point(6, 4), new Point(7, 5)));

    testTriangleRotate(triangle1, new Point(0, 1), new Triangle(new Point(-2,0), new Point(2,2), new Point(2,-2))); //90 degrees
    testTriangleRotate(triangle1, new Point(1, 0), triangle1); //0 degrees

    testTriangleCongruent(triangle5, new Triangle(), true); //same points is congruent
    testTriangleCongruent(triangle1, triangle3, true); //Congruent after translate
    testTriangleCongruent(triangle1, triangle2, false);
    testTriangleCongruent(triangle1, triangle4, true);//Congruent after rotate

    testTriangleSetPoint(triangle1, 1, new Point(0,1));
    testTriangleSetPoint(triangle2, 2, new Point(-3,1));
  }

  //input: 2 objects of Polygon
  //output: void method
  //effect: calls all Polygon test methods with hard-coded expected results
  public static void testPolygon(Polygon polygon1, Polygon polygon2){
    testPolygonToString(polygon1, "(2.0,2.0), (2.0,-2.0), (-2.0,-2.0), (-2.0,2.0)");
    testPolygonToString(polygon2, "(0.0,0.0), (1.0,1.0), (0.0,1.0), (3.0,2.0), (5.0,3.0)");

    testPolygonEquals(polygon1, polygon1, true);
    testPolygonEquals(polygon1, new Polygon(), true);
    testPolygonEquals(polygon2, polygon1, false);

    ArrayList<Point> scaledPolygonPoints = new ArrayList<Point>(Arrays.asList(new Point(4,4), new Point(4,-4), new Point(-4,-4), new Point(-4, 4)));
    testPolygonScale(polygon1, 1, polygon1);
    testPolygonScale(polygon1, 2, new Polygon(scaledPolygonPoints));

    testPolygonTranslate(polygon1, 0, 0, polygon1);
    ArrayList<Point> translatedPolygonPoints = new ArrayList<Point>(Arrays.asList(new Point(-1, 2), new Point(0, 3), new Point(-1, 3), new Point(2, 4), new Point(4, 5)));
    testPolygonTranslate(polygon2, -1, 2, new Polygon(translatedPolygonPoints));
  }

  //POINT TEST

  //input: an object of the point class, an integer for the scale, and a point for the result after editing the scale
  //output: void method
  //effect: calls Poinnt's scale method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPointScale(Point originalPoint, int scaleFactor, Point expectedResult){
    Point scaledPoint = originalPoint.scale(scaleFactor);

    if(scaledPoint.equals(expectedResult)){
      pass++;
    }
    else{
      System.out.println("Failed testPointScale - expected " + expectedResult + " but got " + scaledPoint);
      fail++;
    }
  }

  //input: an object of the pointn class, a string for the expected result
  //output: void method
  //effect:  increments pass if calling toString()method on passed in point gives the same result as the expectedResult string.  If not, it increments fail and prints out expected and actual result
  public static void testPointToString(Point point, String expectedResult){
    if (point.toString().equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testPointToString - expected " + expectedResult + " but got " + point.toString());
    }
  }

  //input: 2 pointns, a boolean with the expected result of comparing the two with equals
  //output: void method
  //effect: calls Poinnt's equals method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPointEquals(Point point1, Point point2, boolean expectedResult){
    if(point1.equals(point2) == expectedResult){
      pass++;
    }
    else{
      System.out.println("Failed testPointEquals - expected " + expectedResult + " but got " + point1.equals(point2));
      fail++;
    }
  }

  //input: a point, doubles for the x and y translation, and a point with the expected result
  //output: void method
  //effect: calls Point's translate method with the passed in values, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPointTranslate(Point point, double xTranslation, double yTranslation, Point expectedResult){
    Point result = point.translate(xTranslation, yTranslation);
    if (result.equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testPointTranslate - expected " + expectedResult + " but got " + result);
    }
  }

  //input: a point, a point to rotate the first poinnt around, and a point for the expected result.
  //output: void method
  //effect: calls Point's rotate method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPointRotate(Point originalPoint, Point rotatePoint, Point expectedResult){
    Point result = originalPoint.rotate(rotatePoint);
    if (result.equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testPointRotate - expected " + expectedResult + " but got " + result);
    }
  }

  //TRIANGLE TESTS
  //input: a triangle, the scale to channge it by, and a triangle for the expected result
  //output: void method
  //effect: calls Triangle's scale method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleScale(Triangle originalTriangle, int scaleFactor, Triangle expectedResult){
    Triangle scaledTriangle = originalTriangle.scale(scaleFactor);

    if(scaledTriangle.equals(expectedResult)){
      pass++;
    }
    else{
      System.out.println("Failed testTriangleScale - expected " + expectedResult + " but got " + scaledTriangle);
      fail++;
    }
  }

  //input: a triangle object and the expectedResult
  //output: void method
  //effect: calls Triangle's toString method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleToString(Triangle triangle, String expectedResult){
    if (triangle.toString().equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testPointToString - expected " + expectedResult + " but got " + triangle.toString());
    }
  }

  //input: two triangle, a boolean for the expected result when comparing the two
  //output: void method
  //effect: calls Triangle's scale method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleEquals(Triangle triangle1, Triangle triangle2, boolean expectedResult){
    if(triangle1.equals(triangle2) == expectedResult){
      pass++;
    }
    else{
      System.out.println("Failed testTriangleEquals for " + triangle1 + " and " + triangle2 + "- expected " + expectedResult + " but got " + triangle1.equals(triangle2));
      fail++;
    }
  }

  //input: an object of the Triangle class, doubles for the x and y translation, and a trianngle for the expected result after translatinng the original traignle
  //output: void method
  //effect: calls Triangle's translate method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleTranslate(Triangle triangle, double xTranslation, double yTranslation, Triangle expectedResult){
    Triangle result = triangle.translate(xTranslation, yTranslation);
    if (result.equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testTriangleTranslate - expected " + expectedResult + " but got " + result);
    }
  }

  //input: a triangle object, a point on the Unit circle to rotate around, and a triangle with the expected result after translation
  //output: void method
  //effect: calls Triangle's rotate method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleRotate(Triangle originalTriangle, Point rotatePoint, Triangle expectedResult){
    Triangle result = originalTriangle.rotate(rotatePoint);
    if (result.equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testTriangleRotate for " + originalTriangle + "at " + rotatePoint + "- expected " + expectedResult + " but got " + result);
    }
  }

  //input: two triangle methods and a boolean stating whether or not they are congruent
  //output: void method
  //effect: calls Triangle's congruent method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleCongruent(Triangle triangle1, Triangle triangle2, boolean expectedResult){
    if (triangle1.congruent(triangle2) == expectedResult){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testTriangleCongruent for " + triangle1 + " and " + triangle2 + " - expected " + expectedResult + " but got " + triangle1.congruent(triangle2));
    }

  }

  //input: an object of a triangle class, the point of change (1 to 3), and the expected enw point
  //output: void method
  //effect: calls Triangle's setPoint method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testTriangleSetPoint(Triangle triangle, int changedPoint, Point newPoint){
    triangle.setPoint(changedPoint, newPoint);
    if(changedPoint == 1){
      if (triangle.getX1() == newPoint.getX() && triangle.getY1() == newPoint.getY()){
        pass++;
      }
      else{
        fail++;
        System.out.println("failed testTriangleSetPoint for " + triangle + " with " + newPoint);
      }
    }
    
    if(changedPoint == 2){
      if (triangle.getX2() == newPoint.getX() && triangle.getY2() == newPoint.getY()){
        pass++;
      }
      else{
        fail++;
        System.out.println("failed testTriangleSetPoint for " + triangle + " with " + newPoint);
      }
    }
    if(changedPoint == 3){
      if (triangle.getX3() == newPoint.getX() && triangle.getY3() == newPoint.getY()){
        pass++;
      }
      else{
        fail++;
        System.out.println("failed testTriangleSetPoint for " + triangle + " with " + newPoint);
      }
    }
  }

  //POLYGON TEST
  //input: an object of the polygon class, an integer to scale it by, annd the expected result of the new polygon
  //output: void method
  //effect: calls Polygon's scale method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPolygonScale(Polygon originalPolygon, int scaleFactor, Polygon expectedResult){
    Polygon scaledPolygon = originalPolygon.scale(scaleFactor);

    if(scaledPolygon.equals(expectedResult)){
      pass++;
    }
    else{
      System.out.println("Failed testPolygonScale - expected " + expectedResult + " but got " + scaledPolygon);
      fail++;
    }
  }

  //input: an object of polygon, a string for the expected result of its toString method
  //output: void method
  //effect: calls Polygons scale method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPolygonToString(Polygon polygon, String expectedResult){
    if (polygon.toString().equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testPointToString - expected " + expectedResult + " but got " + polygon.toString());
    }
  }

  //input: 2 objects of polygon andn hte expected result of comparing them with equal
  //output: void method
  //effect: calls Polygon's equal method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPolygonEquals(Polygon polygon1, Polygon polygon2, boolean expectedResult){
    if(polygon1.equals(polygon2) == expectedResult){
      pass++;
    }
    else{
      System.out.println("Failed testPolygonEquals for " + polygon1 + " and " + polygon2 + "- expected " + expectedResult + " but got " + polygon1.equals(polygon2));
      fail++;
    }
  }

  //input: a polygon object, doubles for its x and y translation, and a polygon with its expected result after translation
  //output: void method
  //effect: calls Polygon's trannslate method, increments pass if the result matches the expected result, increments fail if it doesn't and prints out expected and actual result
  public static void testPolygonTranslate(Polygon polygon, double xTranslation, double yTranslation, Polygon expectedResult){
    Polygon result = polygon.translate(xTranslation, yTranslation);
    if (result.equals(expectedResult)){
      pass++;
    }
    else{
      fail++;
      System.out.println("Failed testPolygonTranslate - expected " + expectedResult + " but got " + result);
    }
  }
}