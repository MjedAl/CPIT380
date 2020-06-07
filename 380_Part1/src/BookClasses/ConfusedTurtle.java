package BookClasses;

/**
 * Class for a confused turtle.  A confused turtle is like
 * a turtle but it turns right when asked to turn left and left
 * when asked to turn right.
 * @author Barb Ericson
 */
public class ConfusedTurtle extends Turtle
{
  //////////////// constructors ///////////////////////
  
  /**
   * A constructor that takes a ModelDisplay object
   * @param modelDisplayObj the thing that does the display
   */
  public ConfusedTurtle(ModelDisplay modelDisplayObj)
  {
    // use parent constructor
    super(modelDisplayObj);
  }
  
  //////////////// methods ///////////////////////////
  
  /**
   * Method to turn right (but a confused
   * turtle will actually turn left)
   */
  public void turnRight() 
  {
    // turn left instead
    super.turn(-90);
  }
  
//  public void turnRight() 
//  {
//    // turn left instead
//    super.turnLeft();
//  }
  
 
//  public void turnLeft()
//  {
//    // turn right instead
//    super.turnRight();
//  }
  
  /**
   * Method to turn left (but a confused
   * turtle will actually turn right)
   */
  public void turnLeft()
  {
    // turn right instead
    super.turn(90);
  }
  
  /**
   * Method to turn by the passed degrees 
   * (a confused turtle will turn by 360- the 
   * passed degrees)
   */
  public void turn(int degrees)
  {
    super.turn(360-degrees);
  }
}