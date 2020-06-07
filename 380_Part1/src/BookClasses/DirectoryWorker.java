package BookClasses;

import java.io.*;

/**
 * Class to work with files in a directory
 */
public class DirectoryWorker
{
  
  ////////////// methods ////////////////////
  
  /**
   * Method to list all of the files in a 
   * directory and all the files in all 
   * subdirectories
   * @param dir the directory to list
   */
  public static void listFiles(File dir)
  {
    File[] fileArray = dir.listFiles();
    for (File currFile : fileArray)
    {
      System.out.println("Directory " + 
                         dir.getPath() +
                         " File " + 
                         currFile.getPath());
      if (currFile.isDirectory())
        listFiles(currFile);
    }
  }
  
  /**
   * Method to add a string to every picture in directory
   * @param dir the name of the directory
   * @param text the text of the string to add
   */
  public void addStringToPictures(String dir, String text)
  {
    String name = null;
    
    // create the object that represents the directory
    File file = new File(dir);
    
    // Get the array of names in the directory
    String[] nameArray = file.list();
    
    // loop through the names
    for (int i = 0; i < nameArray.length; i++)
    {
      name = nameArray[i];
      
      // if this is a picture file
      if (name.indexOf(".jpg") >= 0)
      {
        Picture p = new Picture(dir + name);
        p.drawString("Property of Georgia Tech", 5, 
                     p.getHeight() - 50);
        p.write(dir + "titled-" + name);
      }
    }
  }
  
  public static void main(String[] args) 
  {
    DirectoryWorker worker = new DirectoryWorker();
    worker.addStringToPictures(
       "c:\\intro-prog-java\\mediasources\\",
       "Copyright 2005");
  }
}