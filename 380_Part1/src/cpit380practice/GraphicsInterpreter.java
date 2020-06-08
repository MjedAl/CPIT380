package cpit380practice;

import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class that reads in a file of graphics instructions, and
 * executes them, showing the result. Default picture size
 * is 640x480.
 *
 * Format of the file is a bunch of lines of the form:
 * Command X Y <parameters>
 * Commands are:
 * "line" with parameters of start and end X and Y and
 * "circle" with the upper left corner of the enclosing
 * rectangle and the diameter of the circle
 *
 * For example:
 * line 10 10 50 70
 * circle 10 20 30
 *
 * Which draws a line from (10,10) to (50,70) and a
 * circle at (10,20) with a diameter of 30.
 *
 * @author Barb Ericson
 * @author Mark Guzdial
 */
public class GraphicsInterpreter
{
  /**
   * Method to interpret the commands in the given file
   */
  public Picture interpretCommands(String fileName)
  {
    String line = null;

    Picture frame = new Picture(640,480);
    String [] params = null;
    int x1, y1, x2, y2, diameter;
    Graphics g = frame.getGraphics();
    g.setColor(Color.black);

    // try the following
    try {

      // read from the file
      BufferedReader reader =
        new BufferedReader(new FileReader(fileName));

      // loop till end of file
      while ((line = reader.readLine()) != null)
      {
        // what command is this?
        if (line.startsWith("line"))
        {
          // Get the parameters for drawing the line
          params = line.split(" ");
          // params[0] should be "line"
          x1 = Integer.parseInt(params[1]);
          y1 = Integer.parseInt(params[2]);
          x2 = Integer.parseInt(params[3]);
          y2 = Integer.parseInt(params[4]);

          // Now, draw the line in
          g.drawLine(x1,y1,x2,y2);
        }
        else if (line.startsWith("circle"))
        {
          // Get the parameters for drawing the circle
          params = line.split(" ");
          // params[0] should be "circle"
          x1 = Integer.parseInt(params[1]);
          y1 = Integer.parseInt(params[2]);
          diameter = Integer.parseInt(params[3]);

          // Now, draw the circle in
          g.drawOval(x1,y1,diameter,diameter);
        }
        else {
          System.out.println("Uh-oh! Invalid command! "+line);
          return frame;}

      }

    } catch (FileNotFoundException ex) {
      System.out.println("Couldn't find file " + fileName);
      fileName = FileChooser.pickAFile();
      interpretCommands(fileName);
    } catch (Exception ex) {
      System.out.println("Error during read or write");
      ex.printStackTrace();
    }

      return frame;
  }

  public static void main(String[] args)
  {
    GraphicsInterpreter interpreter = new GraphicsInterpreter();
    String fileName =
      FileChooser.getMediaPath("graphics-commands.txt");
    Picture p = interpreter.interpretCommands(fileName);
    p.show(); 
  }
}