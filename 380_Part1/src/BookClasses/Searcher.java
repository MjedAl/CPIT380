package BookClasses;

import java.util.*;

/**
 * Class that demonstrates search algorithms
 * @author Mark Guzdial
 * @author Barb Ericson
 **/
public class Searcher
{
  
  /**
   * Implement a linear search through the list of
   * comparable objects
   * @param target the object you are looking for
   * @param list the list of comparable objects to look in
   * @return a string telling you if it was found
   */
  public static String linearFind(Comparable target, 
                                      List<Comparable> list)
  {
    for (int index=0; index < list.size(); index++)
    {
      if (target.compareTo(list.get(index)) == 0)
      {return("Found it!"); }
    }
    return("Not found");
  }

  /**
   * Implement a linear search through the list
   * @param target the object you are looking for
   * @param listArray the array you are looking in
   * @return a string telling you if it was found
   */
  public static String linearFind(String target, 
                                  String[] listArray)
  {
    for (int index=0; index < listArray.length; index++)
    {
      if (target.compareTo(listArray[index]) == 0)
      {return("Found it!"); }
    }
    return("Not found");
  }
  
  /**
   * Method to use a binary search to find a target string in a
   * sorted array of strings
   * @param target the object you are looking for
   * @param listArray the ordered array of strings to look in
   * @return a string telling you if it was found or not
   */
  public static String binaryFind(String target, String[] listArray)
  {
    int start = 0;
    int end = listArray.length - 1;
    int checkpoint = 0;

    while (start <= end)
    { //While there are more to search
      // find the middle
      checkpoint = (start+end)/2;
      System.out.println("Checking at: "+
       checkpoint+" start="+start+" end="+end);
      if (target.compareTo(listArray[checkpoint]) == 0)
      {
        return "Found it!";
      }
      else if (target.compareTo(listArray[checkpoint]) > 0)
      {
        start=checkpoint + 1;
      }
      else if (target.compareTo(listArray[checkpoint]) < 0)
      {
        end=checkpoint - 1;
      }
    }
    return "Not found";
  }
  
  /**
   * Method to use a binary search to find a target comparable
   * object in a list of comparable objects
   * @param target the object you are looking for
   * @param list the list of comparable objects to look in
   * @return a string telling you if it was found
   */
  public static String binaryFind(Comparable target, 
                                  List<Comparable> list)
  {
    int start = 0;
    int end = list.size() - 1;
    int checkpoint = 0;

    while (start <= end)
    { //While there are more to search
      // find the middle
      checkpoint = (start+end)/2;
      System.out.println("Checking at: "+
       checkpoint+" start="+start+" end="+end);
      if (target.compareTo(list.get(checkpoint)) == 0)
      {
        return "Found it!";
      }
      else if (target.compareTo(list.get(checkpoint)) > 0)
      {
        start=checkpoint + 1;
      }
      else if (target.compareTo(list.get(checkpoint)) < 0)
      {
        end=checkpoint - 1;
      }
    }
    return "Not found";
  }
  
  /** main for testing linearFind */
  /*
  public static void main(String[] args)
  {
    String[] searchMe = {"apple","bear","cat","dog","elephant"};
    System.out.println(linearFind("apple",searchMe));
    System.out.println(linearFind("cat",searchMe));
    System.out.println(linearFind("giraffe",searchMe));
  }
  */


  /**
   * Main for testing binary find 
   */
  public static void main(String[] args)
  {
    String[] searchMe = {"apple","bear","cat","dog","elephant"};
    System.out.println(binaryFind("apple",searchMe));
    System.out.println(binaryFind("cat",searchMe));
    System.out.println(binaryFind("giraffe",searchMe));
    List searchList = new ArrayList();
    searchList.add("apple");
    searchList.add("bear");
    searchList.add("cat");
    searchList.add("dog");
    searchList.add("elephant");
    System.out.println(linearFind("cat",searchList));
    System.out.println(binaryFind("dog",searchList));
  }
}