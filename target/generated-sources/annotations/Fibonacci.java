package practice.coreJava.algorithms;

// TODO COMPLETE FIBONACCI ALGORITHM WITH MEMOIZATION
public class Fibonacci {

  public static long fib( int n ) {

    if ( n <= 1 ) {
      return n;
    }
    return fib( n - 1 ) + fib( n - 2 );
  }

  static void main( String[] args ) {

    int n = 6;
    long result = fib( n );

    System.out.println( result );
  }
}
