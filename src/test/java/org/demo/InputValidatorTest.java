package org.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

  @Test
  public void validate() {
    String[] args = new String[]{"arg1", "arg2"};
    assertTrue(InputValidator.validate(args));
    args = new String[]{};
    assertFalse(InputValidator.validate(args));
  }
}