package cpit380practice;

/**
 * Class for an opposite turtle.  An opposite turtle is like
 * a turtle but it turns right when asked to turn left and left
 * when asked to turn right.  It goes backward when asked to go forward
 * and forward when asked to go backward.  It turns (360-amount) when
 * asked to turn.
 * 
 * @author Barb Ericson
 */
public class OppositeTurtle extends Turtle
{
  //////////////// constructors ///////////////////////
  
  /**
   * A constructor that takes a ModelDisplay object
   * @param modelDisplayObj the thing that does the display
   */
  public OppositeTurtle(ModelDisplay modelDisplayObj)
  {
    // use parent constructor
    super(modelDisplayObj);
  }
  
  //////////////// methods ///////////////////////////
  
  /**
   * Method to go forward (actually go backward)
   */
  public void forward()
  {
    super.forward(-100);
  }
  
  /**
   * Method to go forward by the passed amount
   * (actually will go backward)
   * @param amount the amount in pixels
   */
  public void forward(int amount)
  {
    super.forward(-amount);
  }
  
  /**
   * Method to go backward by a passed amount
   * (actually will go forward)
   * @param amount the amount in pixels
   */
  public void backward(int amount)
  {
    super.forward(amount);
  }
  
  /**
   * Method to turn by a given amount
   * (actually will turn 360-amount)
   * @param degrees the amount in degrees
   */
  public void turn(int degrees)
  {
    super.turn(360-degrees);
  }
  
  
  /**
   * Method to turn right (but a dance
   * turtle will actually turn left)
   */
  public void turnRight() 
  {
    super.turn(-90);
  }
  
  /**
   * Method to turn left (but a dance
   * turtle will actually turn right)
   */
  public void turnLeft()
  {
    super.turn(90);
  }
  
}