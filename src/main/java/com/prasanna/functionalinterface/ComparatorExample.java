package com.prasanna.functionalinterface;

import java.util.Comparator;

/**
 * Created by gopalp on 29/12/2015.
 */
public class ComparatorExample {

   public static void main(String[] args) {

      Comparator<String> lamda = (lhs, rhs) -> lhs.compareTo(rhs);
      int compare = lamda.compare("Prasanna", "Prasanna");
      System.out.println("Compare Result : " + compare);
   }
}
