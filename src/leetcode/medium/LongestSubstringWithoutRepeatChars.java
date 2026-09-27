package leetcode.medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatChars {

  static void main( String[] args ) {

    String input = "abcabcbb";
    int output = lengthOfLongestSubstring( input );
    System.out.println( "Result " + output );

    // Implement JUNIT Tests

    input = "pwwkew";
    output = lengthOfLongestSubstring( input );
    System.out.println( output );
  }

  // TODO fix this method

  // XXX does not work for "eea"
  // TODO create a note todo marker
  public static int lengthOfLongestSubstring( String s ) {

    String sub = s;
    HashMap<Character, Integer> map = new HashMap<>();
    String maxSoFar = "";
    int max = 0;

    for ( int i = 0; i < s.length(); i++ ) {

      Character c = sub.charAt( i );
      if ( !map.containsKey( c ) ) {

        System.out.println( "Map does NOT contain " + c );
        maxSoFar += "" + c;

        System.out.println( "MaxSofar: " + maxSoFar );
        map.put( c, 1 );

        System.out.println( map );
        if ( maxSoFar.length() > max ) {
          max = maxSoFar.length();
        }

      }
      else {

        if ( maxSoFar.length() >= max ) {

          max = maxSoFar.length();
          System.out.println( "MaxSoFar: " + maxSoFar );
        }
        map.clear();
        maxSoFar = "";
        System.out.println( "Clearing map" );
        System.out.println( map );
        System.out.println( "MaxSoFar: " + maxSoFar );

      }

    }

    return max;
  } //end of for i loop

} // end of class
