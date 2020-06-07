package BookClasses;

/**
 * Class that represents a slide show.  A slide show has
 *  an array of pictures, a time to wait between pictures,
 *  and a title that is shown at the beginning of the show.
 * 
 * @author Barb Ericson 
 */
public class SlideShow
{
  ///////////// fields //////////////
  private Picture[] pictureArray;
  private int waitTime = 2000;
  private String title;
  
  ///////////// constructors /////////
  
  /**
   * A no-argument constructor that takes
   * no parameters and leaves fields with their 
   * default values
   */
  public SlideShow()
  {}
  
  /**
   * Constructor that takes the array of
   * pictures
   * @param pictArray the array of pictures
   */
  public SlideShow(Picture[] pictArray)
  {
    this.pictureArray = pictArray;
  }
  
   
  /**
   * A constructor that takes the array of 
   * pictures and a title
   * @param pictArray the array of pictures
   * @param theTitle the title to use
   */
  public SlideShow(Picture[] pictArray,
                   String theTitle)
  {
    this.pictureArray = pictArray;
    this.title = theTitle;
  }
  
  /**
   * Constructor that takes the array of
   * pictures, the wait time, and the title
   * @param pictArray the array of pictures
   * @param time the time to wait between 
   * pictures in milliseconds
   * @param theTitle the title for the window
   */
  public SlideShow(Picture[] pictArray,
                   int time,
                   String theTitle)
  {
    this.pictureArray = pictArray;
    this.waitTime = time;
    this.title = theTitle;
  }
  
  ////////////////// methods ////////////////
  
  /**
   * Method to show the slide show information
   * in a string (the number of pictures 
   * and the wait time)
   */
  public String toString()
  {
    String result = "A slide show ";
    if (this.title != null) 
      result = result + "titled: " + this.title;
    if (this.pictureArray != null)
      result = result + " with " + 
               this.pictureArray.length + 
               " slides ";
    result = result + 
      "a wait time of " + this.waitTime;
    return result;
  }
  
  /**
   * Method to get the wait time
   * @return the time to wait between pictures
   */
  public int getWaitTime()
  {
    return this.waitTime;
  }
  
  /** 
   * Method to get a picture at an index
   * in the array of pictures
   * @param index the index to use
   * @return the picture at the index
   */
  public Picture getPicture(int index)
  {
    Picture pict = null;
    if (this.pictureArray != null &&
        index < this.pictureArray.length)
    {
      pict = this.pictureArray[index];
    }
    return pict;
  }
  
  /**
   * Method to set the array of pictures
   * @param pictArray the array to use
   * @return true if success else false
   */
  public boolean setPictureArray(Picture[] pictArray)
  {
    boolean result = false;
    if (this.pictureArray == null)
    {
      this.pictureArray = pictArray;
      result = true;
    }
    return result;
  }
  
  /**
   * Method to change the time to wait
   * between pictures
   * @param time the new time to use
   * in milliseconds
   */
  public void setWaitTime(int time)
  {
    if (time >= 0)
       this.waitTime = time;
  }
       
  /**
   * Method to show the slide show
   */
  public void show() throws Exception
  {
    // check that the picture array isn't null
    if (pictureArray != null)
    {
      
      // if the title isn't null show it
      if (title != null)
      {
        Picture titleP = new Picture(640,480);
        titleP.drawHorizontalCenteredString(title,240);
        titleP.show();
        Thread.sleep(this.waitTime);
        titleP.hide();
      }
      
      /** Loop through the pictures */
      for (Picture currPict : this.pictureArray)
      {
        currPict.show();
        Thread.sleep(waitTime);
        currPict.hide();
      }
    }
  }
  
  /** 
   * Main method for testing 
   */
  public static void main(String[] args) throws Exception
  {
    Picture[] pictArray = new Picture[5];
    pictArray[0] = new Picture(FileChooser.getMediaPath("beach.jpg"));
    pictArray[1] = new Picture(FileChooser.getMediaPath("blueShrub.jpg"));
    pictArray[2] = new Picture(FileChooser.getMediaPath("church.jpg"));
    pictArray[3] = new Picture(FileChooser.getMediaPath("eiffel.jpg"));
    pictArray[4] = new Picture(FileChooser.getMediaPath("greece.jpg"));
    SlideShow vacShow = new SlideShow(pictArray,"Vacation Slides");
    vacShow.show();
  }
}
    
    