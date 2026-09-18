package leetcode.easy;

public class ClimbingStairs {

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

  static void main( String[] args ) {

    int n = 6;
    System.out.println( climbStairs( n ) );
  }

  public static int climbStairs( int n ) {

    if ( n == 1 ) {
      return 1;
    }
    if ( n == 2 ) {
      return 2;
    }

    int[] ways = new int[n + 1];
    ways[1] = 1;
    ways[2] = 2;

    for ( int i = 3; i <= n; i++ ) {
      ways[i] = ways[i - 1] + ways[i - 2];
    }
    return ways[n];
  }
}
