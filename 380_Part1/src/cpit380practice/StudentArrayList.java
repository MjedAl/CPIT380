package cpit380practice;

import java.io.*;
import java.util.*;

/**
 * Class that describes a student.  A student has a name and a
 * list of grades.  You can get information about a student 
 * such as her/his name and grade average.  A student may
 * also have a picture.
 * 
 * @author Barb Ericson 
 */
public class StudentArrayList
{
  
  //////////// fields //////////////////
  /** the name of the student: first last */
  private String name;
  /** a list of grades for this student */
  private List<Double> gradeList;
  /** a picture of this student */
  private Picture picture;
  
  //////////// constructors ///////////
  
  /**
   * No argument constructor.  Creates the
   * grade list.
   */
  public StudentArrayList() 
  {
    this.gradeList = new ArrayList<Double>();
  }
  
  /**
   * Constructor that takes the name
   * @param theName the student's name
   */
  public StudentArrayList(String theName) 
  {
    this.name = theName;
    this.gradeList = new ArrayList<Double>();
  }
  
  /**
   * Constructor that takes a name and 
   * the number of grades
   * @param theName the student's name
   * @param numGrades the number of grades
   */
  public StudentArrayList(String theName, int numGrades)
  {
    this.name = name;
    this.gradeList = new ArrayList<Double>(numGrades);
  }

  /**
   * Constructor that takes the name
   * and an array of grades
   * @param theName the student's name
   * @param theGradeList the list of grades
   */
  public StudentArrayList(String theName, 
                 List<Double> theGradeList)
  {
    this.name = theName;
    this.gradeList = theGradeList;
  }
  
  /**
   * Constructor that takes a delimited string, the 
   * name delimiter, and the grade delimiter.  It fills
   * in the fields from the delimited string.
   * @param delimString student information as a 
   * delimited string
   * @param nameDelim what delimits the name field 
   * from the grades
   * @param gradeDelim what delimits the grades
   */
  public StudentArrayList(String delimString, 
                 String nameDelim, 
                 String gradeDelim)
  {
    // split string based on name delimiter
    String[] splitArray = delimString.split(nameDelim);
    this.name = splitArray[0].trim();
    
    // get the grade string and break it and convert to double
    this.gradeList = new ArrayList<Double>();
    String grades = splitArray[1];
    String[] gradeStrArray = null;
    if (grades != null)
    {
      gradeStrArray = grades.split(gradeDelim);
      for (int i = 0; i < gradeStrArray.length; i++)
      {
        gradeList.add(Double.parseDouble(gradeStrArray[i]));
      }
    }
  }

  /////////// methods ///////////////
  
  /**
   * Method to get the picture for this 
   * student
   * @return the picture (may be null)
   */
  public Picture getPicture() 
  { return this.picture; }
  
  /**
   * Method to set the picture for this 
   * student
   * @param thePicture the picture to use
   */
  public void setPicture(Picture thePicture)
  {
    this.picture = thePicture;
  }
  
  /**
   * Method to show this student
   * It will display the picture if there
   * is one else just print the student name
   */
  public void show()
  {
    if (this.picture == null)
    {
      // use toString
      System.out.println(this);
    }
    else 
    {
      this.picture.show();
    }
  } 
  
  /**
   * Method to return the name of this student
   * @return the student's name
   */
  public String getName() { return this.name; }
  
  /**
   * Method to set the name for this student
   * @param theName the new name to use
   * @return true if success else false
   */
  public boolean setName(String theName)
  {
    boolean result = false;
    if (this.name == null)
    {
      this.name = theName;
      result = true;
    }
    return result;
  }
  
  /**
   * Method to get the grade in the grade array
   * at the passed index
   * @param index the index that we want the grade for
   * @return the grade in the grade list at this passed index
   */
  public double getGrade(int index)
  {
    return this.gradeList.get(index);
  }
  
  /**
   * Method to replace the list of grades
   * @param theGradeList the list of grades to use
   * @return true if sucess, else false
   */
  public boolean setGradeList(List<Double> theGradeList)
  {
    boolean result = false;

    // only set the gradeArray if it is null
    if (this.gradeList == null)
    {
      this.gradeList = theGradeList;
      result = true;
    }
    return result;
  }
  
  /**
   * Method to set a grade at an index
   * @param index the index to set it at
   * @param newGrade the grade to use
   * @return true if success else false
   */
  public boolean setGrade(int index, 
                          double newGrade)
  {
    boolean result = false;
    if (newGrade >= 0 || 
        this.gradeList != null ||
        index >= 0) {
      this.gradeList.set(index,newGrade);
      result = true;
    }
    return result;
  }

  
  /**
   * Method to return the average of the grades for this student
   * @return the average of the grades or 0.0 if no grade array or
   * no grades 
   */
  public double getAverage()
  {
    double average = 0.0;

    if (this.gradeList != null && this.gradeList.size() > 0)
    {
      double sum = 0.0;
      for (double value : gradeList)
      {
        sum = sum + value;
      }
      average = sum / this.gradeList.size();
    }
    return average;
  }
  
  
  /**
   * Method to return a string with information about this student
   * @return a string with information about the student
   */
  public String toString() {
    return "StudentArrayList object named: " + this.name + 
           " Average: " + this.getAverage();
  }
  
  /* Used to test */
//  public static void main (String[] args)
//  {
//    Student student1 = new Student("Barb Ericson");
//    System.out.println(student1);
//    double[] gradeArray1 = {90,88,95,96,93};
//    Student student2 = new Student("Mark Guzdial",gradeArray1);
//    System.out.println(student2);
//    Picture barb = new Picture(FileChooser.getMediaPath("barbara.jpg"));
//    student1.setPicture(barb);
//    student1.show();
//    student2.show();
//  }
  
  /**
   * Method to compare the current student
   * with a passed in object
   * @param o the object passed in
   * @return negative if the current student
   * is less than the passed object
   * 0 if they are equal
   * Positive if the current student is 
   * greater than the passed in object
   * Warning this will say two students
   * with the same name are equal!
   */
  public int compareTo(Object o)
  {
    StudentArrayList testStudent = (StudentArrayList) o;
    return this.name.compareTo(testStudent.name);  
  }
  
  /* Used to test */
  public static void main (String[] args)
  {
    // test the constructor that takes a delimited string
    StudentArrayList student3 = 
      new StudentArrayList("Susan Ericson:50,60,70,80,90,100",":",",");
    System.out.println(student3); 
  }
}