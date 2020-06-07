package BookClasses;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class CaptionedPicture extends Picture
{
  ///////////// fields /////////////////
  /** the text to display */
  private String caption;
  /** the top left x of caption*/
  private int xPos = 10;
  /** the top left y of caption*/
  private int yPos = 10;
  /** the font to use */
  private Font captionFont;
  /** the color of the ellipse */
  private Color ellipseColor = Color.WHITE;
  /** the color of the caption */
  private Color captionColor = Color.BLACK;
  
  ////////////// constructors ////////////
 
  /**
   * Constructor that takes just the caption
   * to display 
   * @param theCaption the caption to display
   */
  public CaptionedPicture(String theCaption)
  {
    this.caption = theCaption;
  }
  
  //////////////// methods //////////////////
  
  /**
   * Method to show the picture
   */
  public void show()
  {
    // get the Graphics2D 
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // get the font information for the message
    if (captionFont == null)
      captionFont = new Font("Arial",Font.BOLD,24);
    FontRenderContext frc = g2.getFontRenderContext();
    Rectangle2D bounds = captionFont.getStringBounds(caption,frc);
    LineMetrics metrics = captionFont.getLineMetrics(caption,frc);
    float lineHeight = metrics.getHeight();
    float ascent = metrics.getAscent();
    
    // draw the ellipse for the word ballon
    double ellipseWidth = bounds.getWidth() * 1.5;
    double ellipseHeight = bounds.getHeight() * 2.0;
    g2.setColor(this.ellipseColor);
    g2.fill(new Ellipse2D.Double(xPos,yPos,
                                 ellipseWidth,
                                 ellipseHeight));
    
    // draw the message centered in the ellipse
    float x0 = (float) ((ellipseWidth - bounds.getWidth()) / 2 + 
                        xPos);
    float y0 = (float) ((ellipseHeight - lineHeight) / 2 + 
                        yPos + ascent);
    g2.setColor(this.captionColor);
    g2.setFont(this.captionFont);
    g2.drawString(this.caption,x0,y0);
    
    // show this picture
    this.show();
  }
  
}