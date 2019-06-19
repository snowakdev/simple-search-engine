package org.demo;

import java.util.List;

public class ResultPrintOut {

  public static void print(List<String> results) {
    System.out.println("Result is: \n");
    results.forEach(result -> System.out.println(result+"\n"));
  }

  public static void print() {
    System.out.println("You need pass search term and at least one document");
  }
}
