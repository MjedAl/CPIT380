package BookClasses;

import java.io.*;

/**
 * Class that searches a file for a given sequence and reports
 * on the name where that sequence was found
 * @author Barb Ericson
 */
public class SequenceSearcher
{
  /**
   * Method to search for a given sequence and then
   * report on the name
   */
  public String getNameForSequence(String fileName, String seq)
  {
    String info = "";
    String line = null;
    String name = null;
    
    // try the following
    try {
      
      // read from the file
      BufferedReader reader = 
        new BufferedReader(new FileReader(fileName));
      
      // loop till end of file or find sequence
      while ((line = reader.readLine()) != null &&
             line.indexOf(seq) < 0)
      {
        // add to string with new line character
        info = info + line + "\n";
      }
      
      // if get here either end of line or we found the sequence
      if (line != null)
      {
        // look backwards for the last > 
        int firstIndex = info.lastIndexOf('>');
        
        // look forwards from the > for the new line character
        int secondIndex = info.indexOf('\n',firstIndex);
        
        // get the name between the > and new line
        name = info.substring(firstIndex+1,secondIndex);
      }
      
    } catch (FileNotFoundException ex) {
      SimpleOutput.showError("Couln't find file " + fileName);
      fileName = FileChooser.pickAFile();
      getNameForSequence(fileName,seq);
    } catch (Exception ex) {
      SimpleOutput.showError("Error during read or write");
      ex.printStackTrace();
    } 
      
      return name;    
  }
  
  public static void main(String[] args)
  {
    SequenceSearcher searcher = new SequenceSearcher();
    String fileName = FileChooser.getMediaPath("parasites.txt");
    String seq = "ttgtgta";
    String name = searcher.getNameForSequence(fileName,seq);
    if (name == null)
      System.out.println("The sequence " + seq + 
                         " wasn't found in " + fileName);
    else
      System.out.println("The sequence " + seq + 
                         " was found in " + name);
  }
}