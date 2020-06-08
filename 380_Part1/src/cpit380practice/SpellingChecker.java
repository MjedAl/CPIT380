package cpit380practice;

import java.net.*;
import java.io.*;

/**
 * Class that can check spelling
 * @author Barb Ericson
 * Copyright 2006
 */
public class SpellingChecker
{
  //////////////// fields ////////////////////////////
  
  /** url to use to check the spelling */
  String urlStr = "http://www.dictionary.com/search?q=";
  
  /**
   * Method to check the spelling of the passed word
   * using the internet
   * @param word the word to check
   * @return true if spelled correctly else false
   */
  public boolean checkSpelling(String word)
  {
    boolean result = true;
    String seq = "No results found";
    
    try {
      
      // create a url
      URL url = new URL(urlStr + word);
      String line = null;
      
      // open a buffered reader on the url
      InputStream inStr = url.openStream();
      BufferedReader reader = 
        new BufferedReader(new InputStreamReader(inStr));
      
      // loop till end of file or find sequence
      while ((line = reader.readLine()) != null)
      {
        // check for seq
        if (line.indexOf(seq) >= 0)
        {
          return false;
        }
      }
    } catch (Exception ex) {
    }
    // if we get here it is spelled okay
    return result;
  }
  
  /**
   * Method to check the spelling by asking the user for a word and
   * telling them the result
   */
  public void checkSpelling()
  {
    String word = SimpleInput.getString("Enter the word to check.");
    if (checkSpelling(word))
      SimpleOutput.showInformation("The word " + word + " is spelled correctly");
    else
      SimpleOutput.showInformation("The word " + word + " is not spelled correctly");
  }
  
  public static void main(String[] args)
  {
    SpellingChecker checker = new SpellingChecker();
    checker.checkSpelling();
  }
   
}