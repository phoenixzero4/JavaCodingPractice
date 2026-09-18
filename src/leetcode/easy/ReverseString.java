package leetcode.easy;

/*
Leetcode 344: Reverse String

Write a function that reverses a string.
The input string is given as an array of characters s.

Modify the input array in-place with O(1) extra memory
 */
public class ReverseString {

  static void main() {

    char[] chars = { 'H', 'e', 'l', 'l', 'o' };
    reverseString( chars );
  }

  public static void reverseString( char[] s ) {

    for ( int i = 0, j = s.length - 1; i <= j; i++, j-- ) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
    }

    String result = new String( s );
    System.out.println( result );
  }
}
