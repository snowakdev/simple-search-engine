package org.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchEngineTest {



  private Documents documents;
  private SearchEngine searchEngine;
  private String[] searchTerm;
  private List<String> actualResults = new ArrayList<>();

  @Test
  public void testSearchNoResults() {
    givenDocuments();
    givenSearchTerm(new String[]{"nonsense"});
    givenSearchEngine();
    whenISearchForTerm();
    thenResultIsEmpty();
  }

  @Test
  public void testSearchForMultiTerms() {
    givenDocuments();
    givenSearchTerm(new String[]{"lazy","brown","dog"});
    givenSearchEngine();
    whenISearchForTerm();
    thenResultIs(Arrays.asList(TestFixture.DOCUMENT_2,TestFixture.DOCUMENT_1,TestFixture.DOCUMENT_3));
  }

  @Test
  public void testSearchForTermBrown() {
    givenDocuments();
    givenSearchTerm(new String[]{"brown"});
    givenSearchEngine();
    whenISearchForTerm();
    thenResultIs(Arrays.asList(TestFixture.DOCUMENT_1, TestFixture.DOCUMENT_2));
  }

  @Test
  public void testSearchForTermFox() {
    givenDocuments();
    givenSearchTerm(new String[]{"fox"});
    givenSearchEngine();
    whenISearchForTerm();
    thenResultIs(Arrays.asList(TestFixture.DOCUMENT_1, TestFixture.DOCUMENT_3));
  }

  private void givenDocuments() {
    documents = new Documents();
    documents.addDocumentsToList(
        Arrays.asList(new Document(TestFixture.DOCUMENT_1), new Document(TestFixture.DOCUMENT_2), new Document(TestFixture.DOCUMENT_3), new Document(TestFixture.DOCUMENT_4)));
  }

  private void givenSearchTerm(String[] search) {
    searchTerm = search;
  }

  private void givenSearchEngine() {
    searchEngine = new SearchEngine(searchTerm, documents);
  }

  private void whenISearchForTerm() {
    actualResults = searchEngine.search();
  }

  private void thenResultIsEmpty() {
    assertTrue(actualResults.isEmpty());
  }

  private void thenResultIs(List<String> expectedResult) {
    assertEquals(expectedResult.size(), actualResults.size());
    assertTrue(IntStream.range(0, expectedResult.size()).allMatch( i -> actualResults.get(i).compareTo(expectedResult.get(i)) <= 0));
  }
}


