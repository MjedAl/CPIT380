package BookClasses;

import java.util.*;
import java.io.*;

/**
 * Class that can scramble letters
 * @author Barb Ericson
 * Copyright 2006
 */
public class Scrambler
{
  
  ////////////// fields ////////////////////////////
  
  /** random number generator */
  private Random randNumGen = new Random();
  
  ////////////// constructors //////////////////////
  
  /**
   * No argument constructor 
   */
  public Scrambler()
  {}
  
  /////////////// methods /////////////////////////
  
  /**
   * Method to scramble the letters in the string
   * @param input the string to scramble the letters in
   * @return the new string with the letters scrambled
   */
  public String scramble(String input)
  {
    char[] inputArray = input.toCharArray();
    List<Character> charList = new ArrayList();
    
    // move characters into the list
    for(char currChar : inputArray)
      charList.add(currChar);
    
    // get somthing that can iterate through the list
    Iterator iterator = charList.iterator();
    int index = 0;
    char[] charArray = new char[charList.size()];
    
    // loop till all the letters are used
    while(iterator.hasNext())
    {
      charArray[index] = charList.remove(randNumGen.nextInt(charList.size()));
      index++;
    }
    
    return new String(charArray);
      
  }
  
  /**
   * Method to scramble the letters in each line of a file
   * @param inputFile the path for the input file
   * @param outputFile the path for the output file
   */
  public void scrambleFile(String inputFile, String outputFile)
  {
    String line = null;
    String scrambledLine = null;
    
    // try to do the following
    try {
      
      // create the buffered reader
      BufferedReader reader = 
        new BufferedReader(new FileReader(inputFile));
      
      // try to open the buffered writer
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(outputFile));
      
      // Loop while there is more data
      while((line = reader.readLine()) != null)
      {
        // scramble the line
        scrambledLine = scramble(line);
        
        // write out the scrambled line
        writer.write(scrambledLine);
        writer.newLine();
      }
      
      // close the reader and writer
      reader.close();
      writer.close();
      
    } catch(FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find " + inputFile +
                             " please pick it.");
      inputFile = FileChooser.pickAFile();
      scrambleFile(inputFile,outputFile);
    } catch(Exception ex) {
      SimpleOutput.showError("Error with file " + inputFile);
      ex.printStackTrace();
    }
  }
  
  /**
   * Main method for testing
   */
  public static void main(String[] args)
  {
    Scrambler scrambler = new Scrambler();
    scrambler.scrambleFile("c:/intro-prog-java/bookClassesFinal/textToScramble.txt",
                           "c:/intro-prog-java/bookClassesFinal/scrambledText.txt");
  }
}