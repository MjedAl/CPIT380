package BookClasses;

import java.io.*;

/**
 * Class that allows you to read a file and encode
 * it.
 * @author Barb Ericson
 * Copyright 2006
 */
public class Encoder
{
  ////////////////// fields ///////////////////////////
  
  /** amount to shift the letters to the right */
  private int shiftAmount = 1;
  
  //////////////// constructors //////////////////////
  
  /**
   * Constructor that takes the amount to shift
   * @param theAmount the amount to shift the characters
   */
  public Encoder(int theAmount)
  {
    this.shiftAmount = theAmount;
  }
  
  ///////////////// methods //////////////////////////
  
  /**
   * Method to encode a string
   * @param aString the string to encode
   */
  private String encode(String aString)
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
      charValue = charValue + shiftAmount;
      // store back character
      charArray[i] = (char) charValue;
    }
    return new String(charArray);
  }
  
  /**
   * Method encode a file
   * @param fileName the name of the file to read from
   * @param encodedFileName the name of the file to write to
   */
  public void encodeFile(String fileName, String encodedFileName)
  {
    String line = null;
    String encodedLine = null;
    
    // try to do the following
    try {
      
      // create the buffered reader
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      // try to open the buffered writer
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(encodedFileName));
      
      // Loop while there is more data
      while((line = reader.readLine()) != null)
      {
        // encode the line
        encodedLine = encode(line);
        System.out.println(line + "\n" + encodedLine + "\n");
        
        // write out the encoded line
        writer.write(encodedLine);
        writer.newLine();
      }
      
      // close the reader and writer
      reader.close();
      writer.close();
      
    } catch(FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find " + fileName +
                             " please pick it.");
      fileName = FileChooser.pickAFile();
      encodeFile(fileName,encodedFileName);
    } catch(Exception ex) {
      SimpleOutput.showError("Error encoding file " + fileName);
      ex.printStackTrace();
    }
  }
  
  /**
   * Main method for testing
   */
  public static void main(String[] args)
  {
    Encoder encoder = new Encoder(1);
    encoder.encodeFile("c:/intro-prog-java/bookClassesFinal/test.txt",
                       "c:/intro-prog-java/bookClassesFinal/encoded.txt");
  }
}