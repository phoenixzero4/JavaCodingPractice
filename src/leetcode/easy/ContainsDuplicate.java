package leetcode.easy;

import java.util.HashMap;

public class ContainsDuplicate {

  static void main() {

    int[] nums = { 1, 2, 3, 1 };
    boolean result = containsDuplicate( nums );
    System.out.println( result );

  }

  /*

  Leetcode 217: Contains Duplicates

  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
  */

  public static boolean containsDuplicate( int[] nums ) {

    HashMap<Integer, Integer> map = new HashMap<>();
    int answer = 0;
    for ( int i = 0; i < nums.length; i++ ) {
      int num = nums[i];

      if ( map.containsKey( num ) ) {
        map.put( num, map.get( num ) + 1 );
      }
      else {
        map.put( num, 1 );
      }

      if ( map.getOrDefault( num, 1 ) > 1 ) {
        return true;
      }
    }
    //    for ( Map.Entry<Integer, Integer> entry : map.entrySet() ) {
    //      if ( entry.getValue() > 1 ) {
    //        answer = entry.getKey();
    //        return true;
    //      }

    return false;
  }
}
