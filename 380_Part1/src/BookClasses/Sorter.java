package BookClasses;


/**
 * Class that contains standard sort methods
 * @author Barbara Ericson
 */
public class Sorter
{
  /**
   * Method to do a selection sort on 
   * an array of integers
   */
  public static void selectionSort(int[] numberArray)
  {
    int temp; // used to hold value temporarily
    
    // loop from 0 to one before last
    for (int i = 0; i < numberArray.length - 1; i++)
    {
      // set the position of the smallest value to i
      int smallestPos = i;
      
      // loop from past current (i + 1) to end
      for (int j = i+1; j < numberArray.length; j++)
      {
        // if the current is smaller then save pos
        if (numberArray[j] < numberArray[smallestPos])
        {
          smallestPos = j;
        }
      }
      // swap smallest with current value at i
      temp = numberArray[i];
      numberArray[i] = numberArray[smallestPos];
      numberArray[smallestPos] = temp;
    }
  }
  
  public static void main(String[] args)
  {
    int[] numArray = {99, 2, 1, 88, 66, 32};
    Sorter.selectionSort(numArray);
    for (int x: numArray)
    {
      System.out.print(x + " ");
    }
  }
}
  