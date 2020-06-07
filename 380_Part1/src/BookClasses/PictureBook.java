//package AhmadClassCPIT380;
package BookClasses;

import java.util.*;
import java.io.*;

/**
 * A class that represents a picture book.  This picture 
 * book maps names to pictures.
 */
public class PictureBook
{
  /////////////////// fields /////////////////////////
  
  /** the file name to read from */
  private String fileName;
  /** the book map to store the data */
  private Map<String,String> bookMap = 
    new HashMap<String,String>();
  
  ////////////////// constructors ////////////////////
  
  /**
   * Constructor that takes a file name and reads 
   * in the names and picture files from a file
   * @param file the name of the file to read
   */
  public PictureBook(String file) 
  {
    this.fileName = file;
    
    // read the map information in from the file
    readInfoFromFile();
  }
  
  /////////////////// methods /////////////////////
  
  /**
   * Get the picture for the passed name
   * @param name the name to look up in the map
   * @return the picture if found
   */
  public Picture getPicture(String name) 
  {
    Picture pict = null;
    String pictFile = bookMap.get(name);
    if (pictFile != null)
      pict = new Picture(FileChooser.getMediaPath(pictFile));
    return pict;
  }
  
  /**
   * Method to read the picture book information from a 
   * file and use it to fill the map
   */
  public void readInfoFromFile()
  {
    String line = null;
    String[] bookArray = null;
    
    try {
      
      // create the reader
      BufferedReader reader =
        new BufferedReader(new FileReader(fileName));
      
      // loop reading from the file
      while ((line = reader.readLine()) != null)
      {
        if (line.indexOf(":") >= 0)
        {
          bookArray = line.split(":");
          bookMap.put(bookArray[0].trim(),
                       bookArray[1].trim());
        }
      }
      
      // close the reader
      reader.close();
      
    } catch (FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find file " + fileName);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
      
  }
  
  /**
   * Method to print out the contents of the picture book
   */
  public void printBook()
  {
    // get the set of keys
    Set keySet = bookMap.keySet();
    String key = null;
    
    // loop through the keys
    Iterator iterator = keySet.iterator();
    while (iterator.hasNext())
    {
      key = (String) iterator.next();
      System.out.println("Name: " + key + 
                         ", Picture file: " + 
                         bookMap.get(key));
    }
  }
  
  /* main for testing */
  public static void main(String[] args)
  {
    PictureBook book = 
      new PictureBook(FileChooser.getMediaPath("barbsPictureBook.txt"));
    book.printBook();
    Picture p = book.getPicture("Tammy");
    p.show();
    p = book.getPicture("Matt");
    p.show();
  }
  
}