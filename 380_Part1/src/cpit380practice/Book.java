package cpit380practice;


/**
 * Class that represents a book
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Book
{
  ///////////////// fields /////////////////////////
  
  /** the title of the book */
  private String title;
  /** the author name or names */
  private String author;
  /** the ISBN number */
  private String ISBN;
  /** the price of the book */
  private double price;
  /** the year the book was published */
  private String year;
  
  ///////////////// constructors /////////////////////
  
  /**
   * Constructor that takes all the info about the book 
   * @param theTitle the title of the book
   * @param theAuthor the author info
   * @param theISBN the ISBN number
   * @param thePrice the price of the book
   * @param theYear the year it was published
   */
  public Book(String theTitle, String theAuthor, 
              String theISBN,
              double thePrice, String theYear)
  {
    this.title = theTitle;
    this.author = theAuthor;
    this.ISBN = theISBN;
    this.price = thePrice;
    this.year = theYear;
  }
  
  /////////////////////// methods //////////////////////////////
  
  /**
   * Method to get the title
   * @return the title
   */
  public String getTitle() 
  { 
    return this.title; 
  }
  
  /**
   * Method to get the author name(s)
   * @return the author name(s)
   */
  public String getAuthor() 
  { 
    return this.author; 
  }
  
  /**
   * Method to get the ISBN number
   * @return the ISBN number
   */
  public String getISBN()
  {
    return this.ISBN;
  }
  
  /**
   * Method to get the price 
   *@return the price of the book
   */
  public double getPrice()
  {
    return this.price;
  }
  
  /**
   * Method to get the year 
   * @return the year of publication
   */
  public String getYear()
  {
    return this.year;
  }
  
  /**
   * Method to set the title
   * @param theTitle the title to use
   */
  public void setTitle(String theTitle)
  {
    this.title = theTitle;
  }
  
  /**
   * Method to set the author
   * @param theAuthor the author info to use
   */
  public void setAuthor(String theAuthor)
  {
    this.author = theAuthor;
  }
  
  /**
   * Method to set the ISBN
   * @param theISBN the number to use
   */
  public void setISBN(String theISBN)
  {
    this.ISBN = theISBN;
  }
  
  /**
   * Method to set the price
   * @param thePrice the price to use
   */
  public void setPrice(double thePrice)
  {
    this.price = thePrice;
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
   * Method to return info on this book as a string
   * @return the info about the book as a string
   */
  public String toString()
  {
    return this.title + ", " + this.author + ", " + this.ISBN + ", " +
      this.price + ", " + this.year;
  }
  
  /**
   * Main method for testing
   */
  public static void main(String[] args)
  {
    Book theBook = 
      new Book("Introduction to Computing and Programming in Java: A Multimedia Approach",
                            "Mark Guzdial and Barbara Ericson",
                            "0131496980",
                            98.00,
                            "2006");
    System.out.println(theBook);
  }
 
}