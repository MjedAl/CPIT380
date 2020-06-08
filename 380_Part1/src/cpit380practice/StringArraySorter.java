package cpit380practice;

import java.util.*;

/**
 * Class StringArraySorter has an array of 
 * Strings and can do different sorts on it
 * @author Barb Ericson
 */
public class StringArraySorter
{
  /// fields ////////////
  
  /** the array to sort */
  private String[] a;
  
  /**
   * Constructor that takes the array to sort
   * @param theArray the array to sort
   */
  public StringArraySorter(String[] theArray)
  {
    a = theArray;
  }
  
  /**
   * Get the last valid index in a
   */
  private int getLastIndex()
  {
    return (a.length - 1);
  }
  
  /**
   * Method to swap the values at two indices
   * in the array
   * @param i an index in the array
   * @param j another index in the array
   * i may be equal to j
   */
  private void swap(int i, int j)
  {
    if (i != j)
    {
      String temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
  
   /**
   * Method to do a bubble sort on the array
   */
  public void bubbleSort()
  {
    int maxIndex = a.length - 1;
    int numSteps = 0;
    
    for (int i = maxIndex; i >= 0; i--)
    {
      for (int j = 0; j < i; j++)
      {
        numSteps++;
        if (a[j].compareTo(a[j+1]) > 0)
        {
          swap(j,j+1);
        }
      }
      this.printArray("after loop body when i = " + i);
    }
    System.out.println("#steps:"+numSteps);
  }
  
   /**
   * Method to test bubble sort
   */
  public static void testBubbleSort()
  {
    String[] testArray = {"g","c","e","f","b","h","d","a"};
    
    StringArraySorter sorter = new StringArraySorter(testArray);
    sorter.printArray("Before bubble sort");
    sorter.bubbleSort();
    sorter.printArray("After bubble sort"); 
  } 

  
  /**
   * Method to do a selection sort on the array
   */
  public void selectionSort()
  {
    int maxCompare = a.length - 1;
    int smallestIndex = 0;
    int numSteps = 0;
    
    // loop from 0 to one before last item
    for (int i = 0; i < maxCompare; i++)
    {
      // set smallest index to the one at i
      smallestIndex = i;
      numSteps = 0;
      
      // loop from i+1 to end of the array
      for (int j = i + 1; j < a.length; j++)
      {
        numSteps++;
        if (a[j].compareTo(a[smallestIndex]) < 0)
        {
          smallestIndex = j;
        }
      }
      System.out.println("#steps:"+numSteps);
      
      // swap the one at i with the one at smallest index
      swap(i,smallestIndex);
      this.printArray("after loop body when i = " + i);
    }
  }
  
  /**
   * Method to print out the array elements
   * @param message the message to print first
   */
  private void printArray(String message)
  {
    System.out.println(message);
    for (String i : a)
      System.out.println(i);
  }
    
  /**
   * Method to test selection sort
   */
  public static void testSelectionSort()
  {
    String[] testArray = {"g","c","e","f","b","h","d","a"};
    
    StringArraySorter sorter = new StringArraySorter(testArray);
    sorter.printArray("Before selection sort");
    sorter.selectionSort();
    sorter.printArray("After selection sort");
    
  } 
  
  /**
   * Method to do an insertion sort on the array
   */
  public void insertionSort()
  {
    String temp = null;
    int pos = 0;
    
    // loop from second element on 
    for (int i = 1; i < a.length; i++)
    {
      // save current value at i and set position to i
      temp = a[i];
      pos = i;
      
      // shift right any larger elements
      while (0 < pos && temp.compareTo(a[pos - 1]) < 0)
      {
        a[pos] = a[pos - 1];
        pos--;
      }
      a[pos] = temp;
      this.printArray("after loop body when i = " + i);
    }
  }
  
  /**
   * Method to test insertion sort
   */
  public static void testInsertionSort()
  {
    String[] testArray = {"g","c","e","f","b","h","d","a"};
    
    StringArraySorter sorter = new StringArraySorter(testArray);
    sorter.printArray("Before insertion sort");
    sorter.insertionSort();
    sorter.printArray("After insertion sort");
    
  } 
  
  /**
   * Method to do a merge sort of the array
   */
  public void mergeSort()
  {
    // check if there is only 1 element return
    if (a.length == 1) return;
    
    // otherwise create two new arrays
    String[] left = new String[a.length / 2];
    for (int i = 0; i < left.length; i++)
      left[i] = a[i];
    String[] right = new String[a.length - left.length];
    for (int i = left.length, j=0; 
         i < a.length; i++, j++)
      right[j] = a[i];
    
    // create new StringArraySorter objects
    StringArraySorter sorter1 = new StringArraySorter(left);
    sorter1.printArray("sorter1");
    StringArraySorter sorter2 = new StringArraySorter(right);
    sorter2.printArray("sorter2");
    
    // do the recursive call with the new sorters
    sorter1.mergeSort();
    sorter2.mergeSort();
    
    // merge the resulting arrays
    merge(left,right);
    this.printArray("After merge");
  }
  
  /**
   * Method to merge two sorted arrays
   * back into this object's array
   * @param left sorted left array
   * @param right the sorted right array
   */
  private void merge(String[] left, String[] right)
  {
    int leftIndex = 0; // current left index
    int rightIndex = 0; // current right index
    int i = 0; // current index in a
    
    // merge the left and right arrays into a
    while (leftIndex < left.length &&
           rightIndex < right.length)
    {
      if (left[leftIndex].compareTo(right[rightIndex]) < 0)
      {
        a[i] = left[leftIndex];
        leftIndex++;
      }
      else
      {
        a[i] = right[rightIndex];
        rightIndex++;
      }
      i++;
    }
    
    // copy any remaining in left
    for (int j = leftIndex; j < left.length; j++)
    {
      a[i] = left[j];
      i++;
    }
    
    // copy any remaining in right
    for (int j = rightIndex; j < right.length; j++)
    {
      a[i] = right[j];
      i++;
    }
  }
  
  public static void testMergeSort()
  {
    String[] testArray = {"g","c","e","f","b","h","d","a"};
    
    StringArraySorter sorter = new StringArraySorter(testArray);
    sorter.printArray("Before merge sort");
    sorter.mergeSort();
    sorter.printArray("After merge sort");
  }
  
  /**
   * Method to do a quick sort on the array
   */
  public void quickSort()
  {
    // check if the array is null or has a length of 0 or 1
    if (a == null || a.length <= 1)
      return;
    else
    {
      // pick a pivot index
      int pivotIndex = a.length / 2;
      
      // get the pivot value
      String pivotValue = a[pivotIndex];
      
      // distribute all values < the pivot index
      List<String> less = new ArrayList<String>();
      List<String> more = new ArrayList<String>();
      for (int i = 0; i < pivotIndex; i++)
      {
        if (a[i].compareTo(pivotValue) < 0)
          less.add(a[i]);
        else
          more.add(a[i]);
      }
      // distribute all values > than the pivot index
      for (int i = pivotIndex + 1; i < a.length; i++)
      {
        if (a[i].compareTo(pivotValue) < 0)
          less.add(a[i]);
        else
          more.add(a[i]);
      }
      
      // create two new StringArraySorters and sort these
      String[] lessArray = less.toArray(new String[less.size()]);
      StringArraySorter sorterLess = new StringArraySorter(lessArray);
      sorterLess.quickSort();
      String[] moreArray = more.toArray(new String[more.size()]);
      StringArraySorter sorterMore = new StringArraySorter(moreArray);
      sorterMore.quickSort();
      
      // put the sorted elements back in the array
      int i = 0;
      for (; i < lessArray.length; i++)
      {
        a[i] = lessArray[i];
      }
      a[i++] = pivotValue;
      for (int j = 0; j < moreArray.length; j++)
      {
        a[i++] = moreArray[j];
      }
    }
  }
  
  public static void testQuickSort()
  {
    String[] testArray = {"g","c","e","f","b","h","d","a"};
    
    StringArraySorter sorter = new StringArraySorter(testArray);
    sorter.printArray("Before quick sort");
    sorter.quickSort();
    sorter.printArray("After quick sort");
  }
   
  public static void main(String[] args)
  {
    //testBubbleSort();
    //testSelectionSort();
    //testInsertionSort();
    //testMergeSort();
    testQuickSort();
  }
}