package leetcode.easy;

import java.util.Arrays;

public class SearchInsertPosition {

  static void main() {

    int[] nums = { 1, 3, 5, 6 };
    int target = 5;

    int[] nums2 = { 1, 3, 5, 6 };
    int target2 = 2;

    int[] nums3 = { 1, 3, 5, 6 };
    int target3 = 7;

    int one = searchInsert( nums, target );
    System.out.println( one );

    int two = searchInsert( nums2, target2 );
    System.out.println( two );

    int three = searchInsert( nums3, target3 );
    System.out.println( three );
  }

  public static int searchInsert( int[] nums, int target ) {

    int result = Arrays.binarySearch( nums, target );

    return result = result >= 0 ? result : Math.abs( result ) - 1;
  }
}
