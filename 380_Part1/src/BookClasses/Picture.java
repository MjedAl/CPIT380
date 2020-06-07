//package AhmadClassCPIT380;
package BookClasses;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors /////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to 
     * super() child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a width and height for a new
   * picture and sets the color for the new picture
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   * @param theColor the color for the background
   */
  public Picture(int width, int height, Color theColor)
  {
    // let the parent class handle these parameters
    super(width,height,theColor);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods /////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as 
   * fileName, height, and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + this.getFileName() + 
      " height " + this.getHeight() 
      + " width " + this.getWidth();
    return output;
    
  }
  
  /**
   * Method to allow the user to pick a file name and show a picture. 
   * This method will also return the created picture object.
   * @return the picture object created from the picked file name
   */
  public static Picture pickAndShow()
  {
    String fileName = FileChooser.pickAFile();
    Picture picture = new Picture(fileName);
    picture.show();
    return picture;
  }
  
  /**
   * Method to show a specific picture where the file name to show
   * is specified in the method.  To change which picture you want 
   * to show you can edit the method and recompile it.
   * @return the created picture object
   */
  public static Picture showSpecificPicture()
  {
    String myFile = "C:/intro-prog-java/mediasources/katie.jpg";
    Picture myPicture = new Picture(myFile);
    myPicture.show();
    return myPicture;
  }
  
  /**
   * Method to show a picture created from a passed file name
   * @param fileName the name of the file to create the picture from
   * @return the created picture object
   */
  public static Picture showNamed(String fileName)
  {
    Picture myPicture = new Picture(fileName);
    myPicture.show();
    return myPicture;
  }
  
  /**
   * Method to decrease the red by half in a copy of the 
   * current picture
   * @return a copy of the current picture with the red
   * decreased by half
   */
  public Picture decreaseRedI()
  {
    Picture copyPicture = new Picture(this);
    Pixel[] pixelArray = copyPicture.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;

    // loop through all the pixels
    while(index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // get the value
      value = pixel.getRed();
      
      // decrease the red value by 50% (1/2)
      value = (int) (value * 0.5);

      // set the red value of the current pixel to the new value
      pixel.setRed(value);
      
      // increment the index
      index = index + 1;
    }
    
    // return the copy
    return copyPicture;
  }
  
  /**
   * Method to decrease the red by half in the current picture
   */
  public void decreaseRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;

    // loop through all the pixels
    while(index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // get the value
      value = pixel.getRed();

      // decrease the red value by 50% (1/2)
      value = (int) (value * 0.5);

      // set the red value of the current pixel to the new value
      pixel.setRed(value);

      // increment the index
      index = index + 1;
    }
  }
  
  /**
   * A method to decrease red by 10 percent
   */
  public void decreaseRed10P()
  {
    Pixel[] pixelArray = this.getPixels();
    int red = 0;
    
    // loop through all the pixels
    for (Pixel currPixel : pixelArray)
    {
      red = currPixel.getRed();
      currPixel.setRed((int) (red * 0.9));
    }   
  }
  
  /**
   * A method to decrease red by 20 percent
   */
  public void decreaseRed20P()
  {
    Pixel[] pixelArray = this.getPixels();
    int red = 0;
    
    // loop through all the pixels
    for (Pixel currPixel : pixelArray)
    {
      red = currPixel.getRed();
      currPixel.setRed((int) (red * 0.8));
    }   
  }
  
  /**
   * Method to decrease red by the passed
   * percent
   * @param percent the percent to reduce by
   */
  public void decreaseRed(int percent)
  {
    Pixel[] pixelArray = this.getPixels();
    int red = 0;
    double factor = 1.0 - (percent / 10);
    
    // loop through all the pixels
    for (Pixel currPixel : pixelArray)
    {
      red = currPixel.getRed();
      currPixel.setRed((int) (red * factor));
    }   
  }
  
  /**
   * Method to set the red to the blue value
   */
  public void setRedToBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int index = 0;

    // loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // change the red value to the blue value
      pixel.setRed(pixel.getBlue());

      // increment the index
      index++;
    }
  }

  /**
   * Method to change the red and green values in the
   * current picture
   * @param redMult the amount to multiply the red by
   * @param greenMult the amount to multiply the green by
   */
  public void changeRedAndGreen(double redMult,
                                double greenMult)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;

    // loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // change the red value
      value = pixel.getRed();
      pixel.setRed((int) (value * redMult));
      
      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (value * greenMult));

      // increment the index
      index++;
    }
  }
  
  /**
   * Method to increase the amount of red by 30%
   */
  public void increaseRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;

    // loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // get the value
      value = pixel.getRed();

      // change the value to 1.3 times what it was
      value = (int) (value * 1.3);

      // set the red value to 1.3 times what it was
      pixel.setRed(value);

      // increment the index
      index++;
    }
  }
  
  /**
   * Method to clear the blue from the picture (set
   * the blue to 0 for all pixels)
   */
  public void clearBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int index = 0;

    // loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // set the blue on the pixel to 0
      pixel.setBlue(0);

      // increment index
      index++;
    }
  }
  
  /**
   * Method to clear the red from a picture
   */
  public void clearRed()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setRed(0);
    }
  }
  
  /**
   * Method to clear the green from a picture
   */
  public void clearGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setGreen(0);
    }
  }
  
  /**
   * Method to keep only the red in a picture
   */
  public void keepRed()
  {
    Pixel[] pixelArray = this.getPixels();
    int red = 0;
    for (Pixel currPixel : pixelArray)
    {
      red = currPixel.getRed();
      currPixel.setColor(new Color(red, 0, 0));
    }
  }
  
  /**
   * Method to keep only the green in a picture
   */
  public void keepGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    int value = 0;
    for (Pixel currPixel : pixelArray)
    {
      value = currPixel.getGreen();
      currPixel.setColor(new Color(0, value, 0));
    }
  }
  
  /**
   * Method to keep only the blue in a picture
   */
  public void keepBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    int value = 0;
    for (Pixel currPixel : pixelArray)
    {
      value = currPixel.getGreen();
      currPixel.setColor(new Color(0, 0, value));
    }
  }
  
  /**
   * Method to maximize the red in a picture
   */
  public void maxRed()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setRed(255);
    }
  }
  
   /**
   * Method to maximize the green in a picture
   */
  public void maxGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setGreen(255);
    }
  }
  
   /**
   * Method to maximize the blue in a picture
   */
  public void maxBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setBlue(255);
    }
  }
  
  /**
   * Method to simulate a sunset by decreasing the green
   * and blue
   */
  public void makeSunset()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (value * 0.7));

      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (value * 0.7));

      // increment the index
      i++;
    }
  }
  
  /**
   * Method to simulate a sunset by decreasing the green
   * and blue
   * @param factor the amount to multiply the original values by
   */
  public void makeSunset(double factor)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (value * factor));

      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (value * factor));

      // increment the index
      i++;
    }
  }
  
  /**
   * Method to decrease the green in the picture by 30%
   */
  public void decreaseGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels in the array
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the value
      value = pixel.getGreen();

      // set the green value to 70% of what it was
      pixel.setGreen((int) (value * 0.7));

      // increment the index
      i++;
    }
  }

  /**
   * Method to decrease the blue in the picture by 30%
   */
  public void decreaseBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels in the array
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the value
      value = pixel.getBlue();

      // set the blue value to 70% of what it was
      pixel.setBlue((int) (value * 0.7));
    }
  }

  /**
   * Method to make a picture look like it was taken at sunset
   * by reducing the blue and green to make it look more red
   */
  public void makeSunset2()
  {
    decreaseGreen();
    decreaseBlue();
  }
  
  /**
   * Method to change the red by an amount
   * @param amount the amount to change the red by
   */
  public void changeRed(double amount)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels
    while( i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the value
      value = pixel.getRed();

      /* set the red value to the original value
      * times the passed amount
      */
      pixel.setRed((int) (value * amount));

      // increment i
      i++;
    }
  }
  
  /**
   * Method to change the color of each pixel in the picture
   * object by passed in amounts.
   * @param redAmount the amount to change the red value
   * @param greenAmount the amount to change the green value
   * @param blueAmount the amount to change the blue value
   */
  public void changeColors(double redAmount,
                           double greenAmount,
                           double blueAmount)
  {
    Pixel[] pixelArray = this.getPixels();
    int value = 0;

    // loop through all the pixels
    for (Pixel pixel : pixelArray)
    {

      // change the red value
      value = pixel.getRed();
      pixel.setRed((int) (redAmount * value));

      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (greenAmount * value));

      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (blueAmount * value));
    }
  }
  
  /**
   * Method to clear the blue from the picture (set
   * the blue to 0 for all pixels)
   */
  public void clearBlue2()
  {
    Pixel[] pixelArray = this.getPixels();
    int i = 0;

    // loop through all the pixels
    while(i < pixelArray.length)
    {
        pixelArray[i].setBlue(0);
        i++;
    }
  }
  
  /**
   * Method to clear the blue from the picture (set
   * the blue to 0 for all pixels)
   */
  public void clearBlue3()
  {
    Pixel[] pixelArray = this.getPixels();

    // loop through all the pixels
    for (int i=0; i < pixelArray.length; i++)
        pixelArray[i].setBlue(0);
  }
  
   /**
   * Method to clear the blue from the picture (set
   * the blue to 0 for all pixels) using a for-each
   * loop
   */
  public void clearBlueForEach()
  {
    Pixel[] pixelArray = this.getPixels();

    // loop through all the pixels
    for (Pixel currPixel : pixelArray)
        currPixel.setBlue(0);
  }
  
  /**
   * Method to darken the color in the picture
   */
  public void darken()
  {
    Pixel[] pixelArray = this.getPixels();
    Color color = null;
    Pixel pixel = null;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the current color
      color = pixel.getColor();

      // get a darker color
      color = color.darker();

      // set the pixel color to the darker color
      pixel.setColor(color);
    }
   }
  
 
  
  /**
   * Method to negate the picture using 
   * a nested loop
   */
  public void negateNested()
  {
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;
    
    // loop through all the pixels
    for (int x = 0; x < this.getWidth(); x++)
    {
      for(int y = 0; y < this.getHeight(); y++)
      {
        // get the current pixel
        pixel = this.getPixel(x,y);
        
        // get the current red, green, and blue values
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        // set the pixel's color to the new color
        pixel.setColor(new Color(255 - redValue,
                                 255 - greenValue,
                                 255 - blueValue));
      }
    }
  }
  
  /**
   * Method to negate the pixels in the 
   * current picture
   */
  public void negate()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the current red, green, and blue values
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();

      // set the pixel's color to the new color
      pixel.setColor(new Color(255 - redValue,
                               255 - greenValue,
                               255 - blueValue));
    }
  }
  
  
  /**
   * Method to change the picture to gray scale
   */
  public void grayscale()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int intensity = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // compute the intensity of the pixel (average value)
      intensity = (int) ((pixel.getRed() + pixel.getGreen() +
                     pixel.getBlue()) / 3);

      // set the pixel color to the new color
      pixel.setColor(new Color(intensity,intensity,intensity));

    }
  }
  
  /**
   * Method to change the picture to gray scale
   */
  public void grayscale(int startX, int startY,
                        int endX, int endY)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int intensity = 0;
    
    // loop through x
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        
        // get the current pixel
        pixel = this.getPixel(x,y);
        
        // compute the intensity of the pixel (average value)
        intensity = (int) ((pixel.getRed() + pixel.getGreen() +
                            pixel.getBlue()) / 3);
        
        // set the pixel color to the new color
        pixel.setColor(new Color(intensity,intensity,intensity));
        
      }
    }
  }
  
  
  /**
   * Method to change the picture to gray scale with luminance
   */
  public void grayscaleWithLuminance()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int luminance = 0;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the corrected red, green, and blue values
      redValue = pixel.getRed() * 0.299;
      greenValue = pixel.getGreen() * 0.587;
      blueValue = pixel.getBlue() * 0.114;

      // compute the intensity of the pixel (average value)
      luminance = (int) (redValue + greenValue + blueValue);

      // set the pixel color to the new color
      pixel.setColor(new Color(luminance,luminance,luminance));

    }
  }
  
  
  /**
   * Method to increase the amount of red by 1.3 in 
   * the current picture
   */
  public void increaseRed2()
  {
    Pixel[] pixelArray = this.getPixels();

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // set the red value to 1.3 times what it was
      pixelArray[i].setRed((int) (pixelArray[i].getRed() * 1.3));
    }
  }
  
  
 
   /**
   * Method to increase the amount of red by 1.3
   * in the current picture
   */
  public void increaseRed3()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int red = 0;
    int green = 0;
    int blue = 0;
    int newRed = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the color values
      red = pixel.getRed();
      green = pixel.getGreen();
      blue = pixel.getBlue();

      // calculate the new red value
      newRed = (int) (red * 1.3);

      // set the pixel color to the new color
      pixel.setColor(new Color(newRed,green,blue));
    }
  }
  
  
  /**
   * Method to lighten the colors in the picture
   */
  public void lighten()
  {
    Pixel pixel = null;
    Color color = null;

    // loop through the columns (x direction)
    for (int x = 0; x < getWidth(); x++)
    {
      // loop through the rows (y direction)
      for (int y = 0; y < getHeight(); y++)
      {
        // get pixel at the x and y location
        pixel = getPixel(x,y);

        // get the current color
        color = pixel.getColor();

        // get a lighter color
        color = color.brighter();

        // set the pixel color to the lighter color
        pixel.setColor(color);
      }
    }
   }
  
  /**
   * Method to lighten the colors in the picture if
   * the distance to the passed color is within the
   * passed distance
   * @param compColor the color to compare to
   * @param distance the distance from the compare color
   * @param numTimes the number of times to lighten 
   */
  public void lighten(Color compColor, double distance, 
                        int numTimes)
  {
    Pixel pixel = null;
    Color color = null;

    // loop through the columns (x direction)
    for (int x = 0; x < getWidth(); x++)
    {
      // loop through the rows (y direction)
      for (int y = 0; y < getHeight(); y++)
      {
        // get pixel at the x and y location
        pixel = getPixel(x,y);

        // get the distance to the passed color
        double colorDist = pixel.colorDistance(compColor);
        
        /* if the color distance is less than or equal to
         * the passed distance then lighten the pixel
         */
        if (colorDist <= distance)
        {
          color = pixel.getColor();
          for (int i = 0; i < numTimes; i++)
             color.brighter();
          pixel.setColor(color);
        }
      }
    }
   }
  
 /**
  * Method to mirror around a vertical line in the middle
  * of the picture based on the width
  */
 public void mirrorVertical()
 {
   int width = this.getWidth();
   int mirrorPoint = width / 2;
   Pixel leftPixel = null;
   Pixel rightPixel = null;

   // loop through all the rows
   for (int y = 0; y < getHeight(); y++)
   {
     // loop from 0 to the middle (mirror point)
     for (int x = 0; x < mirrorPoint; x++)
     {
       leftPixel = getPixel(x, y);
       rightPixel = getPixel(width - 1 - x, y);
       rightPixel.setColor(leftPixel.getColor());
     }
   }
 }
 
 /**
  * Method to mirror around a vertical line at the 
  * end of the picture based on the width
  */
 public Picture mirrorAllVertical()
 {
   int resWidth = this.getWidth() * 2;
   Picture result = new Picture(resWidth,
                                this.getHeight());
   int mirrorPoint = this.getWidth();
   Pixel leftPixel = null;
   Pixel rightPixel = null;

   // loop through all the rows
   for (int y = 0; y < getHeight(); y++)
   {
     // loop from 0 to the mirror point
     for (int x = 0; x < mirrorPoint; x++)
     {
       leftPixel = getPixel(x, y);
       rightPixel = result.getPixel(x,y);
       rightPixel.setColor(leftPixel.getColor());
       rightPixel = result.getPixel(resWidth - 1 - x, y);
       rightPixel.setColor(leftPixel.getColor());
     }
   }
   return result;
 }
 
 /**
  * Method to mirror around a horizontal line at the 
  * end of the picture based on the height
  */
 public Picture mirrorAllHorizontal()
 {
   int resHeight = this.getHeight() * 2;
   Picture result = new Picture(this.getWidth(),
                                resHeight);
   int mirrorPoint = this.getHeight();
   Pixel topPixel = null;
   Pixel bottomPixel = null;

   // loop through all the rows
   for (int y = 0; y < mirrorPoint; y++)
   {
     // loop from 0 to the mirror point
     for (int x = 0; x < this.getWidth(); x++)
     {
       topPixel = getPixel(x, y);
       bottomPixel = result.getPixel(x,y);
       bottomPixel.setColor(topPixel.getColor());
       bottomPixel = result.getPixel(x,resHeight - 1 - y);
       bottomPixel.setColor(topPixel.getColor());
     }
   }
   return result;
 }
  
 /**
  * Method to mirror around a horizontal line in the middle
  * based on the height.  It copies the top mirrored to
  * the bottom
  */
 public void mirrorHorizontal()
 {
   int height = this.getHeight();
   int mirrorPoint = height / 2;
   Pixel topPixel = null;
   Pixel bottomPixel = null;

   // loop through the columns
   for (int x=0; x < getWidth(); x++)
   {
     // loop from 0 to just before the mirror point
     for (int y=0; y < mirrorPoint; y++)
     {
       topPixel = getPixel(x,y);
       bottomPixel = getPixel(x,height - 1 - y);
       bottomPixel.setColor(topPixel.getColor());
     }
   }
 }
 
  /**
   * Method to mirror around a horiztonal line in the middle
   * based on the height of the picture.  It copies the bottom
   * to the top.
   */
  public void mirrorHorizontalBottomToTop()
  {
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;

    // loop through the columns
    for (int x=0; x < getWidth(); x++)
    {
      // loop from 1 to just before the mirror point
      for (int y=0; y < mirrorPoint; y++)
      {
        topPixel = getPixel(x,y);
        bottomPixel = getPixel(x,height - 1 - y);
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }
  
  /**
   * Mirror diagonal from 0,0 to width-1,height-1
   */
  public void mirrorDiagTopLeftBotRight()
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    for (int y = 1; y < this.getHeight(); y++)
    {
      for (int x = 0; x < y; x++)
      {
        leftPixel = this.getPixel(x,y);
        rightPixel = this.getPixel(y,x);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /**
   * Method to mirror around a diagonal line
   * from width-1,0 to 0,height-1
   */
  public void mirrorDiagTopRightBotLeft()
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int height = this.getHeight();
    for (int y = height - 2; y >= 0; y--)
    {
      for (int x = 0; x < height - 1 -y; x++)
      {
        leftPixel = this.getPixel(x,y);
        rightPixel = this.getPixel(height-1-y,
                                   height - 1- x);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
 
 /**
  * Method to mirror part of the temple picture around a 
  * vertical line at a mirror point
  */
 public void mirrorTemple()
 {
   int mirrorPoint = 276;
   Pixel leftPixel = null;
   Pixel rightPixel = null;
   int count = 0;

   // loop through the rows
   for (int y = 27; y < 97; y++)
   {
     // loop from 13 to just before the mirror point
     for (int x = 13; x < mirrorPoint; x++)
     {
       System.out.println("Copying color from " +
                         x + " to " +
                         (mirrorPoint + (mirrorPoint - x)));
       leftPixel = getPixel(x, y);       
       rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
       rightPixel.setColor(leftPixel.getColor());
       count = count + 1;
     }
   }
   System.out.println("We copied " + count + " pixels");
 }
 
 /**
  * Method to mirror part of the temple picture around a 
  * vertical line at a mirror point
  */
 public void mirrorHorizontalRange(int startX, 
                                   int endX,
                                   int startY,
                                   int endY,
                                   int mirrorX)
 {
   Pixel leftPixel = null;
   Pixel rightPixel = null;

   // loop through the rows
   for (int y = startY; y < endY; y++)
   {
     // loop from startX to just before the 
     // mirror point: endX
     for (int x = startX; x < endX; x++)
     {
       leftPixel = getPixel(x, y);       
       rightPixel = getPixel(mirrorX + (mirrorX - x), y);
       rightPixel.setColor(leftPixel.getColor());
     }
   }
 }
 
 /**
  * Method to mirror part of the picture around a 
  * horiztonal mirror 
  * @param startX the start x of the range to mirror
  * @param endX the end x of the range to mirror
  * @param mirrorPoint the y value to mirror around
  */
 public void mirrorHorizRange(int startX,int endX,
                              int mirrorPoint)
 {
   Pixel topPixel = null;
   Pixel botPixel = null;
   int count = 0;

   // loop through the rows till the mirror point
   for (int y = 0; y < mirrorPoint; y++)
   {
     // loop from start to end of x range
     for (int x = startX; x < endX; x++)
     {
     
       topPixel = this.getPixel(x, y);       
       botPixel = this.getPixel(x,
                        this.getHeight() - 1 - y);
       botPixel.setColor(topPixel.getColor());
     }
   }
 }
 
 /**
  * Method to mirror part of a picture around
  * a vertical mirror point
  */
 public Picture mirrorVertRange(int mirrorPoint)
 {
   Pixel left = null;
   Pixel right = null;
   int resultWidth = (mirrorPoint + 1) * 2;
   Picture result = 
     new Picture(resultWidth,this.getHeight());
   Color resColor = null;
   
   for (int x =0; x <= mirrorPoint; x++)
   {
     for(int y = 0; y < this.getHeight(); y++)
     {
       left = this.getPixel(x,y);
       right = result.getPixel(resultWidth - 1 - x,y);
       resColor = left.getColor();
       right.setColor(resColor);
       result.getPixel(x,y).setColor(resColor);
     }
   }
   return result;
 }
 
 /**
  * Method to blend two pictures horizontally
  * with 10% of first, 80 percent overlap of 
  * first and second, and last 10 percent of 2nd
  */
 public void blendPictures108010()
 {
   Picture p1 = 
     new Picture(FileChooser.getMediaPath("church.jpg"));
   Picture p2 = 
     new Picture(FileChooser.getMediaPath("eiffel.jpg"));
   Pixel source1 = null;
   Pixel source2 = null;
   Pixel target = null;
   
   // copy the first 10% of p1 
   int end1 = (int) (p1.getWidth() * 0.10);
   for (int x = 0; x < end1; x++)
   {
     for(int y = 0; y < p1.getHeight(); y++)
     {
       source1 = p1.getPixel(x,y);
       target = this.getPixel(x,y);
       target.setColor(source1.getColor());
     }
   }
   
   // now blend p1 and p2 for 80% of p1
   int end2 = (int) (p1.getWidth() * 0.9);
   for (int x = end1; x < end2; x++)
   {
     for(int y = 0; y < p1.getHeight(); y++)
     {
       source1 = p1.getPixel(x,y);
       source2 = p2.getPixel(x,y);
       target = this.getPixel(x,y);
       target.setColor(new Color(source1.getRed() / 2 +
                                 source2.getRed() / 2,
                                 source1.getGreen() / 2 +
                                 source2.getGreen() / 2,
                                 source1.getBlue() / 2 +
                                 source2.getBlue() / 2));
     }
   }
   
   // copy last 10% of p2
   for (int x = end2; x < p2.getWidth(); x++)
   {
     for (int y = 0; y < p2.getHeight(); y++)
     {
       source2 = p2.getPixel(x,y);
       target = this.getPixel(x,y);
       target.setColor(source2.getColor());
     }
   }
 }
 
 /**
  * Method to blend two pictures horizontally
  * with 20% of first, 60% overlap of 
  * first and second, and last 20% of 2nd
  */
 public void blendPictures206020()
 {
   Picture p1 = 
     new Picture(FileChooser.getMediaPath("church.jpg"));
   Picture p2 = 
     new Picture(FileChooser.getMediaPath("eiffel.jpg"));
   Pixel source1 = null;
   Pixel source2 = null;
   Pixel target = null;
   
   // copy the first 20% of p1 
   int end1 = (int) (p1.getWidth() * 0.20);
   for (int x = 0; x < end1; x++)
   {
     for(int y = 0; y < p1.getHeight(); y++)
     {
       source1 = p1.getPixel(x,y);
       target = this.getPixel(x,y);
       target.setColor(source1.getColor());
     }
   }
   
   // now blend p1 and p2 for 60% of p1
   int end2 = (int) (p1.getWidth() * 0.8);
   for (int x = end1; x < end2; x++)
   {
     for(int y = 0; y < p1.getHeight(); y++)
     {
       source1 = p1.getPixel(x,y);
       source2 = p2.getPixel(x,y);
       target = this.getPixel(x,y);
       target.setColor(new Color(source1.getRed() / 2 +
                                 source2.getRed() / 2,
                                 source1.getGreen() / 2 +
                                 source2.getGreen() / 2,
                                 source1.getBlue() / 2 +
                                 source2.getBlue() / 2));
     }
   }
   
   // copy last 20% of p2
   for (int x = end2; x < p2.getWidth(); x++)
   {
     for (int y = 0; y < p2.getHeight(); y++)
     {
       source2 = p2.getPixel(x,y);
       target = this.getPixel(x,y);
       target.setColor(source2.getColor());
     }
   }
 }
       
   
                                                       
   
 
 
       
 
 /**
  * Method to mirror the piedmont of the temple
  * @return the corrected picture
  */
 public static Picture mirrorTempleS3()
 {
   Picture picture = 
     new Picture(FileChooser.getMediaPath("temple.jpg"));
   int mirrorPoint = 276;
   int lengthToCopy = mirrorPoint - 13;
   Pixel leftPixel = null;
   Pixel rightPixel = null;
   int count = 0;

   // loop through the columns
   for (int x = 1; x < lengthToCopy; x++)
   {
     // loop through the rows
     for (int y = 27; y < 97; y++)
     {
       count = count + 1;
       leftPixel = picture.getPixel(mirrorPoint - x,y);
       rightPixel = picture.getPixel(mirrorPoint + x, y);
       rightPixel.setColor(leftPixel.getColor());
     }
   }

   // tell how many pixels were copied
   System.out.println("We copied " + count + " pixels");

   // show the picture
   picture.show();
   return picture;
 }
 
 /**
  * Method to copy the picture of Katie to the 
  * upper left corner of the current picture
  */
 public void copyKatie()
 {
   String sourceFile = 
     FileChooser.getMediaPath("KatieFancy.jpg");
   Picture sourcePicture = new Picture(sourceFile);
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX=0;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++) 
   {
     
     // loop through the rows
     for (int sourceY = 0, targetY =0;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++) 
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy the picture of a robot to the 
  * 100,100 of the current picture
  */
 public void copyRobot()
 {
   String sourceFile = 
     FileChooser.getMediaPath("robot.jpg");
   Picture sourcePicture = new Picture(sourceFile);
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX=100;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++) 
   {
     
     // loop through the rows
     for (int sourceY = 0, targetY =100;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++) 
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy the picture of Katie to (100,100) in the 
  * current picture
  */
 public void copyKatieMidway()
 {
   String sourceFile = 
     FileChooser.getMediaPath("KatieFancy.jpg");
   Picture sourcePicture = new Picture(sourceFile);
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX=100;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 0, targetY =100;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++)
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy just Katie's face to the current picture
  */
 public void copyKatiesFace(Picture pictObj,int X,int Y)
 {
     Picture sourcePicture = pictObj;
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
   int sx=X;
   int sy=Y;
   // loop through the columns
   for (int sourceX = sx, targetX = 0;
        sourceX < sourcePicture.getWidth(); sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = sy, targetY = 0;
          sourceY < sourcePicture.getHeight(); sourceY++, targetY++)
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
  /**
   * Method to copy flower pictures to create a collage.  
   * All the flower pictures will be lined up near the 
   * bottom of the current picture (5 pixels from the bottom)
   */
  public void copyFlowers()
  {

    // create the flower pictures
    Picture flower1Picture = 
      new Picture(FileChooser.getMediaPath("flower1.jpg"));
    Picture flower2Picture = 
      new Picture(FileChooser.getMediaPath("flower2.jpg"));
  
    // declare the source and target pixel variables
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // save the heights of the two pictures
    int flower1Height = flower1Picture.getHeight();
    int flower2Height = flower2Picture.getHeight();

    /* copy the first flower picture to 5 pixels from the bottom
     * left corner of the current picture
     */
    for (int sourceX = 0, targetX = 0;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // copy the flower2 picture starting with x = 100 
    for (int sourceX = 0, targetX = 100;
         sourceX < flower2Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower2Height - 5;
           sourceY < flower2Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // copy the flower1 negated to x = 200 
    flower1Picture.negate();
    for (int sourceX = 0, targetX = 200;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // clear the blue in flower 2 picture and add at x=300 
    flower2Picture.clearBlue();
    for (int sourceX = 0, targetX = 300;
         sourceX < flower2Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower2Height - 5;
           sourceY < flower2Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // copy the negated flower 1 to x=400
    for (int sourceX = 0, targetX = 400;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  } 
  
 /**
  * Method that will copy all of the passed source picture into
  * the current picture object starting with the left corner
  * given by xStart.  It will put the sourcePicture at 5 pixels
  * from the bottom of this picture
  * @param sourcePicture  the picture object to copy
  * @param xStart the x position to start the copy in the target
  */
 public void copyPictureTo(Picture sourcePicture, 
                           int xStart)
 {
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX = xStart;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 0,
          targetY = this.getHeight() - 
                    sourcePicture.getHeight() - 5;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }

 }
 
 /**
  * Method to create a flower collage 
  */
 public void createCollage(Picture pictObj)
 {

   // create the flower pictures
   Picture flower1Picture = 
     pictObj;
   //Picture flower2Picture = 
   //  pictObj;
   int end1X = flower1Picture.getWidth();
   //int end2X = flower2Picture.getWidth();
   int end1Y = flower1Picture.getHeight();
   //int end2Y = flower2Picture.getHeight();

   // copy the first flower picture to the
   // top left corner of the canvas
   this.copy(flower1Picture,0,0,end1X,end1Y,
             0,0);

   /* copy the flower2 picture starting with 
    * x = 100 in the canvas
    */
   //this.copy(flower2Picture,0,0,end2X,end2Y,
                     // 100,0);

   // copy the flower1 negated to x = 200 in the canvas
   flower1Picture.negate();
   this.copy(flower1Picture,0,0,end1X,end1Y,
                      200,0);

   /* clear the blue in flower 2 picture and 
    * add at x=300 in the canvas
    */
//   flower2Picture.clearBlue();
//   this.copy(flower2Picture,0,0,end2X,end2Y,
//             300,0);

   // copy the negated flower 1 to x=400
   this.copy(flower1Picture,0,0,end1X,end1Y,
                      400,0);
   
   this.mirrorHorizontal();
 }

 
 
 /**
   * Method to copy from the passed source picture to the current 
   * picture object
   * The copying will start at startX, startY, and end at endX-1 
   * and endY-1
   * The copy will be placed starting at targetStartX, 
   * targetStartY
   * @param sourcePicture the source picture to copy from
   * @param startX the starting x value in the source picture
   * @param startY the starting y value in the source picture
   * @param endX the ending x value in the source picture
   * @param endY the ending y value in the source picture
   * @param targetStartX the starting x value in the 
   * current picture
   * @param targetStartY the starting y value in the 
   * current picture
   */
  public void copy(Picture sourcePicture, 
                   int startX, int startY, 
                   int endX, int endY, 
                   int targetStartX, int targetStartY)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the x values
    for (int x = startX, tx = targetStartX; 
         x < endX && x < sourcePicture.getWidth() && 
                     tx < this.getWidth();
         x++, tx++)
    {
      // loop through the y values
      for (int y = startY, ty = targetStartY; 
           y < endY && y < sourcePicture.getHeight() && 
                       ty < this.getHeight();
           y++, ty++)
      {
        sourcePixel = sourcePicture.getPixel(x,y);
        targetPixel = this.getPixel(tx,ty);
        targetPixel.setColor(sourcePixel.getColor());
        show();
      }
    }
  }
 
   /**
   * Method to copy from the passed source picture to the current 
   * picture object
   * The copying will start at startX, startY, and end at 
   * endX-1 and endY-1
   * The copy will be placed starting at targetStartX, 
   * targetStartY
   * @param sourcePicture the source picture to copy from
   * @param startX the starting x value in the source picture
   * @param startY the starting y value in the source picture
   * @param endX the ending x value in the source picture
   * @param endY the ending y value in the source picture
   * @param targetStartX the starting x value in the current picture
   * @param targetStartY the starting y value in the current picture
   */
  public void copyNonWhitePixels(Picture sourcePicture, 
                                 int startX, int startY, 
                                 int endX, int endY, 
                                 int targetStartX, int targetStartY)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    double distance = 50.0;
    
    // loop through the x values
    for (int x = startX, tx = targetStartX; 
         x < endX && x < sourcePicture.getWidth() && 
                     tx < this.getWidth();
         x++, tx++)
    {
      // loop through the y values
      for (int y = startY, ty = targetStartY; 
           y < endY && y < sourcePicture.getHeight() && 
                       ty < this.getHeight();
           y++, ty++)
      {
        sourcePixel = sourcePicture.getPixel(x,y);
        targetPixel = this.getPixel(tx,ty);
        if (sourcePixel.colorDistance(Color.white) > distance)
           targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  /**
   * Method to blend two sisters together onto the current
   * picture
   */
  public void blendPictures()
  {

    // create the sister pictures
    Picture katiePicture = 
      new Picture(FileChooser.getMediaPath("KatieFancy.jpg"));
    Picture jennyPicture = 
      new Picture(FileChooser.getMediaPath("JenParty.jpg"));
 
    // declare the source and target pixel variables
    Pixel katiePixel = null;
    Pixel jennyPixel = null;
    Pixel targetPixel = null;

    /* declare the target x and source x since we will need 
     * the values after the for loop
     */
    int sourceX = 0;
    int targetX = 0;

    // copy the first 150 pixels of katie to the canvas
    for (; sourceX < 150; sourceX++, targetX++)
    {
      for (int sourceY=0, targetY=0;
           sourceY < katiePicture.getHeight();
           sourceY++, targetY++)
      {
        katiePixel = katiePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(katiePixel.getColor());
      }
    }

    /* copy 50% of katie and 50% of jenny till 
     * the end of katie's width
     */
    for (; sourceX < katiePicture.getWidth(); 
         sourceX++, targetX++)
    {
      for (int sourceY=0,targetY=0;
           sourceY < katiePicture.getHeight();
           sourceY++, targetY++)
      {
        katiePixel = katiePicture.getPixel(sourceX,sourceY);
        jennyPixel = jennyPicture.getPixel(sourceX - 150,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(
              new Color((int) (katiePixel.getRed() * 0.5 +
                               jennyPixel.getRed() * 0.5),
                        (int) (katiePixel.getGreen() * 0.5 +
                               jennyPixel.getGreen() * 0.5),
                        (int) (katiePixel.getBlue() * 0.5 +
                               jennyPixel.getBlue() * 0.5)));
      }
    }

    // copy the rest of Jenny
    sourceX = sourceX - 150;
    for (; sourceX < jennyPicture.getWidth(); 
         sourceX++, targetX++)
    {
      for (int sourceY = 0, targetY = 0;
           sourceY < jennyPicture.getHeight();
           sourceY++, targetY++)
      {
        jennyPixel = jennyPicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(jennyPixel.getColor());
      }
    }
  }
 
 /**
  * Method that will copy all of the passed source picture into
  * the current picture object starting with the left corner
  * given by xStart, yStart
  * @param sourcePicture  the picture object to copy
  * @param xStart the x position to start the copy into on 
  * the target
  * @param yStart the y position to start the copy into on 
  * the target
  */
 public void copyPictureTo(Picture sourcePicture, 
                           int xStart, int yStart)
 {
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX = xStart;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 0,
          targetY = yStart;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }

 }
 
 /**
  * Method to simulate fog by chaging all pixels 
  * that are within the passed dist to white to 
  * a variation on the passed color
  * @param dist the distance to use 
  * @param changeColor the color to use as the base
  */
 public void simulateFog(double dist,
                         Color changeColor)
 {
   Pixel[] pixelArray = this.getPixels();
   double colorDist = 0.0;
   double value = 0.0;
   Color lighterColor = changeColor.brighter();
   Color darkerColor = changeColor.darker();
   
   for (Pixel currPixel : pixelArray)
   {
     if (currPixel.colorDistance(Color.WHITE) < dist)
     {
       value = Math.random();
       if (value < 0.3)
         currPixel.setColor(changeColor);
       else if (value < 0.6)
         currPixel.setColor(lighterColor);
     }
   }
 }
 
 /**
  * Method to change all pixels within dist
  * to black to green
  * @param dist if a color is less than this
  * distance from black change it
  */
 public void changeDarkToGreen(double dist)
 {
   Pixel[] pixelArray = this.getPixels();
   double colorDist = 0.0;

    for (Pixel currPixel : pixelArray)
    {
     if (currPixel.colorDistance(Color.BLACK) < dist)
     {
         currPixel.setColor(Color.GREEN);
     }
   }
 }
 
 /**
  * Method to lighten all pixels less than
  * the passed distance from black
  * @param dist if the distance from the current
  * pixel to black is less than this amount change
  * it
  */
 public void lightenDarkest(double dist)
 {
   Pixel[] pixelArray = this.getPixels();
   double colorDist = 0.0;

    for (Pixel currPixel : pixelArray)
    {
     if (currPixel.colorDistance(Color.BLACK) < dist)
     {
         currPixel.setColor(currPixel.getColor().brighter());
     }
   }
 }
 
 /**
  * Method to lighten the darkest parts of a picture
  * @param dist if a pixel is less than this distance
  * from white then darken it
  */
 public void darkenLightest(double dist)
 {
   Pixel[] pixelArray = this.getPixels();
   double colorDist = 0.0;

    for (Pixel currPixel : pixelArray)
    {
     if (currPixel.colorDistance(Color.WHITE) < dist)
     {
         currPixel.setColor(currPixel.getColor().darker());
     }
   }
 }
 
 /**
  * Method to rotate the current picture left 90
  * degrees
  * @return the new picture
  */
 public Picture rotateLeft()
 {
   Picture target = new Picture(this.getHeight(),
                                this.getWidth());
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
   
   // loop through the columns
   for (int sourceX = 0; 
        sourceX < this.getWidth(); 
        sourceX++)
   {
     // loop through the rows
     for (int sourceY = 0; 
          sourceY < this.getHeight(); 
          sourceY++)
     {
       // set the target pixel color to the source pixel color
       sourcePixel = this.getPixel(sourceX,sourceY);
       targetPixel = target.getPixel(sourceY, 
                                     this.getWidth() - 1 - sourceX);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   return target;
 }
 
 /**
  * Method to rotate a picture right 90 degrees
  * @return the new picture
  */
 public Picture rotateRight()
 {
   Picture target = new Picture(this.getHeight(),
                                this.getWidth());
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
   
   // loop through the columns
   for (int x = 0; x < this.getWidth(); x++)
   {
     // loop through the rows
     for (int y = 0; y < this.getHeight(); y++)
     {
       // set the target pixel color to the source pixel color
       sourcePixel = this.getPixel(x,y);
       targetPixel = target.getPixel(this.getHeight() - 1 - y,
                                     x);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   return target;
 }
 
 /**
  * Method to rotate a picture 180 degrees
  */
 public void rotate180()
 {
   Picture copy = new Picture(this);
   Pixel startPixel = null;
   Pixel endPixel = null;
   for (int y = 0; y < this.getHeight(); y++)
   {
     for (int x = 0; x < this.getWidth(); x++)
     {
       startPixel = copy.getPixel(x,y);
       endPixel = this.getPixel(this.getWidth() - 1 -x,
                                this.getHeight() - 1 - y);
       endPixel.setColor(startPixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy the picture of Katie but rotate 
  * her left 90 degrees on the current picture
  */
 public void copyKatieLeftRotation()
  {
    String sourceFile = 
      FileChooser.getMediaPath("KatieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for (int sourceX = 0; 
         sourceX < sourcePicture.getWidth(); 
         sourceX++)
    {
      // loop through the rows
      for (int sourceY = 0; 
           sourceY < sourcePicture.getHeight(); 
           sourceY++)
      {
        // set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(sourceY, 
                    sourcePicture.getWidth() - 1 - sourceX);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
 
 /**
   * Method to copy the flower but smaller (half as big)
   * on to the current picture
   */
  public void copyFlowerSmaller()
  {
    Picture flowerPicture = 
      new Picture(FileChooser.getMediaPath("passionFlower.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (int sourceX = 0, targetX=0;
         sourceX < flowerPicture.getWidth();
         sourceX+=2, targetX++)
    {
      // loop through the rows
      for (int sourceY=0, targetY=0;
           sourceY < flowerPicture.getHeight();
           sourceY+=2, targetY++)
      {
        sourcePixel = flowerPicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

  }
  
  /**
   * Method to copy the picture of Jakita but smaller 
   * (half as big) to the current picture
   */
  public void copyJakitaSmaller()
  {
    Picture jakitaPicture = 
      new Picture(FileChooser.getMediaPath("jakita.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (int sourceX = 0, targetX=0;
         sourceX < jakitaPicture.getWidth();
         sourceX+=2, targetX++)
    {
      // loop through the rows
      for (int sourceY=0, targetY=0;
           sourceY < jakitaPicture.getHeight();
           sourceY+=2, targetY++)
      {
        sourcePixel = jakitaPicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

  }
  
  /**
   * Method to scale any picture up to 2x
   * @return the new picture
   */
  public Picture scaleBy2()
  {
    Picture target = new Picture(this.getWidth() * 2,
                                 this.getHeight() * 2);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (double sourceX = 0, targetX=0;
         sourceX < this.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      // loop through the rows
      for (double sourceY=0, targetY=0; 
           sourceY <  this.getHeight();
           sourceY = sourceY + 0.5, targetY++)
      {
        sourcePixel = 
          this.getPixel((int) sourceX,(int) sourceY);
        targetPixel = target.getPixel((int) targetX,(int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    return target;
  }
  
  /**
   * Method to flip the picture so that the pixels
   * that were on the right will be on the left
   * (this is like what you see in a mirror)
   * @return the flipped picture
   */
  public Picture flip()
  {
    Picture copy = new Picture(this.getWidth(),
                               this.getHeight());
    Pixel source = null;
    Pixel target = null;
    
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        source = this.getPixel(x,y);
        target = copy.getPixel(this.getWidth() - 1 - x,
                               y);
        target.setColor(source.getColor());
      }
    }
    return copy;
  }
     
  /**
   * Method to copy a flower but scaled to 2x normal size
   * onto the current picture
   */
  public void copyFlowerLarger()
  {
    Picture flowerPicture = 
      new Picture(FileChooser.getMediaPath("rose.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (double sourceX = 0, targetX=0;
         sourceX < flowerPicture.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      // loop through the rows
      for (double sourceY=0, targetY=0; 
           sourceY <  flowerPicture.getHeight();
           sourceY = sourceY + 0.5, targetY++)
      {
        sourcePixel = 
          flowerPicture.getPixel((int) sourceX,(int) sourceY);
        targetPixel = this.getPixel((int) targetX,(int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

  }
  
  /**
   * Method to turn the brown in a picture
   * into red
   */
  public void turnBrownIntoRed()
  {
    Color brown = new Color(42,25,15);
    Pixel[] pixels = this.getPixels();
    Pixel pixel = null;

    // loop through the pixels
    for (int i=0; i<pixels.length; i++)
    {
      // get the current pixel
      pixel = pixels[i];

      // check if in dist to brown and if so double the red
      if (pixel.colorDistance(brown) < 50.0)
        pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                 pixel.getGreen(),
                                 pixel.getBlue()));
    }
  }
  
  /**
   * Method to turn brown to red inside of 
   * a rectangular area
   */
  public void turnBrownToRedInRectangle()
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;

    // loop through the x values
    for (int x=63; x < 125; x++)
    {
      for (int y=6; y < 76; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // check if in distance to brown and if so double the red
        if (pixel.colorDistance(brown) < 50.0)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                     pixel.getGreen(),
                                     pixel.getBlue()));
      }
    }
  }
  
  /**
   * Method to turn brown to red in a rectangular area 
   * specifed
   * by startX, endX-1, startY, endY-1
   * @param startX the starting location to check in x
   * @param endX the last pixel checked is one less than 
   * this in x
   * @param startY the starting location to check in y
   * @param endY the last pixel checked is one less than 
   * this in y
   */
  public void turnBrownToRedInRectangle(int startX, int endX, 
                                    int startY, int endY)
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;

    // loop through the x values
    for (int x=startX; x < endX; x++)
    {
      for (int y=startY; y < endY; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // check if in distance to brown and if so double the red
        if (pixel.colorDistance(brown) < 50.0)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                     pixel.getGreen(),
                                     pixel.getBlue()));
      }
    }
  }
  
  /**
   * Method to turn brown to red in a rectangular area 
   * specifed
   * by startX, endX-1, startY, endY-1
   * @param startX the starting location to check in x
   * @param endX the last pixel checked is one less than 
   * this in x
   * @param startY the starting location to check in y
   * @param endY the last pixel checked is one less than 
   * this in y
   * @param distance if the current color is within this distance
   * to brown then change it
   */
  public void turnBrownToRedInRectangle(int startX, int endX, 
                                        int startY, int endY,
                                        double distance)
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;

    // loop through the x values
    for (int x=startX; x < endX; x++)
    {
      for (int y=startY; y < endY; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        /* check if in distance to brown is less than
         * the passed distance and if so double the red
         */
        if (pixel.colorDistance(brown) < distance)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                     pixel.getGreen(),
                                     pixel.getBlue()));
      }
    }
  }
    
  /**
   * Method to double the red in a picture in a rectangular 
   * area if it is less than the passed distance to the 
   * passed color
   * @param startX the x value at the top left of the rectangular 
   * area
   * @param startY the y value at the top left of the rectangular 
   * area
   * @param endX the bottom right x value of the rectangular area
   * @param endY the bottom right y value of the rectangular area 
   * @param distance the amount that the distance must be less than 
   * @param compareColor the color to compare the current pixel 
   * color to
   */
  public void doubleRedInRange(int startX, int startY, 
                               int endX, int endY, 
                               double distance, Color compareColor)
  {
    Pixel pixel = null;

    // loop through the x values
    for (int x=startX; x <= endX; x++)
    {
      // loop through the y values
      for (int y=startY; y <= endY; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        /* check if the distance is less than the allowed distance 
          and if so double the red */
        if (pixel.colorDistance(compareColor) < distance)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                    pixel.getGreen(),
                                    pixel.getBlue()));
      }
    }

  }
  
  /**
   * Method to change all the pixels within a passed distance of a 
   * passed color in a range specified by a startX, startY, 
   * endX, and endY by passed red, green, and blue factors. 
   * @param compareColor the color to compare to
   * @param distance the distance that this should be within 
   * (less than)
   * @param redFactor the amount to multiply the current red 
   * value by
   * @param greenFactor the amount to multiply the current green 
   * value by
   * @param blueFactor the amount to multiply the current blue 
   * value by
   * @param startX the starting x value to use in checking the 
   * pixels 
   * @param startY the starting y value to use in checking the 
   * pixels
   * @param endX the ending x value to use in checking the 
   * pixels (< this)
   * @param endY the ending y value to use in checking the 
   * pixels (< this)
   */
  public void changePixelsWithinDistance(Color compareColor, 
                                         double distance, 
                                         double redFactor, 
                                         double greenFactor, 
                                         double blueFactor, 
                                         int startX, int startY, 
                                         int endX, int endY)
  {
    Pixel pixel = null;
    Color color = null;
    
    // loop through the x values
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        // get the pixel at this x and y
        pixel = this.getPixel(x,y);
        
        /* if the current color is within the passed distance to 
         * the passed color
         */
        if (pixel.colorDistance(compareColor) < distance)
        {
          color = new Color((int) (pixel.getRed() * redFactor),
                            (int) (pixel.getGreen() * greenFactor),
                            (int) (pixel.getBlue() * blueFactor));
          
          pixel.setColor(color);
        }
      }
      
    }    
  }
  
  /**
   * Method to remove red eye from the current picture object in 
   * the rectangle defined by startX, startY, endX, endY.  The red 
   * will be replaced with the passed newColor
   * @param startX  the top left corner x value of a rectangle
   * @param startY  the top left corner y value of a rectangle
   * @param endX    the bottom right corner x value of a rectangle
   * @param endY    the bottom right corner y value of a rectangle
   * @param newColor the new color to use
   */
  public void removeRedEye(int startX, int startY, int endX,
                           int endY, Color newColor)
  {
    Pixel pixel = null;

    /* loop through the pixels in the rectangle defined by the 
       startX, startY, and endX and endY */
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        // get the current pixel
        pixel = getPixel(x,y);

        // if the color is near red then change it
        if (pixel.colorDistance(Color.red) < 167)
          pixel.setColor(newColor);
      }
    }
  }
  
  /**
   * Method to change the current picture to a sepia
   * tint (modify the middle colors to a light brown and
   * the light colors to a light yellow and make the 
   * shadows darker)
   */
  public void sepiaTint()
  {
    Pixel pixel = null;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // first change the current picture to grayscale
    this.grayscale();

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        // get the current pixel and color values
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // tint the shadows darker
        if (redValue < 60)
        {
          redValue = redValue * 0.9;
          greenValue = greenValue * 0.9;
          blueValue = blueValue * 0.9;
        }

        // tint the midtones a light brown
        // by reducing the blue
        else if (redValue < 190)
        {
          blueValue = blueValue * 0.8;
        }

        // tint the highlights a light yellow
        // by reducing the blue
        else
        {
          blueValue = blueValue * 0.9;
        }

        // set the colors
        pixel.setRed((int) redValue);
        pixel.setGreen((int) greenValue);
        pixel.setBlue((int) blueValue);
      }
    }
  }
  
  /**
   * Modify the current picture based on the distance to the
   * final picture, the current index, and the total distance
   * @param finalPict the desired final picture
   * @param index the current index
   * @param dist the total distance to the final picture
   */
  public void modifyTowards(Picture finalPict, int index, double dist)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel[] finalPixelArray = finalPict.getPixels();
    Pixel currPixel = null;
    Pixel finalPixel = null;
    double redDist, blueDist, greenDist;
    Color pictColor = null;
    
    // loop through the array of pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      currPixel = pixelArray[i];
      finalPixel = finalPixelArray[i];
      redDist = finalPixel.getRed() - currPixel.getRed();
      blueDist = finalPixel.getBlue() - currPixel.getBlue();
      greenDist = finalPixel.getGreen() - currPixel.getGreen();
      pictColor = new Color((int) (index / dist * redDist + currPixel.getRed()),
                            (int) (index / dist * greenDist + currPixel.getGreen()),
                            (int) (index / dist * blueDist + currPixel.getBlue()));
      currPixel.setColor(pictColor);
    }
  }
  
  /**
   * Method to change a range in the current picture to a sepia
   * tint (modify the middle colors to a light brown and
   * the light colors to a light yellow and make the 
   * shadows darker)
   * @param startX the starting x in the range
   * @param startY the starting y in the range
   * @param endX the ending x in the range (not inclusive)
   * @param endY the ending y in the range (not inclusive)
   */
  public void sepiaTint(int startX, int startY,
                        int endX, int endY)
  {
    Pixel pixel = null;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // first change the current picture to grayscale
    this.grayscale(startX,startY,endX,endY);

    // loop through the pixels
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        // get the current pixel and color values
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // tint the shadows darker
        if (redValue < 60)
        {
          redValue = redValue * 0.9;
          greenValue = greenValue * 0.9;
          blueValue = blueValue * 0.9;
        }

        // tint the midtones a light brown
        // by reducing the blue
        else if (redValue < 190)
        {
          blueValue = blueValue * 0.8;
        }

        // tint the highlights a light yellow
        // by reducing the blue
        else
        {
          blueValue = blueValue * 0.9;
        }

        // set the colors
        pixel.setRed((int) redValue);
        pixel.setGreen((int) greenValue);
        pixel.setBlue((int) blueValue);
      }
    }
  }
  
  /**
   * Method to posterize (reduce the number of colors) in 
   * the picture.  The number of reds, greens, and blues will be 4
   */
  public void posterize()
  {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {

        // get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // check for red range and change color
        if (redValue < 64)
          redValue = 31;
        else if (redValue < 128)
          redValue = 95;
        else if (redValue < 192)
          redValue = 159;
        else
          redValue = 223;

        // check for green range
        if (greenValue < 64)
          greenValue = 31;
        else if (greenValue < 128)
          greenValue = 95;
        else if (greenValue < 192)
          greenValue = 159;
        else
          greenValue = 223;

        // check for blue range
        if (blueValue < 64)
          blueValue = 31;
        else if (blueValue < 128)
          blueValue = 95;
        else if (blueValue < 192)
          blueValue = 159;
        else
          blueValue = 223;

        // set the colors
        pixel.setRed(redValue);
        pixel.setGreen(greenValue);
        pixel.setBlue(blueValue);
      }
    }
  }
  
  /**
   * Method to posterize (reduce the number of colors) in 
   * the picture
   * @param numLevels the number of color levels to use
   */
  public void posterize(int numLevels)
  {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int increment = (int) (256.0 / numLevels);
    int bottomValue, topValue, middleValue = 0;

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {

        // get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // loop through the number of levels
        for (int i = 0; i < numLevels; i++)
        {
          // compute the bottom, top, and middle values
          bottomValue = i * increment;
          topValue = (i + 1) * increment;
          middleValue = (int) ((bottomValue + topValue - 1) / 2.0);

          // check if current values are in current range and if so
          // set them to the middle value
          if (bottomValue <= redValue && redValue < topValue)
            pixel.setRed(middleValue);
          if (bottomValue <= greenValue && greenValue < topValue)
            pixel.setGreen(middleValue);
          if (bottomValue <= blueValue && blueValue < topValue)
            pixel.setBlue(middleValue);
        }
      }
    }
  }
  
  /**
   * Method to replace the pixel colors in the current picture object
   * that have a color distance less than the passed amount to white 
   * or black with the passed replacement color
   * @param replacementColor the new color to use 
   */
  public void highlightLightAndDark(double amount, 
                                    Color replacementColor) {
    Pixel pixel = null;
    
    // loop through all the pixels in the x direction
    for (int x = 0; x < getWidth(); x++) {
      
      // loop through all the pixels in the y direction
      for (int y = 0; y < getHeight(); y++) {
        
        // get the current pixel
        pixel = getPixel(x,y);
        
        // if the distance from white or black is less than the 
        // passed amount use the replace color instead
        if (pixel.colorDistance(Color.white) < amount ||
            pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor);
        }
      }
    }
  }
        
  /**
   * Method to create a new picture that is scaled up by the 
   * passed  number of times.
   * @return the new scaled up picture
   */
  public Picture scaleUp(int numTimes)
  {
    Picture targetPicture = 
      new Picture(this.getWidth() * numTimes, 
                  this.getHeight() * numTimes);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    int targetX = 0;
    int targetY = 0;

    // loop through the source picture columns
    for (int sourceX = 0;
         sourceX < this.getWidth();
         sourceX++)
    {
      // loop through the source picture rows
      for (int sourceY=0;
          sourceY < this.getHeight();
          sourceY++)
      {
        // get the source pixel
        sourcePixel = this.getPixel(sourceX,sourceY);
        
        // loop copying to the target y
        for (int indexY = 0; indexY < numTimes; indexY++)
        {
          // loop copying to the target x
          for (int indexX = 0; indexX < numTimes; indexX++)
          {
            targetX = sourceX * numTimes + indexX;
            targetY = sourceY * numTimes + indexY;
            targetPixel = targetPicture.getPixel(targetX,targetY);
            targetPixel.setColor(sourcePixel.getColor());
          }
        }
      }
    }
    return targetPicture;

  }
  
  public Picture scaleDown(int numTimes)
  {
    Picture targetPicture = new Picture(this.getWidth()/numTimes  + 1,this.getHeight()/numTimes + 1);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for (int sourceX = 0, targetX=0; 
         sourceX < this.getWidth(); 
         sourceX+=numTimes, targetX++)
    {
      // loop through the rows
      for (int sourceY=0, targetY=0; 
           sourceY < this.getHeight(); 
           sourceY+=numTimes, targetY++)
      {
        sourcePixel = this.getPixel(sourceX,sourceY);
        targetPixel = targetPicture.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    return targetPicture;
    
  } 
  /**
   * Method to blur the pixels
   * @param numPixels the number of pixels to average in all 
   * directions.  So if the numPixels is 2 then we will average 
   * all pixels in the rectangle defined by 2 before the current 
   * pixel to 2 after the current pixel
   */
  public void blur(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;

    // loop through the pixels
    for (int x=0; x < this.getWidth(); x++) {
      for (int y=0; y < this.getHeight(); y++) {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;

        // loop through pixel numPixels before x to numPixels after x
        for (int xSample = x - numPixels; 
             xSample <= x + numPixels; 
             xSample++) {
          for (int ySample = y - numPixels; 
               ySample <= y + numPixels;
               ySample++) {

            // check that we are in the range of acceptable pixels
            if (xSample >= 0 && xSample < this.getWidth() &&
                ySample >= 0 && ySample < this.getHeight()) {
              samplePixel = this.getPixel(xSample,ySample);
              redValue = redValue + samplePixel.getRed();
              greenValue = greenValue + samplePixel.getGreen();
              blueValue = blueValue + samplePixel.getBlue();
              count = count + 1;
            }
          }
        }

        // use average color of surrounding pixels
        Color newColor = new Color(redValue / count,
                                   greenValue / count,
                                   blueValue / count);
        pixel.setColor(newColor);
      }
    }
  }
  
  /**
   * Method to blur the pixels
   * @param numPixels the number of pixels to average in all 
   * directions.  So if the numPixels is 2 then we will average 
   * all pixels in the rectangle defined by 2 before the current 
   * pixel to 2 after the current pixel
   */
  public void blurWithCopy(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;
    Picture copyPict = new Picture(this);

    // loop through the pixels
    for (int x=0; x < this.getWidth(); x++) {
      for (int y=0; y < this.getHeight(); y++) {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;

        // loop through pixel numPixels before x to numPixels after x
        for (int xSample = x - numPixels; 
             xSample <= x + numPixels; 
             xSample++) {
          for (int ySample = y - numPixels; 
               ySample <= y + numPixels;
               ySample++) {

            // check that we are in the range of acceptable pixels
            if (xSample >= 0 && xSample < this.getWidth() &&
                ySample >= 0 && ySample < this.getHeight()) {
              samplePixel = copyPict.getPixel(xSample,ySample);
              redValue = redValue + samplePixel.getRed();
              greenValue = greenValue + samplePixel.getGreen();
              blueValue = blueValue + samplePixel.getBlue();
              count = count + 1;
            }
          }
        }

        // use average color of surrounding pixels
        Color newColor = new Color(redValue / count,
                                   greenValue / count,
                                   blueValue / count);
        pixel.setColor(newColor);
      }
    }
  }
  
  /**
   * Method to do a simple edge detection by comparing the absolute 
   * value of the difference between the color intensities (average 
   * of the color values) between a pixel and the pixel below it.  
   * If the absolute value of the difference between the color 
   * intensities is less than a passed amount the top pixel color 
   * will be set to white.  Otherwise it is set to black.
   * @param amount if the absolute value of the differences in the 
   * color average is less than this
   * set the color to white, else black
   */
  public void edgeDetection(double amount) {
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    /* loop through y values from 0 to height - 1 
     * (since compare to below pixel) */
    for (int y = 0; y < endY; y++) {
      
      // loop through the x values from 0 to width
      for (int x = 0; x < this.getWidth(); x++) {
        
        // get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x,y+1);
        
        // get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /* check if the absolute value of the difference 
         * is less than the amount */
        if (Math.abs(topAverage - bottomAverage) < amount) {
          topPixel.setColor(Color.WHITE);
        
        // else set the color to black
        } else {
          topPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  /**
   * Method to check for the edge by comparing
   * the current pixel to the one on the right
   * @param amount the amount to use to see if
   * it is an edge
   */
  public void edgeDetectionToRight(double amount) 
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int endX = this.getWidth() - 1;
    
    // loop through y values from 0 to < height
    for (int y = 0; y < this.getHeight(); y++) {
      
      // loop through the x values from 0 to endX
      for (int x = 0; x < endX; x++) {
        
        // get the left and right pixels
        leftPixel = this.getPixel(x,y);
        rightPixel = this.getPixel(x+1,y);
        
        /* check if the absolute value of the difference 
         * is less than the amount */
        if (Math.abs(leftPixel.getAverage() - 
                     rightPixel.getAverage()) < amount) {
          leftPixel.setColor(Color.WHITE);
        
        // else set the color to black
        } else {
          leftPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  /**
   * Method to check for an edge using the average
   * of the pixel to the right and below
   * @param amount the amount to use as the threshold
   */
  public void edgeDetectionRightBelow(double amount) 
  {
    Pixel currPixel = null;
    Pixel rightPixel = null;
    Pixel belowPixel = null;
    
    int endX = this.getWidth() - 1;
    int endY = this.getHeight() - 1;
    
    // loop through y values from 0 to < endY
    for (int y = 0; y < endY; y++) {
      
      // loop through the x values from 0 to endX
      for (int x = 0; x < endX; x++) {
        
        // get the current, right and below pixels
        currPixel = this.getPixel(x,y);
        rightPixel = this.getPixel(x+1,y);
        belowPixel = this.getPixel(x,y+1);
        
        // get the average of the right and below pixel
        double average = (rightPixel.getRed() + 
          belowPixel.getRed() + rightPixel.getGreen() +
          belowPixel.getGreen() + rightPixel.getBlue() +
          belowPixel.getBlue()) / 6;
        
        /* check if the absolute value of the difference 
         * is less than the amount */
        if (Math.abs(currPixel.getAverage() - average) < 
              amount) 
        {
          currPixel.setColor(Color.WHITE);
        
        // else set the color to black
        } else {
          currPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  /**
   * Method to do a simple edge detection in a range 
   * by comparing the absolute value of the difference 
   * between the color intensities (average 
   * of the color values) between a pixel and 
   * the pixel below it.  
   * If the absolute value of the difference 
   * between the color intensities is less than 
   * a passed amount the top pixel color 
   * will be set to white.  Otherwise it is 
   * set to black.
   * @param amount if the absolute value of the 
   * differences in the color average is less than this
   * set the color to white, else black
   */
  public void edgeDetection(double amount, 
                            int startX, int startY, 
                            int endX, int endY) 
  {
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    
    /* loop through y values from 0 to endY - 1 
     * (since compare to below pixel) */
    for (int y = startY; y < endY - 1; y++) {
      
      // loop through the x values from 0 to width
      for (int x = startX; x < endX; x++) {
        
        // get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x,y+1);
        
        // get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /* check if the absolute value of the difference 
         * is less than the amount */
        if (Math.abs(topAverage - bottomAverage) < amount) {
          topPixel.setColor(Color.WHITE);
        
        // else set the color to black
        } else {
          topPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  /**
   * Method to replace the background in the current picture 
   * with the background from another picture
   * @param oldBackground the old background to replace
   * @param newBackground the new background to use
   */
  public void swapBackground(Picture oldBackground,
                             Picture newBackground)
  {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel and old background pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);

        /* if the distance between the current pixel color 
         * and the old background pixel color is less than the 15
         * then swap in the new background pixel
         */
        if (currPixel.colorDistance(oldPixel.getColor()) < 15.0)
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to replace the background in the current picture with 
   * the background from another picture
   * @param oldBackground the old background to replace
   * @param newBackground the new background to use
   * @param threshold if the distance between the current pixel 
   * color and the background
   * pixel color is less than this amount use the new background 
   * pixel color
   */
  public void swapBackground(Picture oldBackground, 
                             Picture newBackground, 
                             double threshold)
  {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel and old background pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);

        /* if the distance between the current pixel color and 
         * the old background pixel color is less than the 
         * threshold then swap in the new background pixel
         */
        double distance = 
          currPixel.colorDistance(oldPixel.getColor());
        if (distance < threshold)
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using the passed background
   * color and the distance to the color
   * @param newBg the new background image to use to replace
   * @param color the background color to compare to
   * @param dist the distance that limits the chromakey
   * it will happen if the distance is less than or equal
   * to this value
   */
  public void chromakey(Picture newBg, Color color, double dist)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly blue 
         * (blue value is greater than red and green combined), 
         * then use the new background color
         */
        double currDist = currPixel.colorDistance(color);
        if (currDist <= dist)
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to add a word balloon to the picture
   * @param upperX the top left corner x of the enclosing
   * rectangle
   * @param upperY the top left corner y of the enclosing
   * rectangle
   * @param width the width of the enclosing rectangle
   * @param height the height of the enclosing rectangle
   * @param message the text to write in the balloon
   * @param backG the color of the ellipse
   * @param fontColor the color of the text
   * @param endX the x value of the end of the speech
   * triangle
   * @param endY the y value of the end of the speech
   * triangle
   */
  public void addWordBalloon(int upperX, int upperY,
                             int width, int height,
                             String message,
                             Color backG, Color fontColor,
                             int endX, int endY)
  {
    Graphics g = this.getGraphics();
    
    // set the background color
    g.setColor(backG);
    
    // draw the ellipse
    g.fillOval(upperX,upperY, width,height);
    
    // draw the lines from bottom of ellipse to end
    int midX = upperX + (width / 2);
    int botY = upperY + height;
    int leftX = midX - 5;
    int rightX = midX + 5;
    int[] xArray = {leftX,rightX,endX};
    int[] yArray = {botY,botY,endY};
    g.fillPolygon(xArray,yArray,3);
    
    // change to font color
    g.setColor(fontColor);
    g.drawString(message,upperX + 20, 
                 upperY + (height / 2));
  }
  
  /**
   * Method to do chromakey using a blue background
   * @param newBg the new background image to use to replace
   * the blue from the current picture
   */
  public void chromakey(Picture newBg)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly blue 
         * (blue value is greater than red and green combined), 
         * then use the new background color
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
        if (combindedColor < currPixel.getBlue())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
   /**
   * Method to do chromakey using a green background
   * @param newBg the new background image to use to replace
   * the green from the current picture
   */
  public void chromakeyGreen(Picture newBg)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly green
         * (green value is greater than blue and red combined), 
         * then use the new background color
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getBlue();
        if (combindedColor < currPixel.getGreen())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }

  /**
   * Method to change the current colors
   * to just green, red, and blue.  If the
   * average at a pixel is less than 85 
   * set the color to green, if it is less than
   * 170 set it to red, else set it to blue
   */
  public void changeToGreenRedBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    
    // loop through the pixels
    for (Pixel currPixel : pixelArray)
    {
      if (currPixel.getAverage() < 85)
        currPixel.setColor(Color.GREEN);
      else if (currPixel.getAverage() < 170)
        currPixel.setColor(Color.RED);
      else
        currPixel.setColor(Color.BLUE);
    }
  }
  
  /**
   * Method to do chromakey using a blue background in 
   * a range
   * @param newBg the new background image to use to replace
   * the blue from the current picture
   * @param startX the start x in the range
   * @param startY the start y in the range
   * @param endX the end x in the range
   * @param endY the end y in the range
   */
  public void chromakey(Picture newBg,
                        int startX, int startY,
                        int endX, int endY)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=startX; x<endX; x++)
    {

      // loop through the rows
      for (int y=startY; y<endY; y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly blue 
         * (blue value is greater than red and green combined), 
         * then use the new background color
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
        if (combindedColor < currPixel.getBlue())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using a blue background
   * @param newBg the new background image to use to replace
   * the blue from the current picture
   */
  public void chromakeyBlue(Picture newBg)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      currPixel = pixelArray[i];

      /* if the color at the current pixel is mostly blue (the blue 
       * value is greater than green and red combined), then use 
       * the new background color
       */
      int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
      if (combindedColor < currPixel.getBlue())
      {
        newPixel = newBg.getPixel(currPixel.getX(),
                                  currPixel.getY());
        currPixel.setColor(newPixel.getColor());
      }

    }
  }
  
  /**
   * Method to do chromakey using a red background
   * @param newBg the new background image to use to replace
   * the red from the current picture
   */
  public void chromakeyRed(Picture newBg)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      currPixel = pixelArray[i];

      /* if the color at the current pixel is mostly red (red 
       * value is greater than the blue and green combined 
       * then swap the background
       */
      int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
      if (combindedColor < currPixel.getRed())
      {
        newPixel = newBg.getPixel(currPixel.getX(),
                                  currPixel.getY());
        currPixel.setColor(newPixel.getColor());
      }

    }
  }
  
  /**
   * Method to set the blue values to 100 in a rectangle of 100 
   * pixels with x and y starting at 0 and ending at 99
   */
  public void blueOneHundred()
  {
    Pixel p = null;
    
    for (int x = 0; x < 100; x++) {
      for (int y=0; y < 100; y++) {
        p = getPixel(x,y);
        p.setBlue(100);
      }
    }
  }
  
  /**
   * Method to set all blue values to 100 in the 
   * picture
   */
  public void blueChange()
  {
    Pixel[] pixelArray = getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      if (pixel.getBlue() > 0) {
        pixel.setBlue(100);
      }
    }
  }
  
  /**
   * Method to set the blue to zero if the distance from this color
   * to blue is greater than 100
   */
  public void clearSomeBlue() {
    Pixel[] pixelArray = getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      if (pixel.colorDistance(Color.BLUE) > 100)
        pixel.setBlue(0);
    }
  }
  
  /**
   * Method to set the blue to zero if the current blue value is 
   * greater than 100
   */
  public void setBlue() {
    Pixel[] pixelArray = getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      if (pixel.getBlue() > 100)
        pixel.setBlue(0);
    }
  }
  
  /**
   * Method to count the number of white pixels in a picture 
   * @return the number of white (r=255, g=255, b=255) pixels
   */
  public int countWhitePixels()
  {
    int count = 0;
    Pixel pixel = null;
    Pixel[] pixels = this.getPixels();
    for (int i=0; i < pixels.length; i++)
    {
      pixel = pixels[i];
      if (pixel.getRed() == 255 && 
          pixel.getGreen() == 255 && 
          pixel.getBlue() == 255)
        count++;
    }
    return count;
  }
  
  /**
   * Method to draw a grid on a picture
   */
  public void drawGrid() 
  {
    Pixel pixel = null;
    
    // Draw the horizontal lines
    for (int y = 20; y < this.getHeight(); y+=20) {
      for (int x = 0; x < this.getWidth(); x++) {
        pixel = this.getPixel(x,y);
        pixel.setColor(Color.black);
      }
    }
    
    // draw the vertical lines
    for (int x = 20; x < this.getWidth(); x+=20) {
      for (int y = 0; y < this.getHeight(); y++) {
        pixel = this.getPixel(x,y);
        pixel.setColor(Color.black);
      }
    }
  }
  
  /**
   * Method to add a solid red rectangle to the current picture
   */
  public void addBox()
  {
    
    // get the graphics context from the picture
    Graphics g = this.getGraphics();
    
    // set the color to red
    g.setColor(Color.red);
    
    // draw the box as a filled rectangle
    g.fillRect(150,200,50,50);
  }
    
  /**
   * Method to add a solid red rectangle to the beach picture
   */
  public static Picture addBoxToBeach()
  {
    Picture p = 
      new Picture(FileChooser.getMediaPath("beach-smaller.jpg"));
    
    // get the graphics context from the picture
    Graphics g = p.getGraphics();
    
    // set the color to red
    g.setColor(Color.red);
    
    // draw the box as a filled rectangle
    g.fillRect(150,200,50,50);
    
    return p;
  }
  
  /**
   * Method to draw a filled box on the current picture
   * @param color the color to draw the box with
   * @param topLeftX the top left x coordinate of the box
   * @param topLeftY the top left y coordinate of the box
   * @param width the width of the box
   * @param height the height of the box
   */
  public void drawBox(Color color, int topLeftX, int topLeftY,
                      int width, int height)
  {
    // get the graphics context for drawing 
    Graphics g = this.getGraphics();
    
    // set the current color
    g.setColor(color);
    
    // draw the filled rectangle
    g.fillRect(topLeftX,topLeftY,width,height);
  }  
  
  /**
   * Method to show different drawing capabilities.  It 
   * will draw a string, a line, a filled rectangle, the 
   * outline of a rectangle, the outline of an oval, 
   * and a filled arc.
   */
  public void drawExample()
  {

    // get the graphics object to use for drawing
    Graphics graphics = this.getGraphics();

    // start with a black color
    graphics.setColor(Color.black);

    /* draw the string with the upper left corner 
     * at x=10, y=75
     */
    graphics.drawString(
       "This is a test of drawing a string on a picture",
                        10,75);

    // draw a line from (10,20) to (300,50)
    graphics.drawLine(10,20,300,50);

    // set the color to yellow
    graphics.setColor(Color.yellow);

    /* draw a filled rectangle (filled with yellow) at 
     * upper left (0,200) with a width of 300 and 
     * height 250
     */
    graphics.fillRect(0,200,300,250);

    // set the color back to black
    graphics.setColor(Color.black);

    /* draw the outline of a rectangle with the upper 
     * left at (10,210) and a width of 200 and a height 
     * of 100
     */
    graphics.drawRect(10,210,200,100);
    
    /* draw an oval enclosed by a rectangle with the top 
     * left corner at (400,10) and a width of 200 and a 
     * height of 100 
     */
    graphics.drawOval(400,10,200,100);
    
    /* draw an arc which is part of an oval enclosed by 
     * a rectangle with the top left corner at (400,300) 
     * a width of 200, and a height of 150.  The arc 
     * starts at 0 (3 o'clock position) and goes 180 
     * degrees counter-clockwise to the 9 o'clock position
     */
    graphics.fillArc(400,300,200,150,0,180);
  }
  
  /**
   * Method to draw a face to demonstrate drawing 
   * ovals and arcs
   */
  public void drawFace()
  {
    // get the graphics object to use for drawing
    Graphics graphics = this.getGraphics();

    // start with a black color
    graphics.setColor(Color.black);
    
    // draw the oval for the face
    graphics.drawOval(130,50,380,380);
    
    // draw the ovals for the eyes
    graphics.fillOval(225,155,40,40);
    graphics.fillOval(375,155,40,40);
    
    // draw the arcs for the eyebrows
    graphics.drawArc(225,145,40,40,45,90);
    graphics.drawArc(375,145,40,40,45,90);
    
    // draw the arc for the mouth
    graphics.drawArc(190,85,255,255,-45,-90);
  }
  
   /**
   * Method to draw a face to demonstrate drawing 
   * ovals and arcs
   * @param upperLeftX the upper left x of the
   * enclosing rectangle
   * @param upperLeftY the upper left y of the
   * enclosing rectangle
   * @param width of enclosing rectangle
   * @param height of enclosing rectangle
   */
  public void drawFace(int upperLeftX,
                       int upperLeftY,
                       int width, int height)
  {
    // get the graphics object to use for drawing
    Graphics graphics = this.getGraphics();

    // start with a black color
    graphics.setColor(Color.black);
    
    // draw the oval for the face
    //130,50,380,380
    graphics.drawOval(upperLeftX,upperLeftY,
                      width,height);
    
    // draw the ovals for the eyes
    int quarterDist = width / 4;
    int tenth = height / 10;
    graphics.fillOval(upperLeftX + quarterDist,
                      upperLeftY + quarterDist,
                      tenth,tenth);
    graphics.fillOval(upperLeftX + width - 
                      quarterDist - tenth,
                      upperLeftY + quarterDist,
                      tenth,tenth);
    
    // draw the arcs for the eyebrows
    graphics.drawArc(upperLeftX + quarterDist,
                     upperLeftY + quarterDist - 10,
                     tenth,tenth,45,90);
    graphics.drawArc(upperLeftX + width - 
                      quarterDist - tenth,
                     upperLeftY + quarterDist - 10,
                     tenth,tenth,45,90);
    
    // draw the arc for the mouth
    int arcWidth = (int) (width * 0.67);
    int arcY  = (int) (width * 0.09);
    graphics.drawArc(upperLeftX + (width / 6),
                     upperLeftY + arcY,
                     arcWidth,arcWidth,
                     -45,-90);
  }
  
  /**
   * Method to draw a rainbow using arcs
   * to draw the red, orange, yellow, green,
   * blue, purple and white bands.
   */
  public void drawRainbow()
  {
    Graphics g = this.getGraphics();
    int height = this.getHeight();
    int width = this.getWidth();
    int diff = width / 15;
    int halfDiff = diff / 2;
    int x = 0;
    int y = 0;
    
    // draw the red arc
    g.setColor(Color.RED);
    g.fillArc(x,y,width,height,0,180);
    
    // draw the orange arc
    width = width - diff;
    height = height - diff;
    x = x + halfDiff;
    y = y + halfDiff;
    g.setColor(new Color(255,102,0));
    g.fillArc(x,y,width,height,0,180);
    
    // draw the yellow arc
    width = width - diff;
    height = height - diff;
    x = x + halfDiff;
    y = y + halfDiff;
    g.setColor(Color.YELLOW);
    g.fillArc(x,y,width,height,0,180);
    
    // draw the green arc
    width = width - diff;
    height = height - diff;
    x = x + halfDiff;
    y = y + halfDiff;
    g.setColor(Color.GREEN);
    g.fillArc(x,y,width,height,0,180);
    
    // draw the blue arc
    width = width - diff;
    height = height - diff;
    x = x + halfDiff;
    y = y + halfDiff;
    g.setColor(Color.BLUE);
    g.fillArc(x,y,width,height,0,180);
    
    // draw the purple arc
    width = width - diff;
    height = height - diff;
    x = x + halfDiff;
    y = y + halfDiff;
    g.setColor(new Color(153,0,204));
    g.fillArc(x,y,width,height,0,180);
    
    // draw the white arc
    width = width - diff;
    height = height - diff;
    x = x + halfDiff;
    y = y + halfDiff;
    g.setColor(Color.WHITE);
    g.fillArc(x,y,width,height,0,180);
  }
  
  /**
   * Method to draw a string on the current picture
   * @param text the string to draw
   * @param x the x location to start at
   * @param y the y location of the baseline
   */
  public void drawString(String text, int x, int y)
  {
    
    this.drawString(text,x,y,
                    new Font("Arial",Font.BOLD,24),
                    Color.BLACK);
  }
     
  /**
   * Method to draw a string on the current picture
   * @param text the string to draw
   * @param x the x location to start at
   * @param y the y location of the baseline
   */
  public void drawStringV2(String text, int x, int y)
  {
    
    this.drawString(text,x,y,
                    new Font("Arial",Font.BOLD,24),
                    Color.BLACK);
  }
  
  /**
   * Method to draw a string on the current picture
   * @param text the string to draw
   * @param x the x location to start at
   * @param y the y location of the baseline
   * @param font the font to use
   * @param color the color to use
   */
  public void drawString(String text, int x, int y,
                         Font font, Color color)
  {
    
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // set the color 
    g.setColor(color);
    
    // set the font
    g.setFont(font);
    
    // draw the string
    g.drawString(text,x,y);
  }
  
  /**
   * Method to draw a horizontally centered string 
   * on the current picture
   * @param text the string to draw
   * @param y the y location of the baseline
   */
  public void drawHorizontalCenteredString(String text, 
                                           int y)
  {
    
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // create the font object
    Font font = new Font("Arial",Font.BOLD,24);
    
    // set the color 
    g.setColor(Color.black);
    
    // set the font
    g.setFont(font);
    
    // get the font metrics
    FontMetrics fontMetrics = g.getFontMetrics();
    
    // get the width of the string
    int strWidth = fontMetrics.stringWidth(text);
    
    // calculate the center of the  picture
    int center = (int) (this.getWidth() * 0.5);
    
    // draw the string centered in x
    g.drawString(text,
                 center - (int) (strWidth * 0.5),
                 y);
  }
  
  /**
   * Method to draw a horizontally centered string 
   * at the top of the picture
   * @param text the string to draw
   */
  public void drawTopCenteredString(String text)
  {
    
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // create the font object
    Font font = new Font("Arial",Font.BOLD,24);
    
    // set the color 
    g.setColor(Color.black);
    
    // set the font
    g.setFont(font);
    
    // get the font metrics
    FontMetrics fontMetrics = g.getFontMetrics();
    
    // get the width of the string
    int strWidth = fontMetrics.stringWidth(text);
    
    // calculate the center of the  picture
    int center = (int) (this.getWidth() * 0.5);
    
    // calculate the baseline Y of the font
    int y = fontMetrics.getHeight() -
      fontMetrics.getDescent();
    
    // draw the string centered in x
    g.drawString(text,
                 center - (int) (strWidth * 0.5),
                 y);
  }
  
  /**
   * Method to draw a gray effect picture on the 
   * current picture
   */
  public void drawGrayEffect()
  {
    
    // create a medium gray color to use
    Color medGray = new Color(100,100,100);
    
    // Do 100 columns of medium gray
    for (int x = 0; x < 100; x++)
      for (int y = 0; y < 100; y++)
        this.getPixel(x,y).setColor(medGray);
    
    /* Do 100 columns of gray starting at medium
     * gray and getting lighter
     */
    for (int x=100, grayLevel=100; 
         x < 200; 
         x++,grayLevel++)
      for (int y=0; y < 100; y++)
        this.getPixel(x,y).setColor(
              new Color(grayLevel,grayLevel,grayLevel));
    
    // Do 100 columns starting at black and getting lighter
    for (int x=200, grayLevel=0; x < 300; x++, grayLevel++)
      for (int y=0; y < 100; y++)
         this.getPixel(x,y).setColor(
              new Color(grayLevel,grayLevel,grayLevel));
    
    // Do 100 columns of medium gray
    for (int x=300; x < 400; x++)
      for (int y=0; y < 100; y++)
         this.getPixel(x,y).setColor(medGray);
  }
  
  /**
   * Method to draw a picture with a succession of 
   * filled rectangles with the top left corner the 
   * darkest and the bottom right the lightest on 
   * the current picture
   */
  public void drawFilledRectangles()
  {
    Graphics g = this.getGraphics();
    Color color = null;
    
    // loop 25 times
    for (int i = 25; i > 0; i--)
    {
      color = new Color(i * 10, i * 5, i);
      g.setColor(color);
      g.fillRect(0,0,i*10,i*10);
    }
  }
  
  /**
   * Method to draw a picture with a succession of 
   * rectangles on the current picture
   */
  public void drawRectangles()
  {
    Graphics g = this.getGraphics();
    Color color = null;
    
    // loop 25 times
    for (int i = 25; i > 0; i--)
    {
      g.setColor(Color.black);
      g.drawRect(i,i,i*3,i*4);
      g.drawRect(100+i*4,100+i*3,i*8,i*10);
    }
  }
  
  /**
   * Method to add two crossed lines to a picture.  One line will go 
   * from the top left corner to the bottom right corner.  The other 
   * will go from the bottom left corner to the top right corner.
   * @param color the color to draw the x in
   */
  public void drawX(Color color)
  {
    Graphics graphics = this.getGraphics();
    graphics.setColor(color);
    
    // get the max x and y values
    int maxX = getWidth() - 1;
    int maxY = getHeight() - 1;
    
    // draw the lines
    graphics.drawLine(0,0,maxX,maxY);
    graphics.drawLine(0,maxY, maxX,0);
    
  }
  
  /**
   * Method to draw vertical bars on a picture
   * @param color the color to draw the bars in
   * @param width the width of the bars
   * @param dist the distance between the bars
   */
  public void drawBars(Color color, float width, 
                       int dist)
  {
    // get the Graphics2D object
    Graphics graphics = this.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    // set the color and brush width
    g2.setPaint(color);
    g2.setStroke(new BasicStroke(width));
    
    // loop drawing horizontal lines
    for (int x = dist; x < this.getWidth(); 
         x = x + dist)
    {
      // draw the lines
      g2.draw(new Line2D.Double(x,0,
                                x,this.getHeight() - 1));
    }
  }

  /**
   * Method to add two crossed lines to a picture.  
   * One line will go from the top left corner to the 
   * bottom right corner.  The other will go from the 
   * bottom left corner to the top right corner.
   */
  public void drawWideX(Color color, float width)
  {
    // get the Graphics2D object
    Graphics graphics = this.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    // set the color and brush width
    g2.setPaint(color);
    g2.setStroke(new BasicStroke(width));
    
    // get the max x and y values
    int maxX = getWidth() - 1;
    int maxY = getHeight() - 1;
    
    // draw the lines
    g2.draw(new Line2D.Double(0,0,maxX,maxY));
    g2.draw(new Line2D.Double(0,maxY, maxX,0));
    
  }
  
  /**
   * Method to draw a dashed X on the current
   * picture
   * @param color the color to draw the X in
   * @param width the width of the x lines
   */
  public void drawDashedX(Color color, float width)
  {
    float dash1[] = {10.0f};
    BasicStroke dashed = 
      new BasicStroke(width,
                      BasicStroke.CAP_BUTT, 
                      BasicStroke.JOIN_MITER, 
                      10.0f, dash1, 0.0f);
    
    // get the Graphics2D object
    Graphics graphics = this.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    // set the color and brush width
    g2.setPaint(color);
    g2.setStroke(dashed);
    
    // get the max x and y values
    int maxX = getWidth() - 1;
    int maxY = getHeight() - 1;
    
    // draw the lines
    g2.draw(new Line2D.Double(0,0,maxX,maxY));
    g2.draw(new Line2D.Double(0,maxY, maxX,0));
    
  }
  
  
  
  /**
   * Method to create a new picture by rotating the current picture
   * by the given degrees
   * @param degrees the number of degrees to rotate by
   * @return the resulting picture
   */
  public Picture rotate(int degrees)
  {
    // set up the rotation tranform
    AffineTransform rotateTransform = new AffineTransform();
    rotateTransform.rotate(Math.toRadians(degrees));
    Rectangle2D rect = 
      getTransformEnclosingRect(rotateTransform);
    
    // create a new picture object big enough to hold the result no
    // matter what the rotation is
    Picture result = new Picture((int) (Math.ceil(rect.getWidth())),
                                 (int) (Math.ceil(rect.getHeight())));
    
    // get the graphics 2d object from the result
    Graphics graphics = result.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    // save the current transformation and set-up to center the 
    // rotated image
    AffineTransform savedTrans = g2.getTransform();
    AffineTransform centerTrans = new AffineTransform();
    centerTrans.translate(0 - rect.getX(), 0 - rect.getY());
    g2.setTransform(centerTrans);
    
    // draw the current image onto the result image rotated
    g2.drawImage(this.getImage(),rotateTransform,null);
    
    // reset g2 transformation to the saved one
    g2.setTransform(savedTrans);
    
    return result;
  }
  
  /**
   * Method to add text rotated to the right
   * 90 degrees
   * @param text the text to rotate
   */
  public void addRightText(String text)
  {
    // set up the rotation tranform
    AffineTransform rotateTransform = 
      new AffineTransform();
    rotateTransform.translate(this.getWidth() - 20,
                              -(this.getHeight() / 2));
    rotateTransform.rotate(Math.toRadians(90));
    
    // get the graphics 2d object from the result
    Graphics graphics = this.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    AffineTransform savedTrans = g2.getTransform();
    g2.setTransform(rotateTransform);
    g2.setColor(Color.BLACK);
    g2.drawString(text,400,0);
    g2.setTransform(savedTrans);
  }
  
  /**
   * Method to create a new picture by shearing the current 
   * picture by the given x and y factors
   * @param xFactor multiplier to use to shift in x 
   * direction based on y index
   * @param yFactor multiplier to use to shift in y 
   * direction based on x index
   * @return the resulting picture
   */
  public Picture shear(double xFactor, double yFactor)
  {
    // set up the shear tranform
    AffineTransform shearTransform = new AffineTransform();
    shearTransform.shear(xFactor,yFactor);
    Rectangle2D rect = 
      getTransformEnclosingRect(shearTransform);
    
    /* create a new picture object big enough to hold the 
     * result
     */
    Picture result = new Picture(
                      (int) (Math.ceil(rect.getWidth())),
                      (int) (Math.ceil(rect.getHeight())));
    
    // get the graphics 2d object from the result
    Graphics graphics = result.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    /* save the current transformation and set-up to 
     * center the new image
     */
    AffineTransform savedTrans = g2.getTransform();
    AffineTransform centerTrans = new AffineTransform();
    centerTrans.translate(0 - rect.getX(), 0 - rect.getY());
    g2.setTransform(centerTrans);
    
    // draw the current image onto the result image sheared
    g2.drawImage(this.getImage(),shearTransform,null);
    
    // reset g2 transformation to the saved one
    g2.setTransform(savedTrans);
    
    return result;
  }
  
  /**
   * Method to create a new picture by scaling the current
   * picture by the given x and y factors
   * @param xFactor the amount to scale in x
   * @param yFactor the amount to scale in y
   * @return the resulting picture
   */
  public Picture scale(double xFactor, double yFactor)
  {
    // set up the scale tranform
    AffineTransform scaleTransform = new AffineTransform();
    scaleTransform.scale(xFactor,yFactor);
    
    // create a new picture object that is the right size
    Picture result = new Picture((int) (getWidth() * xFactor),
                                 (int) (getHeight() * yFactor));
    
    // get the graphics 2d object to draw on the result
    Graphics graphics = result.getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    // draw the current image onto the result image scaled
    g2.drawImage(this.getImage(),scaleTransform,null);
    
    return result;
  }
  
  /**
   * Method to try different composite rules in a picture
   * with a gradient painted rectangle and a texture painted
   * ellipse
   */
  public static Picture createComposite()
  {
    // create the composite
    AlphaComposite ac = 
      AlphaComposite.getInstance(AlphaComposite.SRC_IN,0.5f);
    
    // create a picture object
    Picture p = new Picture(500,500);
    
    // get the Graphics2D object
    Graphics g = p.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    g2.setPaint(Color.white);
    g2.fillRect(0,0,p.getWidth(),p.getHeight());
    
    // draw the rectangle in blue
    g2.setPaint(new Color(0.0f,0.0f,1.0f,1.0f));
    g2.fill(new Rectangle2D.Double(10,10,400,400));
    
    // set the composite
    g2.setComposite(ac);
    
    // draw the ellipse in yellow
    g2.setPaint(new Color(1.0f,1.0f,0.0f,1.0f));
    g2.fill(new Ellipse2D.Double(140,140,350,350));
    
    return p;
  }
  
  /**
   * Method to copy the passed picture into the current 
   * picture at the given x and y position in the 
   * current picture
   * @param source the picture to copy
   * @param x the x of the upper left corner to copy to
   * @param y the y of the upper left corner to copy to
   */
  public void copy(Picture source, int x, int y)
  {
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // copy the image
    g.drawImage(source.getImage(),x,y,null);
  }
  
  /**
   * Method to copy the passed picture into the current 
   * picture at the given x and y position in the current 
   * picture
   * @param source the picture to copy
   * @param x the x of the upper left corner to copy to
   * @param y the y of the upper left corner to copy to
   */
  public void copy2D(Picture source, int x, int y)
  {
    // get the graphics object
    Graphics g = this.getGraphics();
    Graphics g2 = (Graphics2D) g;
    
    // copy the image
    g2.drawImage(source.getImage(),x,y,null);
  }
  
  /**
   * Method to overlap one picture with another 
   * horizontally on top of the current picture.  First 
   * the part of the first picture before the overlap 
   * will be displayed, next to that will be the overlapping
   * region up to the end of the first picture, after that 
   * is the remainder of the second picture
   * @param p1 the first picture to display
   * @param p2 the second picture to display
   * @param startOverlap the x position where the overlap begins
   */
  public void overlapPictures(Picture p1, 
                              Picture p2, 
                              int startOverlap)
  {
    int amountOverlap = p1.getWidth()- startOverlap;
   
    // get the Graphics2D object
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // draw p1 up to overlap point
    g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                               (float) 1.0f));
    g2.drawImage(p1.getImage(),
                 0,0,startOverlap,p1.getHeight(),
                 0,0,startOverlap,p1.getHeight(),
                 null);
   
    // draw p1 in the overlap area (replace background)
    g2.drawImage(p1.getImage(),
                 startOverlap,0,p1.getWidth(),p1.getHeight(),
                 startOverlap,0,p1.getWidth(), p1.getHeight(),
                 null);
    
    // set the composite to blend the old and new pixels
    // 50%
    g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                               0.5f));
                 
    g2.drawImage(p2.getImage(),
                 startOverlap,0,p1.getWidth(),p2.getHeight(),
                 0,0,amountOverlap,p2.getHeight(),null);
    
    // draw p2 after the overlap
    g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                               (float) 1.0f));
    g2.drawImage(p2.getImage(),
                p1.getWidth(),0,p2.getWidth() + startOverlap, 
                 p2.getHeight(), amountOverlap, 0, p2.getWidth(), 
                 p2.getHeight(),null);
 
  }
  
  /**
   * Method to overlap one picture with another 
   * vertically on top of the current picture.  First 
   * the part of the first picture before the overlap 
   * will be displayed, below that will be the 
   * overlapping region up to the end of the first 
   * picture, after that is the remainder of the 
   * second picture
   * @param p1 the first picture to display
   * @param p2 the second picture to display
   * @param startOverlap the y position where the 
   * overlap begins
   */
  public void overlapPicturesVert(Picture p1, 
                                  Picture p2, 
                                  int startOverlap)
  {
    int amountOverlap = p1.getHeight()- startOverlap;
   
    // get the Graphics2D object
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // draw p1 up to overlap point
    g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                               (float) 1.0f));
    g2.drawImage(p1.getImage(),
                 0,0,p1.getWidth(),startOverlap,
                 0,0,p1.getWidth(),startOverlap,
                 null);
   
    // draw p1 in the overlap area (replace background)
    g2.drawImage(p1.getImage(),
                 0,startOverlap,
                 p1.getWidth(),p1.getHeight(),
                 0,startOverlap,
                 p1.getWidth(),p1.getHeight(),
                 null);
    
    // set the composite to blend the old and new pixels
    // 50%
    g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                               0.5f));
                 
    g2.drawImage(p2.getImage(),
                 0,startOverlap,p2.getWidth(),p1.getHeight(),
                 0,0,p2.getWidth(),amountOverlap, null);
    
    // draw p2 after the overlap
    g2.setComposite(
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                               (float) 1.0f));
    g2.drawImage(p2.getImage(),
                 0,p1.getHeight(),p2.getWidth(),
                 p1.getHeight() + p2.getHeight() - amountOverlap,
                 0,amountOverlap,p2.getWidth(),p2.getHeight(),
               null);
 
  }
  
  /**
   * Method to draw a town with 4 streets
   * with houses of different sizes
   */
  public void drawTown()
  {
    for (int y = 100; y < 300; y = y + 100)
    {
      // loop drawing 6 houses
      for (int x = 0; x < 600; x = x + 100)
      {
        drawHouse(x,y,100,50);
      }
    }
    
    for (int y = 300; y < 500; y = y + 100)
    {
      // loop drawing 6 houses
      for (int x = 0; x < 600; x = x + 50)
      {
        drawHouse(x,y,50,50);
      }
    }
  }
  
  /**
   * Method to draw a simple house
   * @param x the bottom left x
   * @param y the bottom left y
   * @param houseWidth the width of the house
   * @param houseHeight the height of the rectangle
   * part of the house (roof is taller)
   */
  public void drawHouse(int x, int y, 
                        int houseWidth, 
                        int houseHeight)
  {
    int doorWidth = houseWidth / 4;
    int doorHeight = (int) (doorWidth * 1.5);
    int windowWidth = houseWidth / 8;
    
    // get the graphics object
    Graphics g = this.getGraphics();

    // draw the bottom square
    g.setColor(Color.GREEN);
    g.fillRect(x,y-houseHeight,houseWidth,houseHeight);
    
    // draw the door
    g.setColor(Color.BLACK);
    g.fillRect(x+((houseWidth / 2) - (doorWidth / 2)),
                  y-doorHeight,doorWidth,doorHeight);
    
    // draw the left window
    g.setColor(Color.WHITE);
    g.fillRect(x+windowWidth,
               y-(int) (houseHeight * 3 / 4),
               windowWidth,windowWidth);
    
    // draw the right window
    g.fillRect(x + (int) (houseWidth * 3 / 4),
               y - (int) (houseHeight * 3/ 4), 
               windowWidth,windowWidth); 
    
    // draw the roof
    g.setColor(Color.BLACK);
    int[] xArray = {x, x+houseWidth / 2, x+houseWidth};
    int[] yArray = {y-houseHeight,
      y-(int) (houseHeight * 1.5),y-houseHeight};
    g.fillPolygon(xArray,yArray,3);
  
  }
  
  /**
   * Method to add a gradient painted sun to the current picture
   * @param x the x location for the upper left corner of the 
   * rectangle enclosing the sun
   * @param y the y location for the upper left corner of the 
   * rectangle enclosing the sun
   * @param width the width of the enclosing rectangle
   * @param height the height of the enclosing rectangle
   */
  public void drawSun(int x, int y, int width, int height)
  {
    
    // get the graphics2D object for this picture
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // create the gradient for painting from yellow to red with
    // yellow at the top of the sun and red at the bottom
    float xMid = (float) (width / 0.5 + x);
    GradientPaint gPaint = new GradientPaint(xMid, y, 
                                             Color.yellow, 
                                             xMid, y + height, 
                                             Color.red);
    
    // set the gradient and draw the ellipse
    g2.setPaint(gPaint);
    g2.fill(new Ellipse2D.Double(x,y,width,height));
  }
  
  /**
   * Method to clip the picture to an ellipse
   * @return a new picture with the image clipped 
   * to an ellipse
   */
  public Picture clipToEllipse()
  {
    int width = this.getWidth();
    int height = this.getHeight();
    Picture result = new Picture(width,height);
    
    // get the graphics2D object for this picture
    Graphics g = result.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // create an ellipse to use for clipping
    Ellipse2D.Double ellipse = 
      new Ellipse2D.Double(0,0,width,height);
    
    // use the ellipse for clipping
    g2.setClip(ellipse);
    
    // draw the image
    g2.drawImage(this.getImage(),0,0,width,
                 height,null);
    
    // return the result
    return result;
  }
  
  /**
   * Method to clip the picture to a triangle
   * @return a new picture with the image clipped 
   * to a triangle
   */
  public Picture clipToTriangle()
  {
    int width = this.getWidth();
    int height = this.getHeight();
    Picture result = new Picture(width,height);
    
    // get the graphics2D object for this picture
    Graphics g = result.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // create a path to use for clipping
    GeneralPath path = 
      new GeneralPath(new Line2D.Double(0,height,
                                        width / 2,0));
    path.append(new Line2D.Double(width / 2, 0, 
                                  width, height), true);
    path.append(new Line2D.Double(width, height, 
                                  0, height), true);
    
    // use the path for clipping
    g2.setClip(path);
    
    // draw the image
    g2.drawImage(this.getImage(),0,0,width,
                 height,null);
    
    // return the result
    return result;
  }
    
  
  /**
   * Method to create a new picture from this picture that shows 
   * the part of the current picture that is inside a text message
   * @param message the message to show
   * @return the new picture 
   */
  public Picture clipToMessage(String message)
  {
    int width = this.getWidth();
    int height = this.getHeight();
    Picture result = new Picture(width,height);
    
    // get the graphics2D object for this picture
    Graphics g = result.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // set all the pixels to white in the image
    g2.setColor(Color.white);
    g2.fillRect(0,0,width,height);
    
    /* get the shape to clip to (the stencil) from the font, string, 
     * and font render context
     */
    FontRenderContext fontRenderContext = g2.getFontRenderContext();
    Font font = new Font("Helvetica", 1, this.getWidth()/10);
    TextLayout textLayout = new TextLayout(message, font, 
                                           fontRenderContext);
    Shape outline = textLayout.getOutline(null);
    
    // center string in the middle horiztonally and vertically
    Rectangle rect = outline.getBounds();
    AffineTransform transform = new AffineTransform();
    transform = g2.getTransform();
    transform.translate(width/2-(rect.width/2), 
                        height/2+(rect.height/2));
    g2.transform(transform);
    
    // draw the outline of the string in black
    g2.setColor(Color.black);
    g2.draw(outline);   
   
    /* set the clipping region and draw the image inside the outline 
     * (stencil)
     */
    g2.setClip(outline);
    g2.drawImage(this.getImage(),rect.x, rect.y, 
                 rect.width, rect.height, null);
   
    return result;
  }
  
  /**
   * Method to blend two pictures, the current picture object
   * and the passed sourcePict object.  The amount of the source
   * picture to use is given in sourceAlpha.  The amount of the
   * current picture to use is (1.0 - sourceAlpha)
   * @param sourcePict the source picture
   * @param sourceAlpha the amount of the source picture to use
   * @return the result of blending the source picture with the
   * current picture object
   */
  public Picture blendPictures(Picture sourcePict, double sourceAlpha)
  {
    int resultWidth = Math.max(sourcePict.getWidth(), 
                               this.getWidth());
    int resultHeight = Math.max(sourcePict.getHeight(),
                                this.getHeight());
      
    // create new picture
    Picture result = new Picture(resultWidth,resultHeight);
    
    // get the Graphics2D object
    Graphics g = result.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // set up source picture blend and draw it
    g2.setComposite(
      AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                 (float) sourceAlpha));
    g2.drawImage(sourcePict.getImage(),0,0,
                 sourcePict.getWidth(),sourcePict.getHeight(),null);
    
    // set up orig picture blend and draw it
    g2.setComposite(
           AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 
                                      (float) (1.0 - sourceAlpha)));
    g2.drawImage(this.getImage(),0,0,this.getWidth(), 
                 this.getHeight(),null);
    
    return result;
  }
    
        
  
  /**
   * Method to copy a picture into the current picture 
   * using the passed composite rule
   * @param sourcePict the source picture to copy from
   * @param sourceRect the rectangle that describes what area to 
   * copy from
   * @param targetRect the rectangle that describes what area to 
   * copy into
   * @param composite the composite to use
   */
  public void copyPicture(Picture sourcePict, 
                          Rectangle sourceRect,
                          Rectangle targetRect,
                          Composite composite)
  {
    // get the graphics 2d object to draw on 
    Graphics graphics = getGraphics();
    Graphics2D g2 = (Graphics2D) graphics;
    
    // set the composite type
    //g2.setComposite(composite);
    
    // draw the image
    g2.drawImage(sourcePict.getImage(),
                 (int) sourceRect.getX(),
                 (int) sourceRect.getY(),
                 (int) (sourceRect.getX() + 
                        sourceRect.getWidth() - 1),
                 (int) (sourceRect.getY() + 
                        sourceRect.getHeight() - 1),
                 (int) targetRect.getX(),
                 (int) targetRect.getY(),
                 (int) (targetRect.getX() + 
                        targetRect.getWidth() - 1),
                 (int) (targetRect.getY() + 
                        targetRect.getHeight() - 1),
                 null);
  }
  
  /**
   * Method to show a turtle crawling across the beach
   */
  public static void showTurtleMovie() 
  {
    Picture beachPicture = 
      new Picture(Picture.getMediaPath("beach-smaller.jpg"));
    Picture turtlePicture = 
      new Picture(Picture.getMediaPath("greenTurtleSmall.jpg"));
    Picture viewedPicture = new Picture(beachPicture.getWidth(), 
                                        beachPicture.getHeight());
    int maxX = beachPicture.getWidth() - turtlePicture.getWidth();
    
    
    // loop moving turtle across the beach
    for (int i=0; i < maxX; i+=5)
    {
      viewedPicture.copy(beachPicture,0,0,
                         beachPicture.getWidth()-1,
                         beachPicture.getHeight()-1,0,0);
      viewedPicture.copy(turtlePicture,0,0,
                         turtlePicture.getWidth()-1,
                         turtlePicture.getHeight()-1,
                         i,viewedPicture.getHeight() - 100);
      viewedPicture.repaint();
    }
    
  }
  
   /**
   * Method to show a turtle crawling across the beach
   */
  public static void makeTurtleMovie()
  {
    Picture beachPicture = 
      new Picture(Picture.getMediaPath("beach-smaller.jpg"));
    Picture turtlePicture = 
      new Picture(Picture.getMediaPath("greenTurtle.jpg"));
    Picture viewedPicture = 
      new Picture(beachPicture.getWidth(), 
                  beachPicture.getHeight());
    int maxX = beachPicture.getWidth() - turtlePicture.getWidth();
    FrameSequencer sequence = 
      new FrameSequencer("c:/intro-prog-java/movies/turtle/");
    
    
    // loop moving turtle across the beach
    for (int i=0, count=0; i < maxX; i+=5, count++)
    {
      viewedPicture.copy(beachPicture,0,0,
                         beachPicture.getWidth()-1,
                         beachPicture.getHeight()-1,0,0);
      viewedPicture.copyNonWhitePixels(turtlePicture,0,0,
                         turtlePicture.getWidth()-1,
                         turtlePicture.getHeight()-1,
                         i,viewedPicture.getHeight() - 100);
      sequence.addFrame(viewedPicture);
    }
    
  }
  
  /**
   * Method to recursively subdivide triangles
   * @param smallestLength the smallest allowed
   * length
   */
  public static Picture drawTriangles(int smallestLength)
  {
    Picture pict = new Picture(100,100);
    Point p1 = new Point(50,0);
    Point p2 = new Point(0,100);
    Point p3 = new Point(100,100);
    Triangle t1 = new Triangle(p1,p2,p3);
    Graphics g = pict.getGraphics();
    g.setColor(Color.BLACK);
    g.drawLine(p1.x,p1.y,p2.x,p2.y);
    g.drawLine(p2.x,p2.y,p3.x,p3.y);
    g.drawLine(p3.x,p3.y,p1.x,p1.y);
    t1.subdivideTriangle(g,smallestLength);
    return pict;
  }  
  
  /**
   * Method to draw glasses on the picture 
   * of Barb
   * @return the picture of Barb with the glasses
   */
  public static Picture drawGlassesOnBarb()
  {
    Picture p = new Picture(
                            FileChooser.getMediaPath("barbara.jpg"));
    Graphics g = p.getGraphics();
    g.setColor(Color.BLACK);
    
    // draw glasses
    g.drawOval(84,109,25,16);
    g.drawOval(139,104,25,16);
    g.drawLine(109,117,139,112);
    g.drawLine(84,119,65,119);
    g.drawLine(164,111,173,107);
    
    return p;
  }
  
  /**
   * Method to draw a hat on the picture 
   * of Barb
   * @return the picture of Barb with the hat
   */
  public static Picture drawHatOnBarb()
  {
    Picture p = new Picture(
                            FileChooser.getMediaPath("barbara.jpg"));
    Graphics g = p.getGraphics();
    g.setColor(Color.BLACK);
    
    // draw the hat
    int[] xArray = {31,24,53,39,160,174,193,196};
    int[] yArray = {112,92,81,26,4,61,60,79};
    g.fillPolygon(xArray,yArray,8);
    
    return p;
  }
  
   /**
   * Method to draw a weight over someone in a picture 
   * @return the picture of Mark with the weight over
   * him
   */
  public static Picture drawWeightOverMark()
  {
    Picture p = new Picture(
                            FileChooser.getMediaPath("blue-mark.jpg"));
    Graphics g = p.getGraphics();
    g.setColor(Color.BLACK);
    
    // draw the weight
    int[] xArray = {284,376,476,184};
    int[] yArray = {56,55,149,149};
    g.fillPolygon(xArray,yArray,4);
    
    return p;
  }
  
  /**
   * Method to return a picture created
   * from the file with the passed name
   * @param fileName the name of the file
   * @return pict the created picture
   */
  public static Picture getPicture(String fileName)
  {
    Picture p = new Picture(fileName);
    return p;
  }
  
  /**
   * Method to convert a picture into a sound
   * @return the resulting sound
   */
  public Sound convertToSound()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Sound aSound = new Sound(pixelArray.length);
    
    // loop through pixel array
    for (int i = 0; i < pixelArray.length; i++)
    {
      currPixel = pixelArray[i];
      double average = currPixel.getAverage();
      
      // map the average to a sound value
      if (average <= 84)
        aSound.setSampleValueAt(i,Sound.MAX_NEG);
      else if (average <= 169)
        aSound.setSampleValueAt(i,0);
      else
        aSound.setSampleValueAt(i,Sound.MAX_POS);
    }
   
    return aSound;
  }
  
  public static void main(String[] args)
  {
    Picture p = new Picture(FileChooser.pickAFile());
    p.show();
  }

    //int getWidth() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    //int getHeight() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
  
} // end of class Picture, put all new methods before this
 