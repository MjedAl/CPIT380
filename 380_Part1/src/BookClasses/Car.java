package BookClasses;


/**
 * Class that describes a car.  A car has a manufacturer,
 * model, year, and number of doors
 * @author Barb Ericson ericson@cc.gatech.edu
 * Copyright 2006
 */
public class Car
{
  ////////////// fields ////////////////////////////
  
  /** the company that made the car */
  private String manufacturer;
  
  /** the model name for the car */
  private String model;
  
  /** the year the car was made */
  private String year;
  
  /** the number of doors on the car */
  private int numDoors;
  
  ////////////////// constructors //////////////////
  
  /**
   * Constructor that takes information on a car
   * @param theMake the manufacturer who made the car
   * @param theModel the model of the car
   * @param theYear the year the car was made
   * @param theNumDoors the number of doors
   */
  public Car(String theMake, String theModel, 
             String theYear, int theNumDoors)
  {
    this.manufacturer = theMake;
    this.model = theModel;
    this.year = theYear;
    this.numDoors = theNumDoors;
  }
  
  ////////////////// methods ///////////////////////
  
  /**
   * Method to get the manufacturer
   * @return the manufacturer of the car
   */
  public String getManufacturer()
  {
    return this.manufacturer;
  }
  
  /**
   * Method to get the model
   * @return the model of the car
   */
  public String getModel()
  {
    return this.model;
  }
  
  /**
   * Method to get the year
   * @return the year the car was made
   */
  public String getYear()
  {
    return this.year;
  }
  
  /**
   * Method to get the number of doors
   * @return the number of doors on the car
   */
  public int getNumDoors()
  {
    return this.numDoors;
  }
  
  /**
   * Method to set the manufacturer
   * @param make the make to use
   */
  public void setManufacturer(String make)
  {
    this.manufacturer = make;
  }
  
  /**
   * Method to set the model
   * @param theModel the model to use
   */
  public void setModel(String theModel)
  {
    this.model = theModel;
  }
  
  /**
   * Method to set the year
   * @param theYear the year to use
   */
  public void setYear(String theYear)
  {
    this.year = theYear;
  }
  
  /**
   * Method to set the number of doors
   * @param theNumDoors the number of doors to use
   */
  public void setNumDoors(int theNumDoors)
  {
    this.numDoors = theNumDoors;
  }
  
  /**
   * Method to return a string of info about the object
   * @return a string with info on this object
   */
  public String toString()
  {
    return this.manufacturer + " " + this.model + " " + 
      this.year + " " + this.numDoors;
  }
  
  /**
   * Method to test
   */
  public static void main(String[] args)
  {
    Car carObj = new Car("Toyota","Camry","2000",4);
    System.out.println(carObj);
    carObj.setNumDoors(2);
    System.out.println(carObj);
  }

}