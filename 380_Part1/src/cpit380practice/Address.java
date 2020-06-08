package cpit380practice;


/**
 * Class that represents an Address
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Address
{
  ////////////// fields ////////////////////
  
  /** first line of the address */
  private String line1;
  
  /** second line of the address */
  private String line2;
  
  /** city */
  private String city;
  
  /** state - 2 letter */
  private String state;
  
  /** zip code */
  private String zipCode;
  
  /////////////// constructors //////////////
  
  /**
   * Constructor that takes all the info for an address
   * @param theLine1 the first line of the address
   * @param theLine2 the second line of the address
   * @param theCity the city
   * @param theState the 2 letter state 
   * @param theZipCode the zip code 
   */
  public Address(String theLine1, String theLine2, 
                 String theCity, String theState,
                 String theZipCode)
  {
    this.line1 = theLine1;
    this.line2 = theLine2;
    this.city = theCity;
    this.state = theState;
    this.zipCode = theZipCode;
  }
  
  ///////////////// methods ////////////////////
  
  /**
   * Method to get the line1
   * @return the line1 
   */
  public String getLine1()
  {
    return this.line1;
  }
  
  /**
   * Method to get the line2
   * @return the line2
   */
  public String getLine2()
  {
    return this.line2;
  }
  
  /**
   * Method to get the city
   * @return the city
   */
  public String getCity()
  {
    return this.city;
  }
  
  /**
   * Method to get the zip code
   * @return the zip code
   */
  public String getZipCode()
  {
    return this.zipCode;
  }
  
  /**
   * Method to set the line1
   * @param theLine1 the new line1
   */
  public void setLine1(String theLine1)
  {
    this.line1 = theLine1;
  }
  
  /**
   * Method to set the line2
   * @param theLine2 the new line2
   */
  public void setLine2(String theLine2)
  {
    this.line2 = theLine2;
  }
  
  /**
   * Method to set the city
   * @param theCity the new city
   */
  public void setCity(String theCity)
  {
    this.city = theCity;
  }
  
  /**
   * Method to set the zip code
   * @param theZipCode the zip to use
   */
  public void setZipCode(String theZipCode)
  {
    this.zipCode = theZipCode;
  }
  
  /**
   * Method to return the address info in a string
   * @return the info in a string
   */
  public String toString()
  {
    return this.line1 + "\n" + this.line2 + "\n" + 
      this.city + ", " + this.state + ", " + this.zipCode;
  }
  
  /**
   * Method to test
   */
  public static void main(String[] args)
  {
    Address address = new Address("5 Main St.","Apt 30",
                                  "Anytown", "GA", "33333");
    System.out.println(address);
  }
}