package org.demo;

import java.util.ArrayList;
import java.util.List;

public class Documents {
  private final List<Document> documents;

  public Documents() {
    this.documents = new ArrayList<>();
  }

  public void addDocumentsToList(List<Document> documentList) {
    documents.addAll(documentList);
  }

  public List<Document> getDocuments() {
    return documents;
  }
}
