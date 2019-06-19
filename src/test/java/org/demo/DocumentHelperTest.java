package org.demo;

import org.demo.helpers.DocumentHelper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DocumentHelperTest {

  private static final String DOCUMENT_1 = "THE brown FOX jumped over the brown dog";
  private static final String DOCUMENT_2 = "the lazy brown dog sat in the corner";
  private static final String DOCUMENT_3 = "the red fox bit the lazy dog";

  @Test
  public void extractTokenFrom() {
    List<String> expectedResult = Arrays.asList("brown", "fox", "jumped", "over", "dog");
    assertEquals(expectedResult, DocumentHelper.extractTokensFromDoc(DOCUMENT_1));
  }

  @Test
  public void getDocumentByIndex() {
    String[] documents = new String[]{DOCUMENT_1, DOCUMENT_2, DOCUMENT_3};
    assertEquals(DOCUMENT_2, DocumentHelper.getDocumentByIndex(1, documents));
  }
}