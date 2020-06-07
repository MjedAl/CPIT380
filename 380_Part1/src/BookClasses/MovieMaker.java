package BookClasses;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Class to create frames for a movie
 * @author Barb Ericson
 */
public class MovieMaker
{
  
  ///////////////// fields ///////////////////////////////
  private Random randNumGen = new Random();
  
  /**
   * Method to make a movie that has a rectangle moving 
   * around
   * @param directory the directory to put the movie
   * frames
   */
  public void makeRectangleMovie(String directory)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    frameSequencer.setShown(true);
    
    // loop through the first second
    for (int i = 0; i < framesPerSec; i++)
    {
      // draw a filled rectangle
      p = new Picture(640,480);
      g = p.getGraphics();
      g.setColor(Color.RED);
      g.fillRect(i * 10, i * 5, 50,50);
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to make a movie that has a rectangle moving 
   * from top right to bottom left
   * @param directory the directory to put the movie
   * frames
   */
  public void makeRectMovieTopRightToBotLeft(String directory)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    frameSequencer.setShown(true);
    
    // loop through the first second
    for (int i = 0; i < framesPerSec; i++)
    {
      // draw a filled rectangle
      p = new Picture(640,480);
      g = p.getGraphics();
      g.setColor(Color.RED);
      g.fillRect(590 - (i * 10), i * 10, 50,50);
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to make a movie that has a oval moving 
   * from bottom left to top right
   * @param directory the directory to put the movie
   * frames
   */
  public void makeOvalMovie(String directory)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    frameSequencer.setShown(true);
    
    // loop through the first second
    for (int i = 0; i < framesPerSec; i++)
    {
      // draw a filled oval
      p = new Picture(640,480);
      g = p.getGraphics();
      g.setColor(Color.RED);
      g.fillOval(i * 10, 430 - (i * 10), 50,50);
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a tickertape movie
   * @param directory the directory to write to
   * @param message the string to display
   */
  public void makeTickerTapeMovie(String directory, 
                                  String message)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    Font font = new Font("Arial",Font.BOLD,24);
    
    // loop for 2 seconds of animation
    for (int i = 0; i < framesPerSec * 2; i++)
    {
      // draw the string
      p = new Picture(300,100);
      g = p.getGraphics();
      g.setColor(Color.BLACK);
      g.setFont(font);
      g.drawString(message,300 - (i * 10), 50);
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a tickertape movie that moves
   * from bottom to top
   * @param directory the directory to write to
   * @param message the string to display
   */
  public void makeTickerTapeMovieBotTop(String directory, 
                                  String message)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    Font font = new Font("Arial",Font.BOLD,24);
    
    // loop for 2 seconds of animation
    for (int i = 0; i < framesPerSec * 2; i++)
    {
      // draw the string
      p = new Picture(300,200);
      g = p.getGraphics();
      g.setColor(Color.BLACK);
      g.setFont(font);
      g.drawString(message,10, 190 - (i * 2));
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a tickertape movie that moves
   * from top left to bottom right
   * @param directory the directory to write to
   * @param message the string to display
   */
  public void makeTickerTapeMovieTopBot(String directory, 
                                  String message)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    Font font = new Font("Arial",Font.BOLD,24);
    
    // loop for 2 seconds of animation
    for (int i = 0; i < framesPerSec * 2; i++)
    {
      // draw the string
      p = new Picture(300,200);
      g = p.getGraphics();
      g.setColor(Color.BLACK);
      g.setFont(font);
      g.drawString(message,10 + (i * 2), 10 + (i * 2));
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to make a movie that has a two rectangles moving 
   * around
   * @param directory the directory to put the movie
   * frames
   */
  public void makeTwoRectangleMovie(String directory)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    
    // loop through the first second
    for (int i = 0; i < framesPerSec; i++)
    {
      // draw a filled rectangle
      p = new Picture(640,480);
      g = p.getGraphics();
      g.setColor(Color.RED);
      g.fillRect(i * 10, i * 5, 50,50);
      g.setColor(Color.BLUE);
      g.fillRect(100 + (int) (10 * Math.sin(i)),
                 4 * i + (int) (10 * Math.cos(i)),
                 50,50);
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to return a random amount added to i < 5 but
   * checking not to exceed the given max
   * @param i the current value
   * @param max the max for this direction (x or y)
   * @return i + some random amount < 5
   */
  private int getRandomExtra(int i, int max)
  {
    int value = i + randNumGen.nextInt(5);
    if (value > max)
      value = max - 5;
    return value;
  }
  
  /**
   * Method to make a movie that has a two rectangles moving 
   * around by adding a random amount less than 5 pixels 
   * @param directory the directory to put the movie
   * frames
   */
  public void makeTwoRectangleRandMovie(String directory)
  {
    int framesPerSec = 30;
    Picture p = null;
    Graphics g = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    
    // loop through the first second
    for (int i = 0; i < framesPerSec; i++)
    {
      // draw a filled rectangle
      p = new Picture(640,480);
      g = p.getGraphics();
      g.setColor(Color.RED);
      
      g.fillRect(getRandomExtra(i,639),
                 getRandomExtra(i,479)
                   ,50,50);
      g.setColor(Color.BLUE);
      g.fillRect(getRandomExtra(i+100,639),
                 getRandomExtra(i,479),
                 50,50);
      
      // add frame to sequencer
      frameSequencer.addFrame(p);
    }
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to move Mark's head around
   */
  public void moveMarksHead(String directory)
  {
    // load the picture of Mark
    String fName = FileChooser.getMediaPath("blue-Mark.jpg");
    Picture markP = new Picture(fName);
    
    // declare other variables
    Picture target = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      target = new Picture(640,480);
      target.copy(markP,281,164,382,301,i * 10, i * 5);
      frameSequencer.addFrame(target);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to slowly create a sunset
   * @param directory the directory to write to
   */
  public void makeSunsetMovie(String directory)
  {
    // load the picture of the beach
    String fName = FileChooser.getMediaPath("beach-smaller.jpg");
    Picture beachP = new Picture(fName);
    
    // declare other variables
    Picture target = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      beachP.makeSunset(0.95);
      frameSequencer.addFrame(beachP);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to slowly create a sunset and after 
   * a certain amount of reduction make the picture fade
   * to black
   * @param directory the directory to write to
   */
  public void makeSunsetMovie2(String directory, double threshold)
  {
    // load the picture of the beach
    String fName = FileChooser.getMediaPath("beach-smaller.jpg");
    Picture beachP = new Picture(fName);
    double amountReduction = 1;
    Picture blackP = new Picture(beachP.getWidth(),beachP.getHeight(),
                                 Color.BLACK);
    
    // declare other variables
    Picture temp = null;
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      temp = new Picture(beachP);
      amountReduction = amountReduction * 0.95;
      if (amountReduction < threshold)
      {
        temp.modifyTowards(blackP,i,framesPerSec);
      }
      else
      {
        temp.makeSunset(amountReduction);
      }
       frameSequencer.addFrame(temp);
      
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
   /**
   * Method to create a movie that fades out the person from
   * one background to another.
   * @param directory the directory to write to
   */
  public void makeFadeOutMovie(String directory)
  {
    // load the pictures
    String kidF = FileChooser.getMediaPath("kid-in-frame.jpg");
    Picture kidP = null;
    String wallF = FileChooser.getMediaPath("bgframe.jpg");
    Picture wallP = new Picture(wallF);
    String beachF = FileChooser.getMediaPath("beach.jpg");
    Picture beachP = new Picture(beachF);

    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;

    // loop creating the frames
    for (int i = 0; i < framesPerSec * 2; i++)
    {
      kidP = new Picture(kidF);
      kidP.swapBackground(wallP,beachP,i);
      frameSequencer.addFrame(kidP);
    }

    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a movie that fades out the person
   * @param directory the directory to write to
   */
  public void makeFadeOutMovie2(String directory)
  {
    // load the pictures
    String kidF = FileChooser.getMediaPath("kid-in-frame.jpg");
    Picture kidP = null;
    String wallF = FileChooser.getMediaPath("bgframe.jpg");
    Picture wallP = new Picture(wallF);
    String bgF = FileChooser.getMediaPath("bgframe.jpg");
    Picture bgP = new Picture(bgF);

    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;

    // loop creating the frames
    for (int i = 0; i < framesPerSec * 2; i++)
    {
      kidP = new Picture(kidF);
      kidP.swapBackground(wallP,bgP,i);
      frameSequencer.addFrame(kidP);
    }

    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to make a movie of barb's head moving
   * and katie dancing
   * @param dir the directory to read from and write to
   */
  public void makeMommyWatchingMovie(String dir)
  {
    String barbF = FileChooser.getMediaPath("barbaraS.jpg");
    String katieDir = 
      FileChooser.getMediaPath("kid-in-bg-seq/");
    Picture barbP = new Picture(barbF);
    FrameSequencer frameSequencer = new FrameSequencer(dir);
    Picture currP = null;
    
    // get the array of files in the directory
    File dirObj = new File(katieDir);
    String[] fileArray = dirObj.list();
    
    // loop through the array of files
    for (int i = 0; i < fileArray.length; i++)
    {
      if (fileArray[i].indexOf(".jpg") >= 0)
      {
        currP = new Picture(katieDir + fileArray[i]);
        currP.copy(barbP,22,9,93,97,i * 3, i * 3);
        frameSequencer.addFrame(currP);
      }
    }
    
    // play the movie
    frameSequencer.play(30);
  }
  
  /**
   * Method to make a movie a turtle moving across the 
   * movie of the blowhole
   * @param dir the directory to read from and write to
   */
  public void makeTurtleBlowholeMovie(String dir)
  {
    String turtleF = FileChooser.getMediaPath("turtle.jpg");
    String blowholeDir = 
      FileChooser.getMediaPath("blowhole/");
    Picture turtleP = new Picture(turtleF);
    FrameSequencer frameSequencer = new FrameSequencer(dir);
    Picture currP = null;
    
    // get the array of files in the directory
    File dirObj = new File(blowholeDir);
    String[] fileArray = dirObj.list();
    
    // loop through the array of files
    for (int i = 0; i < fileArray.length; i++)
    {
      if (fileArray[i].indexOf(".jpg") >= 0)
      {
        currP = new Picture(blowholeDir + fileArray[i]);
        currP.copy(turtleP,i,150);
        frameSequencer.addFrame(currP);
      }
    }
    
    // play the movie
    frameSequencer.play(30);
  }
  
  /**
   * Method to make a movie of the kids crawling on the moon
   * @param dir the directory to write the frames to
   */
  public void makeKidsOnMoonMovie(String dir)
  {
    String kidsDir = FileChooser.getMediaPath("kids-blue/");
    String moonF = FileChooser.getMediaPath("moon-surface.jpg");
    Picture moonP = new Picture(moonF);
    FrameSequencer frameSequencer = new FrameSequencer(dir);
    Picture currP = null;
    
    // get the array of files in the directory
    File dirObj = new File(kidsDir);
    String[] fileArray = dirObj.list();
    
    // loop through the array of files
    for (int i = 0; i < fileArray.length; i++)
    {
      if (fileArray[i].indexOf(".jpg") >= 0)
      {
        currP = new Picture(kidsDir + fileArray[i]);
        currP.chromakey(moonP,Color.black,100.0);
        frameSequencer.addFrame(currP);
      }
    }
    
    // play the movie
    frameSequencer.play(30);
  }
  
  /**
   * Method to make a movie of the kids crawling on the beach
   * @param dir the directory to write the frames to
   */
  public void makeKidsOnBeachMovie(String dir)
  {
    String kidsDir = FileChooser.getMediaPath("kids-blue/");
    String beachF = FileChooser.getMediaPath("beach.jpg");
    Picture beachP = new Picture(beachF);
    FrameSequencer frameSequencer = new FrameSequencer(dir);
    Picture currP = null;
    
    // get the array of files in the directory
    File dirObj = new File(kidsDir);
    String[] fileArray = dirObj.list();
    
    // loop through the array of files
    for (int i = 0; i < fileArray.length; i++)
    {
      if (fileArray[i].indexOf(".jpg") >= 0)
      {
        currP = new Picture(kidsDir + fileArray[i]);
        currP.chromakey(beachP,Color.black,100.0);
        frameSequencer.addFrame(currP);
      }
    }
    
    // play the movie
    frameSequencer.play(30);
  }
  
  /**
   * Method to lighten the pixels that are near black in 
   * a movie
   * @param dir the directory to write the frames to
   */
  public void makeLighterMovie(String dir)
  {
    String movieDir = FileChooser.getMediaPath("dark-fish2/");
    FrameSequencer frameSequencer = new FrameSequencer(dir);
    Picture currP = null;
    
    // get the array of files in the directory
    File dirObj = new File(movieDir);
    String[] fileArray = dirObj.list();
    
    // loop through the array of files
    for (int i = 0; i < fileArray.length; i++)
    {
      if (fileArray[i].indexOf(".jpg") >= 0)
      {
        currP = new Picture(movieDir + fileArray[i]);
        currP.lighten(Color.BLACK,8,5);
        frameSequencer.addFrame(currP);
      }
    }
    
    // play the movie
    frameSequencer.play(30);
  }
  
  /**
   * Method to change the red and green values in the frames
   * @param dir the directory to write the frames to
   */
  public void makeFishMovie(String dir)
  {
    String movieDir = FileChooser.getMediaPath("fish/");
    FrameSequencer frameSequencer = new FrameSequencer(dir);
    Picture currP = null;
    
    // get the array of files in the directory
    File dirObj = new File(movieDir);
    String[] fileArray = dirObj.list();
    
    // loop through the array of files
    for (int i = 0; i < fileArray.length; i++)
    {
      if (fileArray[i].indexOf(".jpg") >= 0)
      {
        currP = new Picture(movieDir + fileArray[i]);
        currP.changeRedAndGreen(2.0,1.5);
        frameSequencer.addFrame(currP);
      }
    }
    
    // play the movie
    frameSequencer.play(16);
  }
  
  /**
   * Method to create a sepia-toned movie
   * @param p the picture to use in the movie
   * @param directory the directory to store the frames in
   */
  public void makeSepiaMovie(Picture p, String directory)
  {
    // make a copy of the picture
    Picture copyPict = null;
    Picture origPict = new Picture(p);
    
    // make a sepia-toned picture
    p.sepiaTint();
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(origPict);
      copyPict.modifyTowards(p,i,framesPerSec);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a movie where the picture changes
   * to the negative image
   * @param p the picture to use in the movie
   * @param directory the directory to store the frames in
   */
  public void makeNegativeMovie(Picture p, String directory)
  {
    // make a copy of the picture
    Picture copyPict = null;
    Picture origPict = new Picture(p);
    
    // make a negative picture
    p.negate();
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(origPict);
      copyPict.modifyTowards(p,i,framesPerSec);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a posterized movie
   * @param p the picture to use in the movie
   * @param directory the directory to store the frames in
   */
  public void makePosterizedMovie(Picture p, String directory)
  {
    // make a copy of the picture
    Picture copyPict = null;
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(p);
      copyPict.posterize(30 - i);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a posterized movie
   * @param p the picture to use in the movie
   * @param directory the directory to store the frames in
   */
  public void makeEdgeDetectMovie(Picture p, String directory)
  {
    // make a copy of the picture
    Picture copyPict = null;
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(p);
      copyPict.edgeDetection(31-i);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a movie where one picture blends
   * into the other
   * @param directory the directory to store the frames in
   */
  public void makeBlendedMovie(String directory)
  {
    // get the pictures to blend
    Picture pict1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
    Picture pict2 = new Picture(FileChooser.getMediaPath("blueShrub.jpg"));
    Picture copyPict = null;
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(pict1);
      copyPict = 
        copyPict.blendPictures(pict2,((double) i) / framesPerSec);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a movie where a turtle crawls 
   * across the beach
   * @param directory the directory to store the frames in
   */
  public void makeTurtleMovie(String directory)
  {
    // get the pictures to use
    Picture pict1 = new Picture(FileChooser.getMediaPath("beach.jpg"));
    Picture pict2 = new Picture(FileChooser.getMediaPath("turtle.jpg"));
    Picture copyPict = null;
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(pict1);
      copyPict.copy(pict2,i + 7, 300);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a movie where a robot crawls 
   * across the moon
   * @param directory the directory to store the frames in
   */
  public void makeRobotMovie(String directory)
  {
    // get the pictures to use
    Picture pict1 = new Picture(FileChooser.getMediaPath("moon-surface.jpg"));
    Picture pict2 = new Picture(FileChooser.getMediaPath("robot.jpg"));
    Picture copyPict = null;
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      copyPict = new Picture(pict1);
      copyPict.copy(pict2,i + 7, 300);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  /**
   * Method to create a rotating image movie
   * @param p the picture to rotate
   * @param directory the directory to store the frames in
   */
  public void makeRotatingMovie(Picture p, String directory)
  {
    // make a copy of the picture
    Picture tempPict = null;
    int max = Math.max(p.getWidth(), p.getHeight());
    Picture copyPict = null;
    
    // declare other variables
    FrameSequencer frameSequencer = 
      new FrameSequencer(directory);
    int framesPerSec = 30;
    
    // loop creating the frames
    for (int i = 0; i < framesPerSec; i++)
    {
      tempPict = new Picture(p);
      tempPict = tempPict.rotate(i * 5);
      copyPict = new Picture(max,max);
      copyPict.copy(tempPict,0,0);
      frameSequencer.addFrame(copyPict);
    } 
    
    // play the movie
    frameSequencer.play(framesPerSec);
  }
  
  public static void main(String[] args)
  {
    MovieMaker movieMaker = new MovieMaker();
    //String dir = "c:/intro-prog-java/movies/rectangle/";
    //movieMaker.makeRectangleMovie(dir);
    //String dir = "c:/intro-prog-java/movies/tickertape/";
    //movieMaker.makeTickerTapeMovie(dir,"Buy more widgets");
    //String dir = "c:/intro-prog-java/movies/rectangle2/";
    //movieMaker.makeTwoRectangleMovie(dir);
    //String dir = "c:/intro-prog-java/movies/mark/";
    //movieMaker.moveMarksHead(dir);
    //String dir = "c:/intro-prog-java/movies/sunset/";
    // movieMaker.makeSunsetMovie(dir);
    //String dir = "c:/intro-prog-java/movies/fade/";
    //movieMaker.makeFadeOutMovie(dir);
    //String dir = "c:/intro-prog-java/movies/mommy/";
    //movieMaker.makeMommyWatchingMovie(dir);
    //String dir = "c:/intro-prog-java/movies/moon/";
    //movieMaker.makeKidsOnMoonMovie(dir);
    //String dir = "c:/intro-prog-java/movies/lighter/";
    //movieMaker.makeLighterMovie(dir);
    //String dir = "c:/intro-prog-java/movies/fish/";
    //movieMaker.makeFishMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/sepia/";
//    Picture p = new Picture(FileChooser.getMediaPath("gorge.jpg"));
//    movieMaker.makeSepiaMovie(p,dir);
    
//    String dir = "c:/intro-prog-java/movies/poster/";
//    Picture p = new Picture(FileChooser.getMediaPath("tammy.jpg"));
//    movieMaker.makePosterizedMovie(p,dir);
    
//    String dir = "c:/intro-prog-java/movies/negate/";
//    Picture p = new Picture(FileChooser.getMediaPath("caterpillar.jpg"));
//    movieMaker.makeNegativeMovie(p,dir);
    
//    String dir = "c:/intro-prog-java/movies/rotate/";
//    Picture p = new Picture(FileChooser.getMediaPath("flower1.jpg"));
//    movieMaker.makeRotatingMovie(p,dir);
    
//    String dir = "c:/intro-prog-java/movies/beach/";
//    movieMaker.makeKidsOnBeachMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/fade2/";
//    movieMaker.makeFadeOutMovie2(dir);
    
//    String dir = "c:/intro-prog-java/movies/blend/";
//    movieMaker.makeBlendedMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/turtle/";
//    movieMaker.makeTurtleMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/robot/";
//    movieMaker.makeRobotMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/oval/";
//    movieMaker.makeOvalMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/rectTopRBotL/";
//    movieMaker.makeRectMovieTopRightToBotLeft(dir);
    
//    String dir = "c:/intro-prog-java/movies/tickerTapeBotTop/";
//    movieMaker.makeTickerTapeMovieBotTop(dir, "Talk like a pirate day!");
    
//    String dir = "c:/intro-prog-java/movies/tickerTapeTopLBotR/";
//    movieMaker.makeTickerTapeMovieTopBot(dir, "Talk like a pirate day!");
    
//    String dir = "c:/intro-prog-java/movies/turtleBlowhole/";
//    movieMaker.makeTurtleBlowholeMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/randRects/";
//    movieMaker.makeTwoRectangleRandMovie(dir);
    
//    String dir = "c:/intro-prog-java/movies/sunset2/";
//    movieMaker.makeSunsetMovie2(dir,0.28);
//    
    String dir = "c:/intro-prog-java/movies/edge/";
    Picture p = new Picture(FileChooser.getMediaPath("horse.jpg"));
    movieMaker.makeEdgeDetectMovie(p,dir);

  }
      
}