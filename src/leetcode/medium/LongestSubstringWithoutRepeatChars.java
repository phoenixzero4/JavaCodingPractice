package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatChars {

  static void main( String[] args ) {

    String in = "bbbb";
    int result = lengthOfLongestSubstring( in );
    System.out.println( result );

  }

  public static int lengthOfLongestSubstring( String s ) {

    Map<Character, Integer> map = new HashMap<>();

    int left = 0, max = 0;

    for ( int right = 0; right < s.length(); right++ ) {
      char current = s.charAt( right );

      if ( map.containsKey( current ) ) {
        left = Math.max( left, map.get( current ) + 1 );
      }

      map.put( current, right );

      max = Math.max( max, right - left + 1 );
    }
    return max;
  }
} // end of class
