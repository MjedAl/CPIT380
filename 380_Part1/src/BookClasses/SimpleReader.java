package BookClasses;

import java.io.*;

/**
 * Class that allows you to easily read and print out the 
 * contents of a file
 * @author Barb Ericson
 */
public class SimpleReader
{
  /**
   * Method to read a file and print out the contents
   * @param fileName the name of the file to read from
   */
  public void readAndPrintFile(String fileName)
  {
    String line = null;
    
    // try to do the following
    try {
      
      // create the buffered reader
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      // Loop while there is more data
      while((line = reader.readLine()) != null)
      {
        // print the current line
        System.out.println(line);
      }
      
      // close the reader
      reader.close();
      
    } catch(FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find " + fileName +
                             " please pick it.");
      fileName = FileChooser.pickAFile();
      readAndPrintFile(fileName);
    } catch(Exception ex) {
      SimpleOutput.showError("Error reading file " + fileName);
      ex.printStackTrace();
    }
  }
  
  public static void main(String[] args)
  {
    SimpleReader reader = new SimpleReader();
    reader.readAndPrintFile("test.txt");
  }
}