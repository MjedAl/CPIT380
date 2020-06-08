package cpit380practice;

import java.io.*;

/**
 * Class that reads in a file of graphics instructions, and
 * then generates a NEW Java Program that
 * does the same thing as the instructions. Default picture size is 640x480.
 * 
 * Format of the file is a bunch of lines of the form:
 * Command X Y <parameters>
 * Commands are "line" with parameters of end X,Y and
 * "circle" with a parameter of diameter.
 * 
 * For example:
  * line 10 10 50 70
 * circle 10 20 30
 * 
 * Which draws a line from (10,10) to (50,70) and a circle at (10,20)
 * with a diameter of 30.
 * 
 * @author Barb Ericson
 * @author Mark Guzdial
 */
public class GraphicsCompiler
{
  
  /** Method to write out the prologue for the new program:
   * All the imports, the class definition, main, etc.
   * @param file BufferedWriter to write the prologue to
   **/
  public void writePrologue(BufferedWriter file){
    try {
      // Write out the prologue lines
      file.write("import java.awt.*;"); file.newLine();
      file.write("public class GeneratedDrawing{"); file.newLine();
      file.write(" public static void main(String args[]){"); file.newLine();
      file.write("  Picture frame = new Picture(640,480);"); file.newLine();
      file.write("  Graphics g = frame.getGraphics();"); file.newLine();
      file.write("  g.setColor(Color.black);"); file.newLine();}
    catch (Exception ex) {
      System.out.println("Error during write of prologue");
    }

  }
 
  /** Method to write out the epilogue for the new program:
   * Show the picture. Close the main and the class.
   * @param file BufferedWriter to write the epilogue to
   **/
  public void writeEpilogue(BufferedWriter file){
    try {
      // Write out the epilogue lines
      file.write("  frame.show();"); file.newLine();
      file.write("  } // end main()"); file.newLine();
      file.write("} // end class"); file.newLine();}
    catch (Exception ex) {
      System.out.println("Error during write of epilogue");
    }
  }
  
  /**
   * Method to compile the commands in the given file
   */
  public void compileCommands(String fileName)
  {
    String line = null;

    String [] params = null;
    int x1, y1, x2, y2, diameter;

    // try the following
    try {

      // read from the file
      BufferedReader reader =
        new BufferedReader(new FileReader(fileName));

      BufferedWriter writer =
        new BufferedWriter(new FileWriter(
      FileChooser.getMediaPath("GeneratedDrawing.java")));
        
      writePrologue(writer);
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
          
          // Now, write the line that will LATER
          // draw the line
          writer.write("  g.drawLine("+x1+","+y1+","+x2+","+y2+");");
          writer.newLine();
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
          writer.write("  g.drawOval("+x1+","+y1+","+diameter+","+
                       diameter+");");
          writer.newLine();
        }
        else {
          System.out.println("Uh-oh! Invalid command! "+line);
          return;}
        
      }
      writeEpilogue(writer);
      writer.close();

    } catch (FileNotFoundException ex) {
      System.out.println("Couldn't find file " + fileName);
      fileName = FileChooser.pickAFile();
      compileCommands(fileName);
    } catch (Exception ex) {
      System.out.println("Error during read or write");
      ex.printStackTrace();
    }

  }

  public static void main(String[] args)
  {
    GraphicsCompiler compiler = new GraphicsCompiler();
    String fileName = FileChooser.getMediaPath("graphics-commands.txt");
    compiler.compileCommands(fileName);

  }
}