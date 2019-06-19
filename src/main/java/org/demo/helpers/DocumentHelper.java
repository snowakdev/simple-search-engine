package org.demo.helpers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DocumentHelper {


  private static Predicate<? super String> stopWordsThe = s -> !s.equals("the");
  private static Predicate<? super String> stopWordsIn = s -> !s.equals("in");

  public static List<String> extractTokensFromDoc(String document) {
    return Arrays.stream(document.split(" "))
        .map(String::trim)
        .map(DocumentHelper::normalise)
        .filter(stopWordsIn)
        .filter(stopWordsThe)
        .distinct()
        .collect(Collectors.toList());
  }

  private static String normalise(String symbol) {
    //TODO Extra feature:
    //1. Find synonyms and index them just a single term
    //2. Reduce plural words to their root
    return symbol.toLowerCase();
  }

  public static String getDocumentByIndex(Integer index, String[] documents) {
    return documents[index];
  }


}
