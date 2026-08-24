package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 */
public class PlusOne {

  static void main() {

    int[] one = { 1, 2, 3 };
    int[] resultOne = plusOne( one );

    for ( int i = 0; i < resultOne.length; i++ ) {
      System.out.print( resultOne[i] + " " );
    }
    System.out.println();

    int[] two = { 4, 3, 2, 1 };
    int[] resultTwo = plusOne( two );

    for ( int i = 0; i < resultTwo.length; i++ ) {
      System.out.print( resultTwo[i] + " " );
    }

    System.out.println();

    int[] three = { 9 };
    int[] resultThree = plusOne( three );

    for ( int i = 0; i < resultThree.length; i++ ) {
      System.out.print( resultThree[i] + " " );
    }
  }

  public static int[] plusOne( int[] digits ) {

    boolean carry = false;
    int val;
    List<Integer> list = new ArrayList<>();

    for ( int i = digits.length - 1; i >= 0; i-- ) {

      if ( i == digits.length - 1 || carry ) {
        val = digits[i];

        if ( val >= 9 ) {
          carry = true;
          list.addFirst( 0 );
        }
        else {
          list.addFirst( val + 1 );
          carry = false;
        }
      }
      else {
        list.addFirst( digits[i] );
      }
    }

    if ( carry ) {
      list.addFirst( 1 );
    }

    //    int[] result = list.stream()
    //                       .mapToInt( Integer::intValue )
    //                       .toArray();

    int[] result = new int[list.size()];

    for ( int i = 0; i < list.size(); i++ ) {
      result[i] = list.get( i );
    }

    return result;
  }
}
