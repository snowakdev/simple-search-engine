package org.demo;


import java.util.List;

public class Application {
  public static void main(String[] args) {
    if (InputValidator.validate(args)) {
      Launcher launcher = new Launcher();
      List<String> result = launcher.run(args);
      ResultPrintOut.print(result);
    } else {
      ResultPrintOut.print();
    }
  }
}
