package practice.strings;

// Import the JUnit 5 components

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice.strings.reverseStringMethods.reverseWithArray;

public class StringTests {

  @Test
  void testReverseWithArray() {

    reverseStringMethods rev = new reverseStringMethods();
    String s = "automation";

    String result = reverseWithArray( s );

    assertEquals( s, "automation" );
  }
}
