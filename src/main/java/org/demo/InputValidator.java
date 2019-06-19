package org.demo;

public class InputValidator {
  public static boolean validate(String[] args) {
    return (args.length > 0) && (args[0] != null && !args[0].isEmpty()) && (args[1] != null && !args[1].isEmpty());
  }
}
