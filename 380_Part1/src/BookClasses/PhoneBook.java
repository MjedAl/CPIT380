package BookClasses;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 * A class that represents a phone book.  This phone 
 * book maps names to phone numbers. This will 
 * read the phone book information from a file.
 */
public class PhoneBook
{
  /////////////////// fields /////////////////////////
  
  private String fileName;
  //private Map phoneMap = new HashMap();
  private Map<String,String> phoneMap = 
    new HashMap<String,String>();
  private Map<String,String> nameMap =
    new HashMap<String,String>();
  //private Map<String,String> phoneMap = 
  //  new TreeMap<String,String>();
  
  ////////////////// constructors ////////////////////
  
  /**
   * Constructor that takes a file name and reads 
   * in the names and phone numbers from a file
   * @param file the name of the file to read
   */
  public PhoneBook(String file) 
  {
    this.fileName = file;
    
    // read the map information in from the file
    readInfoFromFile();
  }
  
  /////////////////// methods /////////////////////
  
  /**
   * Get the phone number for the passed name
   * @param name the name to look up in the map
   * @return the phone number if found, else null
   */
  public String getPhoneNumber(String name) 
  {
    //String phoneNumber = (String) phoneMap.get(name);
    String phoneNumber = phoneMap.get(name);
    return phoneNumber;
  }
  
  /**
   * Method to get the name for a phone number
   * @param number the phone number to lookup
   * @return the name if found else null
   */
  public String getName(String number)
  {
    return nameMap.get(number);
  }
  
  /**
   * Method to read the phone information from a 
   * file and use it to fill the map
   */
  public void readInfoFromFile()
  {
    String line = null;
    String[] phoneArray = null;
    
    try {
      
      // create the reader
      BufferedReader reader =
        new BufferedReader(new FileReader(this.fileName));
      
      // loop reading from the file
      while ((line = reader.readLine()) != null)
      {
        if (line.indexOf(":") >= 0)
        {
          phoneArray = line.split(":");
          String name = phoneArray[0].trim();
          String number = phoneArray[1].trim();
          phoneMap.put(name,number);
          nameMap.put(number,name);
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
   * Method to print out the contents of the phone book
   */
  public void printBook()
  {
    // get the set of keys
    Set keySet = phoneMap.keySet();
    String key = null;
    
    // loop through the keys
    Iterator iterator = keySet.iterator();
    while (iterator.hasNext())
    {
      key = (String) iterator.next();
      System.out.println("Name: " + key + 
                         ", Phone number: " + 
                         phoneMap.get(key));
    }
  }
  
  /* main for testing */
  public static void main(String[] args)
  {
    PhoneBook phoneBook = 
      new PhoneBook(FileChooser.getMediaPath("barbsPhoneBook.txt"));
    //System.out.println(phoneBook.getPhoneNumber("Shayna"));
    //System.out.println(phoneBook.getPhoneNumber("Dentist"));
    phoneBook.printBook();
    System.out.println(phoneBook.getName("555 321-3927"));
  }
  
}