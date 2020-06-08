package cpit380practice;

import java.io.*;
/**
 * Class used to generate form letters
 * @author Barbara Ericson
 */
public class FormLetterGenerator
{
  
  /**
   * Method to generate a form letter
   * @param title the person's title (Mr., Mrs., Dr.)
   * @param lastName the last name for the recipient
   * @param city the name of the city for the recipient
   * @param eyeColor the eye color of the recipient
   */
  public void writeLetter(String title, String lastName, 
                      String city, String eyeColor)
  {
    String fileName = lastName + "Letter.txt";
    
    // try to open the file and write to it
    try {
      
      // create the buffered writer to use to write the file
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(fileName));
      
      // write the beginning of the letter
      writer.write("Dear " + title + " " + lastName + ", ");
      writer.newLine();
      writer.newLine();
      
      // write the body of the letter
      writer.write("I am writing to remind you of the offer");
      writer.newLine();
      writer.write("that we sent to you last week.  Everyone in");
      writer.newLine();
      writer.write(city + 
                   " knows what an exceptional offer this is!");
      writer.newLine();
      writer.write("(Especially those with lovely eyes of " + 
                   eyeColor + "!)");
      writer.newLine();
      writer.write("We hope to hear from you soon.");
      writer.newLine();
      writer.newLine();
      
      // write the ending
      writer.write("Sincerely,");
      writer.newLine();
      writer.write("I. M. Acrook");
      
      // close the file
      writer.close();
    } catch (Exception ex) {
      System.out.println("Error writing to " + fileName);
    }
  }
  
  /**
   * Method to write the beginning of the form letter
   * @param writer the writer to use to write it
   * @param title the title to use (Mr. Ms. Mrs. etc)
   * @param lastName the person's last name
   */
  public void writeBeginning(BufferedWriter writer,
                             String title, 
                             String lastName) throws IOException
  {
  
      // write the beginning of the letter
      writer.write("Dear " + title + " " + lastName + ", ");
      writer.newLine();
      writer.newLine();
  }
  
  /**
   * Write the body of the letter
   * @param writer the writer to use to write it
   * @param city the city the person lives in
   * @param eyeColor the person's eye color
   */
  public void writeBody(BufferedWriter writer,
                        String city,
                        String eyeColor)
    throws IOException
  {
      writer.write("I am writing to remind you of the offer");
      writer.newLine();
      writer.write("that we sent to you last week.  Everyone in");
      writer.newLine();
      writer.write(city + 
                   " knows what an exceptional offer this is!");
      writer.newLine();
      writer.write("(Especially those with lovely eyes of " + 
                   eyeColor + "!)");
      writer.newLine();
      writer.write("We hope to hear from you soon.");
      writer.newLine();
      writer.newLine();
  }
  
  /**
   * Write the body of the letter
   * @param writer the writer to use to write it
   * @param city the city the person lives in
   * @param eyeColor the person's eye color
   * @param petName the name of the pet
   * @param petType the type of pet (cat, dog, etc)
   */
  public void writeBody(BufferedWriter writer,
                        String city,
                        String eyeColor,
                        String petName,
                        String petType)
    throws IOException
  {
    writeBody(writer,city,eyeColor);
    writer.write("Your pet " + petType + ", " + petName + ", will love our offer!");
    writer.newLine();
    writer.newLine();
  }
  
  /**
   * Write the ending of the letter
   * @param writer the writer to use to write the letter
   */
  public void writeEnding(BufferedWriter writer) throws IOException
  {
    // write the ending
    writer.write("Sincerely,");
    writer.newLine();
    writer.write("I. M. Acrook");
  }
  
  /**
   * Method to generate a form letter
   * @param title the person's title (Mr., Mrs., Dr.)
   * @param lastName the last name for the recipient
   * @param city the name of the city for the recipient
   * @param eyeColor the eye color of the recipient
   */
  public void writeLetterV2(String title, String lastName, 
                      String city, String eyeColor)
  {
    String fileName = lastName + "Letter.txt";
    
    // try to open the file and write to it
    try {
      
      // create the buffered writer to use to write the file
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(fileName));
      
      // write the beginning
      writeBeginning(writer,title,lastName);
      
      // write the body of the letter
      writeBody(writer,city,eyeColor);
      
      // write the ending
      writeEnding(writer);
      
      // close the file
      writer.close();
    } catch (Exception ex) {
      System.out.println("Error writing to " + fileName);
    }
  }   
  
  /**
   * Method to generate a form letter
   * @param title the person's title (Mr., Mrs., Dr.)
   * @param lastName the last name for the recipient
   * @param city the name of the city for the recipient
   * @param eyeColor the eye color of the recipient
   * @param petName the name of the pet
   * @param petType the type of animal (cat, dog, etc)
   */
  public void writeLetter(String title, String lastName, 
                          String city, String eyeColor,
                          String petName, String petType)
  {
    String fileName = lastName + "Letter.txt";
    
    // try to open the file and write to it
    try {
      
      // create the buffered writer to use to write the file
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(fileName));
      
      // write the beginning
      writeBeginning(writer,title,lastName);
      
      // write the body of the letter
      writeBody(writer,city,eyeColor,petName,petType); 
      
      // write the ending
      writeEnding(writer);
      
      // close the file
      writer.close();
    } catch (Exception ex) {
      System.out.println("Error writing to " + fileName);
    }
  }   
  
  public static void main(String[] args)
  {
    FormLetterGenerator formGenerator = new FormLetterGenerator();
    formGenerator.writeLetter("Mr.","Guzdial","Decatur","brown","Fifi","dog");
  }
    
}