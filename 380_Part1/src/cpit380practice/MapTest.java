package cpit380practice;

import java.util.*;

public class MapTest
{
  public static void main(String[] args)
  {
    String key = "theKey";
    Map testMap = new HashMap();
    testMap.put(key,"theValue");
    //String value = testMap.get(key);
    String value = (String) testMap.get(key);
  }
}
    