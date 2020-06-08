package cpit380practice;

import java.net.*;
import java.io.*;
/**
 * Class to grad headlines from news web sites
 * @author Barb Ericson
 * Copyright 2006
 */
public class HeadlineGrabber
{
  //////////////// fields ///////////////////////////
  /** the default start of a headline */
  private String headlineStart = "<h2>";
  /** the default end of a headline */
  private String headlineEnd = "</h2>";
  /** the URL of the CNN web site */
  private String cnnSite = "http://www.cnn.com";
  /** the URL of the Time web site */
  private String timeSite = "http://www.time.com/time/";
  /** the URL of the People web site */
  private String peopleSite = "http://people.aol.com/people/";
  
  ///////////// construcutor ////////////////////////
  
  /**
   * Constructor that takes no arguments
   */
  public HeadlineGrabber() {}
  
  /////////////// methods ////////////////////////////
  
  /**
   * method to get the top headline for the passed site
   * @param urlStr the string URL for the site to check
   * @param startStr the start of the headline
   * @param endStr the end of the headline
   * @return the top headline as a string
   */
  
  public String getTopHeadline(String urlStr, 
                               String startStr, 
                               String endStr)
  {
    try {
      
      // create a url
      URL url = new URL(urlStr);
      String line = null;
      
      // open a buffered reader on the url
      InputStream inStr = url.openStream();
      BufferedReader reader = 
        new BufferedReader(new InputStreamReader(inStr));
      
      // find the headline
      int posStart = 0;
      int posEnd = 0;
      int posGt = 0;
      int posLt = 0;
      while ((line = reader.readLine()) != null)
      {
        // check for start of the headline
        posStart = line.indexOf(startStr);
        if (posStart >= 0)
        {
          posEnd = line.indexOf(endStr,posStart);
          posGt = line.indexOf('>',posStart + 4);
          posLt = line.indexOf('<',posGt);
          return line.substring(posGt + 1, posLt);
        }
      }
    } catch (Exception ex) {
    }
    // if we get here the headline wasn't found
    return "Not Found";
  }
  
  /**
   * method to get the cnn headline
   * @return the headline or "Not Found"
   */
  public String getCNNHeadline()
  {
    return this.getTopHeadline(cnnSite,
                               headlineStart,
                               headlineEnd);
  }
  
  /**
   * method to get the time headline
   * @return the headline or "Not Found"
   */
  public String getTimeHeadline()
  {
    return this.getTopHeadline(timeSite,
                               headlineStart,
                               headlineEnd);
  }
  
   /**
   * method to get the people headline
   * @return the headline or "Not Found"
   */
  public String getPeopleHeadline()
  {
    return this.getTopHeadline(peopleSite,
                               "<h4>",
                               "</h4>");
  }
  
  /**
   * Method for testing
   */
  public static void main(String[] args)
  {
    HeadlineGrabber grabber = new HeadlineGrabber();
    String headline = grabber.getCNNHeadline();
    System.out.println("CNN: " + headline);
    headline = grabber.getTimeHeadline();
    System.out.println("Time: " + headline);
    headline = grabber.getPeopleHeadline();
    System.out.println("People: " + headline);
  }
  
}
    
    