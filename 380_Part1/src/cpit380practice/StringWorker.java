package cpit380practice;


/**
 * Class that has methods that operate on a string
 * @author Barb Ericson ericson@cc.gatech.edu
 * Copyright 2006
 */
public class StringWorker
{
  //////////// fields /////////////////////
  
  /** string to work on */
  private String aString;
  
  ////////////// constructors /////////////
  
  /**
   * Constructor that take the string to work with 
   * @param theString the string to work with
   */
  public StringWorker(String theString)
  {
    this.aString = theString;
  }
  
  //////////////// methods //////////////////
  
  /**
   * Method to mirror front of the string to the
   * back
   * @return the new string that is mirrored
   */
  public String mirror()
  {
    char[] charArray = this.aString.toCharArray();
    int mirrorPoint = charArray.length;
    int lastIndex = charArray.length - 1;
    char theChar = charArray[0];
    
    // loop up to mirror point
    for (int i = 0; i < mirrorPoint; i++)
    {
      theChar = charArray[i];
      charArray[lastIndex - i] = theChar;
    }
    return new String(charArray);  
  }
  
  /**
   * Method to count the number of males and females in a string
   * where male is coded as M and female is coded as F
   * This method will print out the percentage of males and females
   */
  public void printPercentMaleFemale()
  {
    int males = 0;
    int females =0;
    char currChar;
    
    // loop through characters in the string
    for (int i = 0; i < aString.length(); i++)
    {
      currChar = aString.charAt(i);
      if (currChar == 'M')
        males++;
      else if (currChar == 'F')
        females++;
    }
    double total = males + females;
    System.out.println("Percent females is " + females / total +
                       " percent males is " + males / total);
  }
  
  /**
   * Method to count the number of males and females in a string
   * where male is coded as M and female is coded as F
   * This method will print out the percentage of males and females
   */
  public static void printPercentMaleFemale(String aString)
  {
    int males = 0;
    int females =0;
    char currChar;
    
    // loop through characters in the string
    for (int i = 0; i < aString.length(); i++)
    {
      currChar = aString.charAt(i);
      if (currChar == 'M')
        males++;
      else if (currChar == 'F')
        females++;
    }
    double total = males + females;
    System.out.println("Percent females is " + females / total +
                       " percent males is " + males / total);
  }
  
  /**
   * Method to fix up bad typing on a string 
   */
  public static String fixItUp(String badInput)
  {
    char[] charArray = new char[badInput.length()];
    char currChar;
    
    // loop through the characters in the string
    for (int i = 0; i < badInput.length(); i++)
    {
      currChar = badInput.charAt(i);
      if (currChar == '7')
        charArray[i] = 'u';
      else if (currChar == '8')
        charArray[i] = 'i';
      else if (currChar == '9')
        charArray[i] = 'o';
      else if (currChar == '0')
        charArray[i] = 'p';
      else if (currChar == 'u')
        charArray[i] = 'j';
      else if (currChar == 'i')
        charArray[i] = 'k';
      else if (currChar == 'o')
        charArray[i] = 'l';
      else if (currChar == 'h')
        charArray[i] = 'n';
      else if (currChar == 'j')
        charArray[i] = 'm';
      else if (currChar == 'y')
        charArray[i] = 'h';
      else if (currChar == '6')
        charArray[i] = 'y';
      else
        charArray[i] = currChar; 
    }
    return new String(charArray);
  }
  
  /**
   * Main method for testing
   */
  public static void main(String[] args)
  {
    // try a string with an even number of characters 
    StringWorker worker = new StringWorker("This is a test");
    String mString = worker.mirror();
    System.out.println(mString);
    
    // try one with an odd number
    worker = new StringWorker("Try an odd number of characters");
    mString = worker.mirror();
    System.out.println(mString);
  }
}