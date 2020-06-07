/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookClasses;

//import java.awt.*;

import java.awt.Color;

//import java.awt.font.*;
//import java.awt.geom.*;
//import java.text.*;
/**
 *
 * @author Saim
 */
public class CPIT380Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This is CPIT380 Practice Session");
        String fileName = FileChooser.pickAFile();
        System.out.println(fileName);
        
        Picture picObject = new Picture(fileName);
        picObject.show();
        int width = picObject.getWidth();
        System.out.print("Width of Picture = ");
        System.out.println(width);
        int height = picObject.getHeight();
        System.out.print("Height of Picture = ");
        System.out.println(height);
        System.out.print("Total number of Pixels in the Picture = ");
        System.out.println(width * height);
        int red, green, blue;
        Pixel[] pixelArray = picObject.getPixels();
        Color colorObj = new Color(255,0,0);
        
        for (Pixel pixelObj: pixelArray)
        {
            pixelObj.setColor(colorObj);
                  
        }
        picObject.show();
        

// Method to decrease RED Color
       /* public void decreaseRed(){
        Pixel[] pixelArray = this.getPixels();
        int value = 0;
       // loop through all the pixels in the array
        for (Pixel pixelObj : pixelArray)
            { // get the red value
          value = pixelObj.getRed();
          // decrease the red value by 50% (1/2)
          value = value / 2;
            //value = value * 1.50; to increase by 50%
            // set the red value of the current pixel to the new value
          pixelObj.setRed(value);
            }
        }*/

        
        
        
    }
    
}
