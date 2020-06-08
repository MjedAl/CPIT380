package cpit380practice;

import java.util.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }
  
  /////////////////// methods ///////////////////////
  
  /** 
   * Method to draw a square with a width and height
   * of 30 
   */
  public void drawSquare()
  {
    this.turnRight();
    this.forward(30);
    this.turnRight();
    this.forward(30);
    this.turnRight();
    this.forward(30);
    this.turnRight();
    this.forward(30);
  }
  
  /**
   * Method to draw a square with a width and height
   * of 30. Second version
   */
  public void drawSquare2()
  {
    int width = 30;
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
  }
  
  /**
   * Method to draw a square with a width and height
   * of some passed amount.
   * @param width the width and height to use
   */
  public void drawSquare(int width)
  {
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(width);
  }
  
   /**
   * Method to draw a rectangle with a width and height
   * of some passed amount.
   * @param width the width to use
   * @param height the height to use
   */
  public void drawRectangle(int width, int height)
  {
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(height);
    this.turnRight();
    this.forward(width);
    this.turnRight();
    this.forward(height);
  }
  
  /**
   * Method to draw a hexagon.  A hexagon
   * has interior angles of 120.  See  
   * http://www.coolmath4kids.com/interior.html
   * @param width the width of a side
   */
  public void drawHexagon(int width)
  {
    this.turn(30);
    this.forward(width);
    this.turn(60);
    this.forward(width);
    this.turn(60);
    this.forward(width);
    this.turn(60);
    this.forward(width);
    this.turn(60);
    this.forward(width);
    this.turn(60);
    this.forward(width);
    this.turn(60);
  }
  
  /**
   * Method to draw a pentagon.  A pentagon
   * has interior angles of 108.  See
   * http://www.coolmath4kids.com/interior.html.
   * @param width the width of a side
   */
  public void drawPentagon(int width)
  {
    this.turn(30);
    this.forward(width);
    this.turn(72);
    this.forward(width);
    this.turn(72);
    this.forward(width);
    this.turn(72);
    this.forward(width);
    this.turn(72);
    this.forward(width);
    this.turn(72);
  }
  
  /**
   * Method to draw an equilateral triangle
   * This has interior angles of 60.
   * See
   * http://www.coolmath4kids.com/interior.html.
   */
  public void drawEquilateralTriangle(int width)
  {
    this.turn(30);
    this.forward(width);
    this.turn(120);
    this.forward(width);
    this.turn(120);
    this.forward(width);
    this.turn(90);
  }
  
  /**
   * Method to draw a star
   * @param len the length of each side
   */
  public void drawStar(int len)
  {
    this.turn(18);
    this.forward(len);
    this.turn(144);
    this.forward(len);
    this.turn(144);
    this.forward(len);
    this.turn(144);
    this.forward(len);
    this.turn(144);
    this.forward(len);
    this.turn(126);
  }
  
  /**
   * Method to draw an arrow 
   * @param length the length of the straight part
   * @param arrowWidth the width of the arrow part
   */
  public void drawArrow(int length,int arrowWidth)
  {
    this.forward(length);
    this.penUp();
    this.turnLeft();
    this.forward(arrowWidth / 2);
    this.turnRight();
    this.penDown();
    this.drawEquilateralTriangle(arrowWidth);
  }
  
  /**
   * Method to draw a flower shape using
   * squares
   */
  public void drawFlower()
  {
    this.forward(60);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
    this.drawSquare(20);
    this.turn(36);
  }
  
  /**
   * Method to draw a pyramid
   */
  public void drawPyramid()
  {
    this.drawRectangle(100,50);
    this.penUp();
    this.turnRight();
    this.forward(100);
    this.penDown();
    this.turnLeft();
    this.drawRectangle(100,50);
    this.penUp();
    this.forward(50);
    this.penDown();
    this.drawRectangle(100,50);
    this.penUp();
    this.turnRight();
    this.forward(100);
    this.turnRight();
    this.forward(50);
    this.turn(180);
    this.penDown();
    this.drawRectangle(100,50);
  }
    
  /**
   * Method to draw a 'flower' of squares
   * @param width the width of each square
   * @param amountTurn the amount to turn the turtle each time
   */
  public void drawRectFlower(int width, 
                             int amountTurn)
  {
    for (int i = 0; i <= 360; i=i+amountTurn)
    {
      this.drawSquare(width);
      this.turn(amountTurn);
    }
  }
  
  /**
   * Method to draw a 'spiral' of squares
   * @param width the width of the first square
   * @param amountTurn the amount to turn the turtle each time
   */
  public void drawRectSpiral(int width, 
                             int amountTurn)
  {
    for (int i = 0; i <= 360; i=i+amountTurn)
    {
      this.drawSquare(width);
      width = width + 3;
      this.turn(amountTurn);
    }
  }
  
  /**
   * Method to draw a flower of triangles
   */
  public void drawTriangleFlower(int length, 
                                 int amountTurn)
  {
    for (int i = 0; i <= 360; i=i+amountTurn)
    {
      this.drawTriangle(length);
      this.turn(amountTurn);
    }
  }
 
  
  /**
   * Recursive method to draw a tree structure
   * @param branchLength the length of the 
   * current branch
   */
  public void drawTree(int branchLength)
  {
    
    // only continue if the branch is greater than 5
    if (branchLength > 5)
    {
      // move this turtle forward by the branch length
      this.forward(branchLength);
      
      // modify the length of the next branches
      branchLength = (int) (0.8 * branchLength);
      
      // get the current turtle values
      int x = this.getXPos();
      int y = this.getYPos();
      ModelDisplay display = this.getModelDisplay();
      
      // create a child to handle the left branch
      Turtle leftChild = new Turtle(x,y,display);
      leftChild.setHeading(this.getHeading());
      leftChild.turn(-30);
      leftChild.drawTree(branchLength);
      
      // create a child to handle the right branch
      Turtle rightChild = new Turtle(x,y,
                                this.getModelDisplay());
      rightChild.setHeading(this.getHeading());
      rightChild.turn(30);
      rightChild.drawTree(branchLength);
    }
    // don't show the turtle
    this.setVisible(false); 
  }
  
  /**
   * Method to make the turtles dance
   */
  public static void dance() 
    throws java.lang.Exception  
  {
    World w = new World();
    w.setAutoRepaint(false);
    Turtle[] turtleArray = new Turtle[11];
    
    // create the turtles
    for (int i = 0; i < turtleArray.length; i++)
    {
      turtleArray[i] = new Turtle(w);
      turtleArray[i].turn(i * 36);
    }
    w.repaint();
    Thread.sleep(1000);
    
    // dance
    for (int i = 5; i < 30; i=i+5) {
      for (int j = 1; j < turtleArray.length; j++) {
      turtleArray[j].forward(i);
      turtleArray[j].turn(10);
      }
      w.repaint();
      Thread.sleep(1000);
    }
  }
  
  /**
   * Method to draw an equailateral triangle
   * @param length the length of the sides
   */
  public void drawTriangle(int length)
  {
    turn(30);
    forward(length);
    turn(120);
    forward(length);
    turn(120);
    forward(length);
    turn(90);
  }
  
  /**
   * Method to draw a letter T with a 
   * height of 100 and a cross bar of
   * 80
   */
  public void drawT()
  {
    this.forward(100);
    this.turnLeft();
    this.penUp();
    this.forward(40);
    this.turn(180);
    this.penDown();
    this.forward(80);
    this.hide();
  }
  
  /**
   * Method to draw a T of a given height
   * @param height the height of the T
   * the cross bar will be .8 of the height
   */
  public void drawT(int height)
  {
    int lengthCrossBar = (int) (height * 0.8);
    this.forward(height);
    this.turnLeft();
    this.penUp();
    this.forward(lengthCrossBar / 2);
    this.turn(180);
    this.penDown();
    this.forward(lengthCrossBar);
    this.hide();
  }
  
  /**
   * Method to draw the letter A
   * with angles of 75, 75, and 30
   * and sides of length 100, 100 
   * and a cross bar of 20 at length
   * 60 from the bottom
   */
  public void drawA()
  {
    this.turn(15);
    this.forward(100);
    this.turn(150);
    this.forward(100);
    this.penUp();
    this.turn(180);
    this.forward(60);
    this.turn(-75);
    this.penDown();
    this.forward(20);
    this.hide();
  }
  
  /**
   * Method to take an array of pictures and drop them
   * in a circle
   * @param pictArray the array of pictures to drop
   * @param radius the radius of the circle
   */
  public void dropPicturesInCircle(Picture[] pictArray, int radius)
  {
    int turnAmount = (int) (360.0 / pictArray.length);
    for (int i = 0; i < pictArray.length; i++)
    {
      this.forward(radius);
      this.drop(pictArray[i]);
      this.backward(radius);
      this.turn(turnAmount);
    }
  }

  public static void main(String[] args) throws Exception
  {
    World w = new World();
    w.setAutoRepaint(false);
    Turtle t = new Turtle(320,480,w);
    t.drawTree(100);
    w.repaint();
  }  
  
} // end of class (do not remove this and put new methods before it)