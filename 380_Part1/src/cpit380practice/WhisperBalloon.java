package cpit380practice;

import java.awt.*;
import javax.swing.*;

/**
 * Class to show a whisper balloon which is used
 * in a comic panel to show that a character is 
 * whispering.  The outline of the balloon is dashed
 * and the text is small and plain.
 * 
 * @author Barb Ericson ericson@cc.gatech.edu
 * Copyright 2005
 */
public class WhisperBalloon extends SpeechBalloon
{
  ///////////// constructors ///////////////////////
  public WhisperBalloon (Point uLeft, int theWidth, 
                       Point tEnd, String theMessage)
  {
    super(uLeft,theWidth,tEnd,theMessage);
    Font font = new Font("Arial",Font.PLAIN,10);
    this.setFont(font);
  }
  
  ////////////// methods ///////////////////////////
  
  /**
   * Method to draw the speech balloon
   * @param ellipseHeight the height of the ellipse
   * @param fillColor the color to fill the balloon with
   * @param outlineColor the color to outline the balloon
   * with
   * @param g2 the 2d graphics context
   */
  protected void drawBalloon(int ellipseHeight,
                             Color fillColor,
                             Color outlineColor,
                             Graphics2D g2)
  {
    Stroke currStroke = g2.getStroke();
    float[] dash1 = {10.0f};
    BasicStroke dashed = 
      new BasicStroke(3.0f, 
                      BasicStroke.CAP_BUTT, 
                      BasicStroke.JOIN_MITER, 
                      10.0f, dash1, 0.0f);
    g2.setStroke(dashed);
    super.drawBalloon(ellipseHeight,fillColor,
                      outlineColor,g2);
    g2.setStroke(currStroke);
  }
  
   public static void main(String[] args)
  {
    Picture p = new Picture(FileChooser.getMediaPath("horse.jpg"));
    Graphics g = p.getGraphics();
    Point ul = new Point(68,24);
    Point te = new Point(182,123);
    String message = "This is a test." +
      "  Of a message with more than one line in it.";
    WhisperBalloon balloon = 
      new WhisperBalloon(ul,200,te,message);
    balloon.draw(g);
    p.show();
  }
}