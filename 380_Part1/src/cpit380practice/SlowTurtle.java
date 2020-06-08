package cpit380practice;


/**
 * Class slow turtle that doesn't move
 * as quickly as a normal turtle.  If asked
 * to go forward it will only go 50 and if 
 * asked to go forward an amount it only 
 * goes forward 1/2 that amount
 * @author Barb Ericson
 * Georgia Tech
 */
public class SlowTurtle extends Turtle
{
  ////////////// constructors //////////
  
  /**
   * Constructor that takes a world
   * @param theWorld the world to create
   * the turtle in
   */
  public SlowTurtle(World theWorld)
  {
    super(theWorld);
  }
  
  ////////////// methods /////////////////
  
  /**
   * Method to go forward by a passed amount
   * it will actually go forward by half that
   * amount
   * @param amount the amount to go forward by
   */
  public void forward(int amount)
  {
    super.forward(amount / 2);
  }
  
  /**
   * Method to go forward without a passed
   * amount.  It will go forward by 50
   * instead of the normal default of 100
   */
  public void forward()
  {
    super.forward(50);
  }
}