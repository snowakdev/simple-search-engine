package org.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class SearchEngine {

  private String[] searchTerms;
  private Documents documents;

  public SearchEngine(String[] searchTerms, Documents documents) {
    this.searchTerms = searchTerms;
    this.documents = documents;
  }

  public List<String> search() {
    documents.getDocuments().forEach(document -> {
      document.setTermFreqValue(TfIdfCalculation.termFrequency(document.getDocWords(), searchTerms));
      List<List<String>> documentWords = documents.getDocuments().stream().map(Document::getDocWords).collect(Collectors.toList());
      document.setInvDocFreqValue(TfIdfCalculation.inverseDocFrequency(documentWords, searchTerms));
      document.setTfIdf(abs(document.getTermFreqValue() * document.getInvDocFreqValue()));
    });
    return documents.getDocuments().stream()
        .filter(document -> document.containsAnyOfTerm(searchTerms))
        .sorted(Comparator.comparingDouble(Document::getTfIdf).reversed())
        .map(Document::getDoc)
        .collect(Collectors.toList());
  }

}
