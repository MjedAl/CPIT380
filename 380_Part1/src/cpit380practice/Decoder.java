package cpit380practice;

import java.io.*;

/**
 * Class that allows you to read a file and decode
 * it.
 * @author Barb Ericson
 * Copyright 2006
 */
public class Decoder
{
  ////////////////// fields ///////////////////////////
  
  /** amount to decode (shift left) by */
  private int shiftAmount = 1;
  
  //////////////// constructors //////////////////////
  
  /**
   * Constructor that takes the amount to shift
   * @param theAmount the amount to shift the characters
   * left by
   */
  public Decoder(int theAmount)
  {
    this.shiftAmount = theAmount;
  }
  
  ///////////////// methods //////////////////////////
  
  /**
   * Method to decode a string
   * @param aString the string to decode
   */
  private String decode(String aString)
  {
    char[] charArray = aString.toCharArray();
    char currChar = 'a';
    int charValue = 0;
    
    // loop through the array of characters
    for (int i = 0; i < charArray.length; i++)
    {
      // get the current character
      currChar = charArray[i];
      // convert to int value
      charValue = currChar;
      // add shift amount
      charValue = charValue - shiftAmount;
      // store back character
      charArray[i] = (char) charValue;
    }
    return new String(charArray);
  }
  
  /**
   * Method to decode a file
   * @param encodedFileName the name of the file to read from
   * @param decodedFileName the name of the file to write to
   */
  public void decodeFile(String encodedFileName, 
                         String decodedFileName)
  {
    String encodedLine = null;
    String decodedLine = null;
    
    // try to do the following
    try {
      
      // create the buffered reader
      BufferedReader reader = 
        new BufferedReader(new FileReader(encodedFileName));
      
      // try to open the buffered writer
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(decodedFileName));
      
      // Loop while there is more data
      while((encodedLine = reader.readLine()) != null)
      {
        // decode the line
        decodedLine = decode(encodedLine);
        
        // write out the decoded line
        writer.write(decodedLine);
        writer.newLine();
      }
      
      // close the reader and writer
      reader.close();
      writer.close();
      
    } catch(FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find " + encodedFileName +
                             " please pick it.");
      encodedFileName = FileChooser.pickAFile();
      decodeFile(encodedFileName,decodedFileName);
    } catch(Exception ex) {
      SimpleOutput.showError("Error decoding file " + encodedFileName);
      ex.printStackTrace();
    }
  }
  
  /**
   * Main method for testing
   */
  public static void main(String[] args)
  {
    Decoder decoder = new Decoder(1);
    decoder.decodeFile("c:/intro-prog-java/bookClassesFinal/encoded.txt",
                       "c:/intro-prog-java/bookClassesFinal/decoded.txt");
  }
}