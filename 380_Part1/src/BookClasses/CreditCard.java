package BookClasses;


/**
 * Class that represents a credit card
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class CreditCard
{
  //////////////// fields /////////////////////////
  
  /** the number on the card */
  private String number;
  
  /** the expiration date on the card */
  private String expDate;
  
  /** the name on the card */
  private String name;
  
  //////////////// constructors //////////////////
  
  /**
   * Constructor that take info on the card
   * @param theNumber the number on the card
   * @param theExpDate the expiration date
   * @param theName the name on the card
   */
  public CreditCard(String theNumber, 
                    String theExpDate,
                    String theName)
  {
    this.number = theNumber;
    this.expDate = theExpDate;
    this.name = theName;
  }
  
  ///////////////// methods //////////////////////
  
  /**
   * Method to get the number 
   * @return the credit card number
   */
  public String getNumber()
  {
    return this.number;
  }
  
  /**
   * Method to get the expiration date
   * @return the expiration date
   */
  public String getExpDate()
  {
    return this.expDate;
  }
  
  /**
   * Method to get the name on the credit card
   * @return the name
   */
  public String getName()
  {
    return this.name;
  }
  
  /**
   * Method to set the number
   * @param theNumber the number to use
   */
  public void setNumber(String theNumber)
  {
    this.number = theNumber;
  }
  
  /**
   * Method to set the expiration date
   * @param theDate the date the card expires
   */
  public void setExpDate(String theDate)
  {
    this.expDate = theDate;
  }
  
  /**
   * Method to set the name
   * @param theName the name on the card
   */
  public void setName(String theName)
  {
    this.name = theName;
  }
  
  /**
   * Method to return info about the card
   */
  public String toString()
  {
    return this.number + " " + 
      this.expDate + " " + this.name;
  }
  
  /**
   * Method to test the credit card
   */
  public static void main(String[] args)
  {
    CreditCard card = 
      new CreditCard("0000 1111 2222 3333","06/06","Mark Guzdial");
    System.out.println(card);
  }
  
}
