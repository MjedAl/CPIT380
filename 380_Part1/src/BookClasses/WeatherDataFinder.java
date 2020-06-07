package BookClasses;

import java.net.*;
import java.io.*;

/**
 * Class that can find weather data from the internet
 * @author Barb Ericson
 * Copyright 2006
 */
public class WeatherDataFinder
{
  //////////////// fields ////////////////////////////
  
  /** url to use to check the spelling */
  String urlStr = "http://www.ndbc.noaa.gov/Maps/northeast_hist.shtml";
  
  /**
   * Method to find weather data for the given location
   * using the internet
   * @param location the location to look for
   * @return a string with the hottest and coldest date 
   * for this location
   */
  public String getExtremes(String location)
  {
    String seq = "not found";
    String result = "";
    
    try {
      
      // create a url
      URL url = new URL(urlStr);
      String line = null;
      
      // open a buffered reader on the url
      InputStream inStr = url.openStream();
      BufferedReader reader = 
        new BufferedReader(new InputStreamReader(inStr));
      
      // loop till end of file or find sequence
      while ((line = reader.readLine()) != null &&
             line.indexOf(seq) < 0)
      {
        result = "";
      }
    } catch (Exception ex) {
    }
    return result;
  }
  
  /**
   * Method to check the weather for a location by asking
   * the user for a location and showing him/her the result
   */
  public void getExtremes()
  {
    String location = SimpleInput.getString("Enter the location to check.");
    String result = getExtremes(location);
    SimpleOutput.showInformation("The extremes were on " + result);
  }
   
}