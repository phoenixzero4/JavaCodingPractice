package leetcode.easy;

// TODO fix this so it passes all leetcode test cases
public class ReverseString2 {

  static void main() {

    String s = "abcdefg";
    int k = 2;
    System.out.println( reverse( s, k ) );

    //    System.out.println();
    //
    //    k = 2;
    //    System.out.println( reverseStr( s, k ) );

  }

  public static String reverse( String s, int k ) {

    String string = s;
    StringBuilder sb = new StringBuilder();
    String result = "";
    int chunk = 2 * k;

    if ( string.length() < k ) {
      sb = new StringBuilder( string );
      result += sb.reverse()
                  .toString();
    }

    while ( string.length() >= k ) {

      if ( string.length() < chunk && string.length() >= k ) {
        sb = new StringBuilder( ( string.substring( 0, k ) ) );
        result += sb.reverse() + string.substring( k );
        string = string.substring( k );
      }
      else {
        sb = new StringBuilder( string.substring( 0, k ) );

        result += sb.reverse() + string.substring( k );
        string = string.substring( chunk );

      }
      //      sb = new StringBuilder( string );
      //      result += sb.reverse()
      //                  .toString();
    }
    //    System.out.println( "string " + string );
    //    System.out.println( "result " + result );
    return result;

  }

  /*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them.

If there are < than 2k but >= to k characters, reverse the first k characters and leave the other as original.
   */
  public static String reverseStr( String s, int k ) {

    int l = s.length();
    String result = "";
    int j = k * 2;

    if ( k == 1 ) {
      return s;
    }
    StringBuilder sb = new StringBuilder( s );
    if ( k > l ) {
      return sb.reverse()
               .toString();
    }

    for ( int i = 0; i < s.length() - 1; i += j ) {
      int remainingLength = l - i;
      System.err.printf( "i: %d  length: %d  k: %d\n", i, l, k );

      if ( remainingLength < k ) {
        sb = new StringBuilder( s.substring( i ) ).reverse();
        result += sb.toString();
        System.out.printf( "%d is greater than %d so returning result", k, remainingLength );
        return result;
      }

      else if ( remainingLength >= i + j ) {
        System.out.println( "Reversing " + s.substring( i, i + k ) );
        sb = new StringBuilder( s.substring( i, i + k ) ).reverse();
        String string = sb.toString();
        string += s.substring( i + k, i + j );
        System.out.println( "Appending " + string + " to result3" );
        result += string;
        System.out.println( "Result from first if " + result );
      }

      else if ( remainingLength <= k ) {
        sb = new StringBuilder( s.substring( i, i + k ) );

        System.out.println( "Appending " + sb + " to result2" );
        String string = sb.reverse()
                          .toString();

        result += string;
        System.out.println( "RESULT: " + result );
      }
      else if ( remainingLength < j && remainingLength >= k ) {
        sb = new StringBuilder( s.substring( i, i + k ) );

        String string = sb.reverse()
                          .toString();

        string += s.substring( i + k );
        System.out.println( "Appending " + string + " to " + result + " in last if" );
        result += string;
        System.out.println( result );

      }
    }

    return result;
  }



}
