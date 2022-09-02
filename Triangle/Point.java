public class Point{
  private double x, y;

  //input: none
  //output: default constructor
  //effect: gives x and y the default points of (0,0)
  public Point(){
    x = 0;
    y = 0;
  }


  //input: a double for the x coordinate, a double for the y coordinate
  //output: connstructor
  //effect: sets x and y to the passed in values
  public Point(double _x, double _y){
    x = _x;
    y = _y;
  }

  //input: none
  //output: a string with the point's x and y coordinated properly formated
  //effect: no side effect
  public String toString(){
    return "(" + x + "," + y + ")";
  }

  //input: an integer to scale the point by
  //output: returns a new object of the Point class with the new scale
  //effect: none
  public Point scale(int scale){
    return new Point(x*scale, y*scale);
  }

  //input: a point object to compare to
  //output: a boolean stating whether or not the two points are equal (same x and y coordinate)
  //effect: no side effect
  public boolean equals(Point other){
    return this.x == other.x && this.y ==other.y;
  }

  //input: a poinnt object to compare to
  //output: a boolean stating whether or nnt the 2 points are close, with close being defined as the points being within 0.1 distance of each other
  //effect: no side effect
  public boolean veryClose(Point other){
    boolean closeX = (Math.abs(this.x - other.x)<0.1);
    boolean closeY = (Math.abs(this.y - other.y)<0.1);

    return closeX && closeY;
  }

  //input: a double for the x and y translation
  //output: a new object of the Point class after accounting for the x and y translation on the callign object
  //effect: no side effect
  public Point translate(double xTranslation, double yTranslation){
    return new Point(x + xTranslation, y + yTranslation);
  }

  //input: a Point to rotate around (must be on the unit circle)
  //outpit: a new object of the point class after the rotation
  //effect: no side effect
  public Point rotate(Point other){
    //equation: (ac - bd, ad + bc);
    // other is a point on unit circle --> a point rotated by the input
    double a = other.x;
    double b = other.y;

    return new Point(a*x - b*y, a*y + b*x);
  }

  //input: none
  //output: a double for the x coordiante
  //effect:  no side effect
  public double getX(){
    return x;
  }

  //input: none
  //output: a double for the y coordiante
  //effect:  no side effect
  public double getY(){
    return y;
  }

}