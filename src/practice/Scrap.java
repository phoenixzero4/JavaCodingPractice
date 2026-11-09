package practice;

/**
 * Phoenix
 * Oct 11 2026
 */

/**
 * PROBLEM DESCRIPTION
 *
 */

public class Scrap {

  static void main( String[] args ) {

    String one = "abcdefghijkaabbbaajlkljuehegalkjkldf";

    for ( int i = 0; i < one.length(); i++ ) {

      char first = one.charAt( i );
      int last = one.lastIndexOf( first );

      String sub = one.substring( i, last );
      System.out.println( "Sub: " + sub );

      if ( isPalindrome( sub ) ) {
        System.out.println( sub );
      }

    }
  }

  public static boolean isPalindrome( String s ) {

    char[] array = s.toCharArray();

    for ( int i = 0, j = array.length - 1; i <= j; i++, j-- ) {
      if ( array[i] != array[j] ) {
        return false;
      }
    }
    return true;
  }
}
