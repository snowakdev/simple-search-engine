package org.demo;

import java.util.Arrays;
import java.util.List;

public class TfIdfCalculation {

  public static double termFrequency(List<String> document, String[] searchTerm) {
    final double[] wordCount = {0};
    Arrays.stream(searchTerm).forEach(term -> {
      document.forEach(word -> {
        if (word.equals(term)) {
          wordCount[0]++;
        }
      });
    });
    return wordCount[0] / document.size();
  }

  public static double inverseDocFrequency(List<List<String>> documents, String[] searchTerm) {
    final double[] wordCount = {0};
    Arrays.stream(searchTerm).forEach(term -> {
      documents.forEach(document -> {
        for (String word : document) {
          if (word.equals(term)) {
            wordCount[0]++;
            break;
          }
        }
      });
    });
    return Math.log(documents.size() / wordCount[0]);
  }

}
