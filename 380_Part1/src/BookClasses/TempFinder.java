package BookClasses;

import java.io.*;
import java.net.URL;

/**
 * Class to find the temperature in a web page.
 * @author Barb Ericson
 */
public class TempFinder
{
  
  /**
   * Method to find the temperature in the passed
   * file 
   * @param fileName the name of the file to look in
   */
  public String getTemp(String fileName)
  {
    String seq = "<b>&deg";
    String temp = null;
    String line = null;
    
    // try the following
    try {
      
      // read from the file
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      // loop till end of file or find sequence
      while ((line = reader.readLine()) != null &&
             line.indexOf(seq) < 0)
      {}
      
      // if there is a current line
      if (line != null)
      {
        // find the temperature
        int degreeIndex = line.indexOf(seq);
        int startIndex = line.lastIndexOf('>',degreeIndex);
        temp = line.substring(startIndex + 1, degreeIndex);
      }
      
    } catch (FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't find file " + fileName);
      fileName = FileChooser.pickAFile();
      temp = getTemp(fileName);
    } catch (Exception ex) {
      SimpleOutput.showError("Error during read or write");
      ex.printStackTrace();
    } 
    return temp;
  }
  
  /**
   * Method to get the temperature from a network
   * @param urlStr the url as a string
   * @return the temperature as a string
   */
  public String getTempFromNetwork(String urlStr)
  {
    String temp = null;
    String line = null;
    String seq = "&ordm";
    
    try {
      
      // create a url
      URL url = new URL(urlStr);
      
      // open a buffered reader on the url
      InputStream inStr = url.openStream();
      BufferedReader reader = 
        new BufferedReader(new InputStreamReader(inStr));
      
      // loop till end of file or find sequence
      while ((line = reader.readLine()) != null &&
             line.indexOf(seq) < 0)
      {}
      
      // if there is a current line
      if (line != null)
      {
        // find the temperature
        int degreeIndex = line.indexOf(seq);
        int startIndex = line.lastIndexOf('>',degreeIndex);
        temp = line.substring(startIndex + 1, degreeIndex);
      }
      
    } catch (FileNotFoundException ex) {
      SimpleOutput.showError("Couldn't connect to " + urlStr);
    } catch (Exception ex) {
      SimpleOutput.showError("Error during read or write");
      ex.printStackTrace();
    } 
    return temp;
  }
  
  public static void main(String[] args)
  {
    TempFinder finder = new TempFinder();
    String file = FileChooser.getMediaPath("ajc-weather.html");
    String temp = finder.getTemp(file);
    if (temp == null)
      System.out.println("Sorry, no temp was found in " + file);
    else
      System.out.println("The current temperature is " + temp);
    String urlString = "http://www.ajc.com/";
    temp = finder.getTempFromNetwork(urlString);
    if (temp == null)
      System.out.println("Sorry, no temp was found at " + 
                         urlString);
    else
      System.out.println("The current temp " +
                         "from the network is " + temp);
  }
}