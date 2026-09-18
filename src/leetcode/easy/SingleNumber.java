package leetcode.easy;

/*
Given a non-empty array of integers, every element appears twice except for one.
Find that one.

The solution must have a linear runtime and constant extra space
 */

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

  static void main() {

    int[] nums = { 1, 8, 2, 2, 8 };

    int result = singleNumber( nums );
    System.out.println( result );
    int a = 4;
    int b = 1;
    System.out.println( a ^ b );
    System.out.println( a ^= b );

  }

  public static int singleNumber( int[] nums ) {

    int result = 0;

    for ( int n : nums ) {
      System.out.printf( "result: %d n: %d\n", result, n );
      result ^= n;
      System.out.printf( "%d ^= %d = %d\n", result, n, result ^ n );
    }

    return result;
  }

  public static int singleNumber2( int[] nums ) {

    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 0;

    for ( int i = 0; i < nums.length; i++ ) {
      int element = nums[i];
      if ( map.containsKey( element ) ) {
        map.put( element, map.get( element ) + 1 );
      }
      else {
        map.put( element, 1 );
      }
    }
    for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
      if ( entry.getValue() == 1 ) {
        return entry.getKey();
      }
    }
    return result;
  }
}
