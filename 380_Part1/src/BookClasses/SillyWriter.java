package BookClasses;

import java.io.*;

/**
 * Class that shows how to write to a file
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class SillyWriter
{
  /**
   * Method to write a silly file
   */
  public void writeSillyFile() 
  {
    try {
      // try to open the buffered writer
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter("silly.txt"));
      
      // write out the file
      writer.write("Here is some text.");
      writer.newLine();
      writer.write("Here is some more.");
      writer.newLine();
      writer.write("And now we're done.");
      writer.newLine();
      writer.newLine();
      writer.write("THE END");
      writer.close();
    } catch (Exception ex) {
      System.out.println("Error during write of silly.txt");
    }
  }
  
  public static void main(String[] args)
  {
    SillyWriter sillyWriter = new SillyWriter();
    sillyWriter.writeSillyFile();
  }
      
}