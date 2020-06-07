//package AhmadClassCPIT380;
package BookClasses;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Class that can find the popularity of a baby name in 
 * a file
 * @author Barb Ericson
 * Copyright 2006
 */
public class BabyNameFinder
{
  //////////////// fields ////////////////////////////
  /** constant for female pos in row*/
  public static final int FEMALE = 2;
  /** constant for male pos in row */
  public static final int MALE = 1;
  /** file name */
  private String fileName = 
    FileChooser.getMediaPath("babyNames1961.txt");
  
  /////////////// constructors ////////////////////////
  
  /**
   * Constructor that takes no arguments
   */
  public BabyNameFinder()
  {}
  
  /**
   * Constructor that takes a file name 
   * @param theFileName the name of the file
   */
  public BabyNameFinder(String theFileName)
  {
    this.fileName = theFileName;
  }
  
  ///////////////////// methods //////////////////////
  
  /**
   * Method to return a list of items between each <td>
   * and </td>
   * @param row the row of the table
   * @return a list of strings with the items in the columns
   */
  public List<String> getItemsInRow(String row)
  {
    List<String> itemList = new ArrayList<String>();
    int start = row.indexOf("<td>");
    int end = 0;
    while (start >= 0)
    {
      end = row.indexOf("</td>");
      itemList.add(row.substring(start + 4, end));
      row = row.substring(end + 5);
      start = row.indexOf("<td>");
    }
    return itemList;
  } 
  
  /**
   * Method to find the baby name and gender and return
   * the popularity
   * @param name the name you are looking for
   * @param gender the gender you are looking for
   * @return a string with the popularity or not found
   */
  public String getPopularity(String name, int gender)
  {
    String popularity = "Not Found!";
    String line = null;
    String row = "";
    
    // try the following
    try {
      
      // read from the file
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      // loop till end of file or find sequence
      boolean notFound = true;
      List<String> itemList = null;
      String genderName = null;
      while ((line = reader.readLine()) != null && notFound)
      {
        if (line.indexOf("<tr align=\"right\">") >= 0)
        {
          
          // check if the name is in this row
          if (row.indexOf(name) >= 0)
          {
            itemList = getItemsInRow(row);
            if (itemList.size() > gender)
            {
              genderName = itemList.get(gender);
              if (genderName.equals(name))
                notFound = false;
            }
          }
          // reset the row
          row = "";
        }
        else
          row = row + line;
      }
      
      // if we found the name for the gender
      if (!notFound)
      {
        popularity = itemList.get(0);
      }
    } catch (FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find file " + fileName);
      this.fileName = FileChooser.pickAFile();
      popularity = getPopularity(name,gender);
    } catch (Exception ex) {
      SimpleOutput.showError("Error during read or write");
      ex.printStackTrace();
    } 
    return popularity;
  }
  
  public static void main(String[] args)
  {
    BabyNameFinder finder = new BabyNameFinder();
    String name = "Barbara";
    int gender = FEMALE;
    String popularity = finder.getPopularity(name,gender);
    String genderStr = null;
    if (gender == MALE)
      genderStr = "male";
    else
      genderStr = "female";
    System.out.println(name + ": " + genderStr + ": " + popularity);
  }
 
}