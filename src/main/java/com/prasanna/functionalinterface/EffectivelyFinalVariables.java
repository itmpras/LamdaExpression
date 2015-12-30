package com.prasanna.functionalinterface;

/**
 * Created by gopalp on 30/12/2015.
 */
public class EffectivelyFinalVariables {
   String field = "";

   public static void main(String[] args) {
      EffectivelyFinalVariables effectivelyFinalVariables = new EffectivelyFinalVariables();
      effectivelyFinalVariables.testVariables();
   }

   public void testVariables() {
      String field = "Test";
      System.out.println("Field variable :" + field);
      Runnable r = () -> {
         System.out.println("Field variable :" + field);
      };

      r.run();

   }
}
