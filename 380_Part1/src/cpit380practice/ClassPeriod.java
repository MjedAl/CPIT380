package cpit380practice;

import java.util.*;
import java.io.*;

/**
 * ClassPeriod represents a class period which has a teacher, 
 * a period number, and an array of students (max 35)
 */
public class ClassPeriod
{
  //////////////// fields /////////////////////////
  private String teacherName;
  private int periodNumber;
  private List studentList = new ArrayList();
  
  ///////////////// constructors //////////////////
  /**
   * No-argument constructor.  Leaves field values
   * alone
   */
  public ClassPeriod() {}
  
  /**
   * Constructor that takes just the teacher's name
   * @param name the name for the teacher
   */
  public ClassPeriod(String name) {  this.teacherName = name; }
  
  /**
   * Constructor that takes the teacher's name and period number
   * @param name the name for the teacher
   * @param num the period number
   */
  public ClassPeriod(String name, int num) 
  {
    this.teacherName = name;
    this.periodNumber = num;
  }
  
  /**
   * Constructor that takes the teacher's name, period number, 
   * and a file name that contains the student information
   * @param name the name for the teacher
   * @param num the period number
   * @param fileName the name of the file with the student 
   * information
   */
  public ClassPeriod(String name, int num, String fileName)
  {
    this.teacherName = name;
    this.periodNumber = num;
    loadStudentsFromFile(fileName);
  }
  
  /////////////////////////// methods ///////////////////////////
  
  /**
   * Method to get the teacher's name
   * @return the name of the teacher, or null if none yet
   */
  public String getTeacherName() { return this.teacherName; }
  
  /**
   * Method to get the period number
   * @return the number for this period
   */
  public int getPeriodNumber() { return this.periodNumber; }
  
  /**
   * Method to get a student based on the index
   * @return the student at this index
   */
  public Student getStudent(int index) 
  { 
    return (Student) this.studentList.get(index);
  }
  
  /**
   * Method to set the teacher's name
   * @param name the name to use
   */
  public void setTeacherName(String name) 
  { 
    this.teacherName = name; 
  }
  
  /**
   * Method to set the period number (if it hasn't been set)
   * @param num the number to use
   * @return flag to say if set worked
   */
  public boolean setPeriodNumber(int num)
  {
    if (this.periodNumber == 0)
    {
      this.periodNumber = num;
      return true;
    }
    else
      return false;
  }
  
  /**
   * Method to set the student at an index
   * @param studentObj the student object to use
   * @param index the index to set the student at
   */
  public void setStudent(Student studentObj, int index)
  {
    this.studentList.add(index,studentObj);
  }
  
  /**
   * Method to return the number of students in the period
   * @return the number of students in the period
   */
  public int getNumStudents() 
  {
    int total = 0;
    for (int i = 0; i < this.studentList.size(); i++)
    {
      if (this.studentList.get(i) != null)
        total++;
    }
    return total;
  }
  
  /**
   * Method to return a string of information about this class
   * period
   * @return information about the class period
   */
  public String toString() 
  { 
    return "Class Period " + this.periodNumber + 
      " taught by " + this.teacherName + " with " +
      this.getNumStudents() + " students";
  }
  
  /**
   * Method to read student information from a file and create 
   * a list of student objects
   * @param fileName the name of the file to read from
   * @param nameDelim the delimter between the name and grades
   * @param gradeDelim the delimiter between the grades
   */
  private void loadStudentsFromFile(String fileName)
  {
    String nameDelim = ":";
    String gradeDelim = ",";
    String line = null;
    try {
      
      // open the file for reading
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      // loop reading from the file
      while ((line = reader.readLine()) != null)
      {
        studentList.add(new Student(line,nameDelim,gradeDelim));
      }
    } catch (FileNotFoundException ex) {
      fileName = FileChooser.pickAFile();
      loadStudentsFromFile(fileName);
    } catch (Exception ex) {
      System.out.println("Exception while reading from file " + 
                         fileName);
      ex.printStackTrace();
    }
  }
  
  /**
   * Main method
   * @param args the arguments to execution
   */
  public static void main(String[] args)
  {
    ClassPeriod period = 
      new ClassPeriod("Ms. Clark",5,"student.txt");
    
    // print info about the class period
    System.out.println(period);
    
    // print info for each student 
    for (int i = 0; i < period.studentList.size(); i++)
      System.out.println("Student " + i + " is " + 
                         period.getStudent(i));
                      
  }
 
}