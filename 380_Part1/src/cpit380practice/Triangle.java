package cpit380practice;

import java.awt.*;

/**
 * Class that represents a triangle
 * @author Barb Ericson
 */
public class Triangle
{
  //////////// fields /////////////
  private Point p1;
  private Point p2;
  private Point p3;
  
  ///////////// constructors /////////
  
  /**
   * Constructor that takes 3 points
   * @param pt1 the first point
   * @param pt2 the second point
   * @param pt3 the third point
   */
  public Triangle(Point pt1, Point pt2, Point pt3)
  {
    p1 = pt1;
    p2 = pt2;
    p3 = pt3;
  }
  
  /////////////// methods ///////////////
  
  /**
   * Method to find the midpoint between two points
   * @param pt1 the first point
   * @param pt2 the second point
   * @return the point in the middle of the
   * two points
   */
  public static Point getMidpoint(Point pt1, Point pt2)
  {
    double x = Math.abs(pt1.x - pt2.x) * 0.5 +
      Math.min(pt1.x,pt2.x);
    double y = Math.abs(pt1.y - pt2.y) * 0.5 +
      Math.min(pt1.y,pt2.y);
    Point pt = new Point((int) x,(int) y);
    return pt;
  }
  
  /**
   * Method to get the length between the two points
   * @param pt1 the first point
   * @param pt2 the second point
   * @return the distance between the points
   */
  public static double getDistance(Point pt1, Point pt2)
  {
    double diffX = pt1.x - pt2.x;
    double diffY = pt1.y - pt2.y;
    double dist = Math.sqrt((diffX * diffX) + 
                           (diffY * diffY));
    return dist;
  }
  
  /**
   * Method to get the length of the smallest side
   * @returns the length of the smallest side
   */
  private double getSmallestLength()
  {
    double dist1 = getDistance(this.p1,this.p2);
    double dist2 = getDistance(this.p2,this.p3);
    double dist3 = getDistance(this.p3,this.p1);
    double smallest = Math.min(dist1,dist2);
    smallest = Math.min(smallest,dist3);
    return smallest;
  }
  
  /**
   * Method to recursively subdivide the triangle
   * @param g the graphics context to draw in
   * @param smallestLength the smallest allowed length
   */
  public void subdivideTriangle(Graphics g,
                                int smallestLength)
  {
    double currSmallest = this.getSmallestLength();
    if (currSmallest > smallestLength)
    {
      Point pt12 = this.getMidpoint(p1,p2);
      Point pt23 = this.getMidpoint(p2,p3);
      Point pt31 = this.getMidpoint(p1,p3);
      g.drawLine(pt12.x,pt12.y,pt23.x,pt23.y);
      g.drawLine(pt23.x,pt23.y,pt31.x,pt31.y);
      g.drawLine(pt12.x,pt12.y,pt31.x,pt31.y);
      Triangle t1 = new Triangle(this.p1,pt31,pt12);
      Triangle t2 = new Triangle(this.p2,pt12,pt23);
      Triangle t3 = new Triangle(this.p3,pt31,pt23);
      Triangle t4 = new Triangle(pt12,pt23,pt31);
      t1.subdivideTriangle(g,smallestLength);
      t2.subdivideTriangle(g,smallestLength);
      t3.subdivideTriangle(g,smallestLength);
      t4.subdivideTriangle(g,smallestLength);
    }
  }
  
}
  