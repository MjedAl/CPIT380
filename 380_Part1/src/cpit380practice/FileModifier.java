package cpit380practice;

import java.util.*;
import java.io.*;

/**
 * Class to demonstrate using a program to modify another program
 * @author Barb Ericson 
 */
public class FileModifier
{
  /**
   * Method to modify the first string in a method to 
   * be the passed changed text
   * @param fileName the file name for the class to modify
   * @param textToChange the text to change
   * @param changedText the new text to use for the text to 
   * change
   */
  public void modifyFile(String fileName, 
                          String textToChange,
                          String changedText)
  {
    List lineList = new ArrayList();
    String line = null;
    int pos = 0;
    
    // try the following
    try {
      
      // open the file to read from
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      /* loop while there are more lines in the file 
       * and we haven't found the text to change yet
       */
      while((line = reader.readLine()) != null && 
            line.indexOf(textToChange) < 0)
      {
        lineList.add(line);
      }
      
      /* If we get there we either ran out of lines or we
       * found the text to change
       */
      if (line != null)
      {
        // get the position of the text to change
        pos = line.indexOf(textToChange);
        
        // modify the string
        lineList.add(line.substring(0,pos) + 
                     changedText + 
                     line.substring(pos + 
                                    textToChange.length()));
        
        
        // loop till the end of the file adding the rest
        while ((line = reader.readLine()) != null)
        {
          lineList.add(line);
        }
        
      }
      
      // now close the file 
      reader.close();
      
      // create a writer to write out the file
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(fileName));
      
      // loop writing out the lines
      for (int i = 0; i < lineList.size(); i++)
      {
        writer.write((String) lineList.get(i));
        writer.newLine();
      }
      
      // close the writer
      writer.close();
    } catch (FileNotFoundException ex) {
      SimpleOutput.showError("Couln't find file " + fileName);
      fileName = FileChooser.pickAFile();
      modifyFile(fileName,textToChange,changedText);
    } catch (Exception ex) {
      SimpleOutput.showError("Error during read or write");
      ex.printStackTrace();
    } 
  }
  
  // Main method to run
  public static void main(String[] args) 
  {
    FileModifier fileMod = new FileModifier();
    String file = 
      "C:\\intro-prog-java\\bookClassesFinal\\Cartoon.java";
    fileMod.modifyFile(file,
                         "Just Horsing Around!",
                         "What's up, Wilbur?");
  }
}