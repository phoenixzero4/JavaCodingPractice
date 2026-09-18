package leetcode.easy;

/*
#231 Power of Two

Given an integer n, return true if it is a power of 2.
Otherwise, return false;

 */
public class PowerOfTwo {

  static void main() {

    int n = 2147483646;
    System.out.println( isPowerOfTwo( n ) );

    int x = 134217727;
    System.out.println( isPowerOfTwo( x ) );
  }

  public static boolean isPowerOfTwo( int n ) {

    if ( n <= 2 && n > 0 ) {
      return true;
    }

    if ( n % 2 != 0 ) {
      return false;
    }
    else {
      // 2147483646 1073741824 -2147483648

      /*
      This works but the question is bs because they state 'an int' but give an input
      larger than a primitive can hold.
       */
      for ( int i = 4; i <= 1073741824 && i > 0; i *= 2 ) {

        if ( n / i == 1 && n % i == 0 ) {
          return true;
        }
        else if ( i > n ) {
          return false;
        }

        System.out.println( "i: " + i + " n: " + n );

      }
    }
    return false;
  }
}

