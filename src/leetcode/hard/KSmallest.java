package leetcode.hard;

import java.util.Arrays;

public class KSmallest {
 /*
 You are given an integer array coins representing coins of different denominations and an integer k.

You have an infinite number of coins of each denomination. However, you are not allowed to combine coins of different denominations.

Return the kth smallest amount that can be made using these coins.


Example 1:

Input: coins = [3,6,9], k = 3

Output: 9

Explanation: The given coins can make the following amounts:
Coin 3 produces multiples of 3: 3, 6, 9, 12, 15, etc.
Coin 6 produces multiples of 6: 6, 12, 18, 24, etc.
Coin 9 produces multiples of 9: 9, 18, 27, 36, etc.
All of the coins combined produce: 3, 6, 9, 12, 15, etc.

Example 2:

Input: coins = [5,2], k = 7

Output: 12

Explanation: The given coins can make the following amounts:
Coin 5 produces multiples of 5: 5, 10, 15, 20, etc.
Coin 2 produces multiples of 2: 2, 4, 6, 8, 10, 12, etc.
All of the coins combined produce: 2, 4, 5, 6, 8, 10, 12, 14, 15, etc.


Constraints:

1 <= coins.length <= 15
1 <= coins[i] <= 25
1 <= k <= 2 * 109
coins contains pairwise distinct integers.
  */

  // Todo improve runtime (currently 183ms - beats 7.84% and memory 44.09 - beats 66.67%

  /* Lowest can be smallest element in array and highest can be smallest element * k */

  static void main() {

    int[] coins = { 3, 6, 9 };
    int k = 3;

    System.out.println( findKthSmallest( coins, k ) );

    int[] coins2 = { 5 };
    int k2 = 7;

    System.out.println( findKthSmallest( coins2, k2 ) );
  }

  public static long findKthSmallest( int[] coins, int k ) {

    // Sort and remove duplicates or multiples of other coins to optimize PIE
    Arrays.sort( coins );
    int[] cleanCoins = Arrays.stream( coins )
                             .distinct()
                             .toArray();

    long low = 1;
    long high = ( long ) cleanCoins[0] * k;
    long ans = high;

    while ( low <= high ) {
      long mid = low + ( high - low ) / 2;

      if ( countMultiples( mid, cleanCoins ) >= k ) {
        ans = mid;
        high = mid - 1; // Try to find a smaller valid amount
      }
      else {
        low = mid + 1;  // Amount is too small
      }
    }
    return ans;
  }

  // Counts how many multiples of the given coins exist up to 'maxVal' using PIE (Principle of
  // Inclusion-Exclusion)
  private static long countMultiples( long maxVal, int[] coins ) {

    long count = 0;
    int n = coins.length;
    int totalSubsets = 1 << n; // 2^n subsets

    // Iterate through all possible non-empty subsets
    for ( int i = 1; i < totalSubsets; i++ ) {
      long currentLcm = 1;
      int bitCount = 0;
      boolean overflow = false;

      for ( int j = 0; j < n; j++ ) {
        if ( ( ( i >> j ) & 1 ) == 1 ) {
          bitCount++;
          currentLcm = lcm( currentLcm, coins[j] );

          // Optimization: if LCM exceeds maxVal, its contribution to the count is 0
          if ( currentLcm > maxVal ) {
            overflow = true;
            break;
          }
        }
      }

      if ( !overflow ) {
        if ( bitCount % 2 == 1 ) {
          count += maxVal / currentLcm;  // Odd size subset: Add
        }
        else {
          count -= maxVal / currentLcm;  // Even size subset: Subtract
        }
      }
    }
    return count;
  }

  // Helper method to find Least Common Multiple
  private static long lcm( long a, long b ) {

    return ( a / gcd( a, b ) ) * b;
  }

  // Helper method to find Great Common Divisor
  private static long gcd( long a, long b ) {

    while ( b != 0 ) {
      long temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
