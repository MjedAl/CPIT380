package BookClasses;


/**
 * Class for more mathematical functions
 * @author Barb Ericson
 */
public class MoreMath
{
  /**
   * Method to calculate the factorial of a number
   * @param n the number to use in the calculation
   * @return the factorial of the number 
   */
  public static int factorial(int n)
  {
    if (n == 0)
      return 1;
    else 
      return n * factorial (n-1);
  }
}