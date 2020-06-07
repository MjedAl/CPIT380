package BookClasses;


/**
 * Class that represents information about a person
 * @author Barb Ericson
 */
public class Person
{
  ///////////////// fields /////////////////////////
  
  private int id; 
  private String firstName;
  private String lastName;
  private Picture picture;
  private int age;
  
  ///////////////// Constructors ///////////////////
  
  /**
   * No-arg constructor.  All fields have their default
   * values
   */
  public Person() {}
  
  /**
   * Constructor that takes a person's first and last name
   * @param firstName the first name for this person
   * @param lastName the last name for this person
   */
  public Person(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  /**
   * Constructor that takes the first name, last name, picture
   * and age
   * @param firstName the first name for this person
   * @param lastName the last name for this person
   * @param picture a picture of this person
   * @param age the age of this person
   */
  public Person(int id, String firstName, String lastName,
                Picture picture, int age)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.picture = picture;
    this.age = age;
  }
  
  //////////////// methods /////////////////////////////////
  
  /**
   * Method to 
   */
  
  
}