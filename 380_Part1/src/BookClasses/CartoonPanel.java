package BookClasses;


/**
 * Class that shows an array of pictures and
 * shows them from left to right in a picture
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class CartoonPanel
{
  /** field that holds the array of pictures */
  private Picture[] pictureArray;
  
  /** field that is the width of the cartoon panel */
  private int width = 640;
  
  /** field that is the amount to scale each picture in x */
  private double xScale;
  
  /** field that is the amount to scale each picture in y */
  private double yScale;
  
  /** field that is the amount of space to leave between pictures */
  private int gap = 5;
  
  /**
   * Constructor that takes an array of pictures
   * @param pictArray the array of pictures
   */
  public CartoonPanel(Picture[] pictArray)
  {
    this.pictureArray = pictArray;
  }
  
  /**
   * Method to calculate the height and x and y scale
   * amounts
   */
  public int calculateHeightAndSetScale()
  {
    int totalWidth = 0;
    int maxHeight = 0;
    int maxWidth = 0;
    
    // loop through all pictures
    for (Picture currPict : pictureArray)
    {
      totalWidth = totalWidth + currPict.getWidth();
      if (currPict.getHeight() > maxHeight)
        maxHeight = currPict.getHeight();
      if (currPict.getWidth() > maxWidth)
        maxWidth = currPict.getWidth();
    }
    
    // add gap to total width
    totalWidth = totalWidth + (pictureArray.length - 1) * gap;
    
    // calculate the scaling factors and height
    xScale = ((double) width) / totalWidth;
    yScale = xScale;
    int height = (int) (yScale * maxHeight);
    return height;
  }
    
  /**
   * method to show the cartoon panel
   */
  public void show()
  {
    
    // calculate the height and x and y scale amounts
    int height = calculateHeightAndSetScale();
    
    // create a new picture of the correct width and height
    Picture p = new Picture(width,height);
    
    // start of curr picture in cartoon panel
    int currX = 0;
    
    // loop through the pictures in the array
    for (Picture currPict : pictureArray)
    {
      currPict = currPict.scale(xScale,yScale);
      p.copy(currPict,currX,0);
      currX = currX + currPict.getWidth() + gap;
    }
    
    // show the picture
    p.show();
  }
  
  /**
   * Method to test the cartoon panel class
   */
  public static void main(String[] args)
  {
    Picture p = new Picture(FileChooser.getMediaPath("church.jpg"));
    Picture p1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
    Picture p2 = new Picture(FileChooser.getMediaPath("eiffel.jpg"));
    Picture[] pictArray = {p,p1,p2};
    CartoonPanel panel = new CartoonPanel(pictArray);
    panel.show();
  }     
}