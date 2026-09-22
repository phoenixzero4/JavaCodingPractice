package leetcode.easy;

import java.util.Arrays;

public class MedianOf2Arrays {

  /*
   Given 2 sorted arrays, combine them and return the median.
   */

  static void main() {

    int[] one = { 0, 0, 0, 0, 0 };
    int[] two = { -1, 0, 0, 0, 0, 0, 1 };

    double median = findMedianSortedArrays( one, two );

    int[] three = { 1, 3 };
    int[] four = { 2 };
    median = findMedianSortedArrays( three, four );

    int[] five = { 1, 3 };
    int[] six = { 2, 4 };
    median = findMedianSortedArrays( five, six );

    int[] seven = { 2 };
    int[] eight = {};
    median = findMedianSortedArrays( seven, eight );

  }

  public static double findMedianSortedArrays( int[] nums1, int[] nums2 ) {

    double median = 0;
    int l1 = nums1.length;
    int l2 = nums2.length;
    int totalLength = l1 + l2;

    int[] mergedArray = new int[l1 + l2];

    System.arraycopy( nums1, 0, mergedArray, 0, l1 );
    System.arraycopy( nums2, 0, mergedArray, l1, l2 );

    // sort mergedArray
    Arrays.sort( mergedArray );

    if ( mergedArray.length % 2 != 0 ) {
      median = mergedArray[mergedArray.length / 2];
    }
    else {
      int mid1 = mergedArray[( totalLength / 2 ) - 1];
      int mid2 = mergedArray[totalLength / 2];
      median = ( mid1 + mid2 ) / 2.0;
    }

    System.out.printf( "median of %s is %.1f\n", Arrays.toString( mergedArray ), median );

    return median;
  }
}
