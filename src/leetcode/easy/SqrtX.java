package leetcode.easy;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative.

Use no built in exponent function
 */
public class SqrtX {

  public static int mySqrt1( int x ) {

    // Todo optimize this method
    if ( x == 0 ) {
      return 0;
    }
    else if ( x < 4 ) {
      return 1;
    }
    else {

      int root = 0;

      for ( int i = 2; i <= x / i; i++ ) {

        if ( x % i == 0 ) {
          root = Math.abs( i );
        }
        else if ( x % i < i ) {
          root = ( int ) Math.floor( Math.abs( i ) );
        }
      }
      return root;
    }
  }

  void main() {

    int x = 4;
    int result = mySqrt( x );
    System.out.println( result );

    x = 2147483647;
    result = mySqrt( x );
    System.out.println( result );
  }

  public static int mySqrt( int x ) {
    // Todo finish this method
    int low = x / 2;
    int square = low * low;

    while ( square * square < x ) {

      if ( x == square * square ) {
        return ( int ) Math.floor( Math.abs( square ) );
      }
      else if ( x > square * square ) {
        low = low - 1;
        square = low * low;
        return ( int ) Math.floor( Math.abs( square ) );
      }
    }
    return square;
  } // END OF METHOD

} // END OF CLASS