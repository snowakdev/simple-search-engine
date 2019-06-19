package org.demo;

import org.demo.helpers.DocumentHelper;

import java.util.List;

public class Document {
  private final String doc;
  private final List<String> docWords;
  private double termFreqValue;
  private double invDocFreqValue;
  private double tfIdf;

  public Document(String doc) {
    this.doc = doc;
    this.docWords = DocumentHelper.extractTokensFromDoc(doc);
  }

  public List<String> getDocWords() {
    return docWords;
  }

  public double getTermFreqValue() {
    return termFreqValue;
  }

  public void setTermFreqValue(double termFreqValue) {
    this.termFreqValue = termFreqValue;
  }

  public double getInvDocFreqValue() {
    return invDocFreqValue;
  }

  public void setInvDocFreqValue(double invDocFreqValue) {
    this.invDocFreqValue = invDocFreqValue;
  }

  public double getTfIdf() {
    return tfIdf;
  }

  public void setTfIdf(double tfIdf) {
    this.tfIdf = tfIdf;
  }

  public String getDoc() {
    return doc;
  }

  public boolean containsAnyOfTerm(String[] searchTerms) {
    boolean result = false;
    String docWordsOneSentence = String.join(" ", getDocWords());
    for (String searchTerm : searchTerms) {
      if (docWordsOneSentence.contains(searchTerm)) {
        result = true;
        break;
      }
    }

    return result;
  }
}
