package org.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Launcher {
  public List<String> run(String[] args) {
    String[] searchTerms = args[0].split(" ");
    String[] documentArray = Arrays.stream(args).skip(1).toArray(String[]::new);

    Documents documents = new Documents();
    documents.addDocumentsToList(Arrays.stream(documentArray).map(Document::new).collect(Collectors.toList()));

    return new SearchEngine(searchTerms, documents).search();
  }
}
