package BookClasses;

import java.awt.*;
public class GeneratedDrawing{
 public static void main(String args[]){
  Picture frame = new Picture(640,480);
  Graphics g = frame.getGraphics();
  g.setColor(Color.black);
  g.drawOval(20,20,100,100);
  g.drawOval(300,20,100,100);
  g.drawLine(210,120,210,320);
  g.drawLine(210,320,310,320);
  g.drawLine(20,350,400,350);
  frame.show();
  } // end main()
} // end class
