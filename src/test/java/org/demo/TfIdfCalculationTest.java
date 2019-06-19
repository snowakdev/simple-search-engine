package org.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TfIdfCalculationTest {

  private static final String[] SEARCH_TERMS = new String[]{"lazy", "brown"};
  private static final List<String> DOC_WORDS_1 = Arrays.asList(TestFixture.DOCUMENT_1.split(" "));
  private static final List<String> DOC_WORDS_2 = Arrays.asList(TestFixture.DOCUMENT_2.split(" "));
  private static final List<List<String>> DOCUMENTS = Arrays.asList(DOC_WORDS_1, DOC_WORDS_2);


  @Test
  public void termFrequency() {
    assertEquals(0.25, TfIdfCalculation.termFrequency(DOC_WORDS_1, SEARCH_TERMS), 0.001);
  }

  @Test
  public void inverseDocFrequency() {
    assertEquals(-0.40546510810816444, TfIdfCalculation.inverseDocFrequency(DOCUMENTS, SEARCH_TERMS), 0.001);
  }
}