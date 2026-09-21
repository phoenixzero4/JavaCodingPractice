package leetcode.easy;

import java.util.Arrays;

public class MedianOf2Arrays {

  static void main() {

    int[] one = { 0, 0, 0, 0, 0 };
    int[] two = { -1, 0, 0, 0, 0, 0, 1 };

    double result1 = findMedianSortedArrays( one, two );
    System.out.println( "Result1: " + result1 );

    int[] three = { 1, 3 };
    int[] four = { 2 };
    double result2 = findMedianSortedArrays( three, four );
    System.out.println( "\nResult2: " + result2 );

    int[] five = { 1, 3 };
    int[] six = { 2, 4, 5 };
    double result3 = findMedianSortedArrays( five, six );
    System.out.println( "\nResult3: " + result3 );

    int[] seven = { 2 };
    int[] eight = {};
    double result4 = findMedianSortedArrays( seven, eight );
    System.out.println( "\nResult4: " + result4 );

  }

  // Todo complete this method
  public static double findMedianSortedArrays( int[] nums1, int[] nums2 ) {

    double result = 0;
    int l1 = nums1.length;
    int l2 = nums2.length;

    int[] mergedArray = new int[l1 + l2];

    System.arraycopy( nums1, 0, mergedArray, 0, l1 );
    System.arraycopy( nums2, 0, mergedArray, l1, l1 + l2 );

    // sort mergedArray
    Arrays.sort( mergedArray );
    System.err.println();
    for ( Integer i : mergedArray ) {
      System.out.println( i + " " );
    }

    return result;
  }

  public static double findMedianSortedArrays2( int[] nums1, int[] nums2 ) {

    double median = 0;

    for ( int i = 0; i < nums1.length; i++ ) {
      System.err.print( nums1[i] + " " );
    }

    System.err.println();

    for ( int j = 0; j < nums2.length; j++ ) {
      System.err.print( nums2[j] + " " );
    }

    if ( nums1.length > 0 && nums2.length > 0 ) {
      int[] mergedArray = new int[nums1.length + nums2.length];

      System.arraycopy( nums1, 0, mergedArray, 0, nums1.length - 1 );
      System.arraycopy( nums2, 0, mergedArray, nums1.length, nums2.length );
      Arrays.sort( mergedArray );

      int length = mergedArray.length;
      int middle;
      int half = length / 2;

      if ( length % 2 == 0 ) {
        middle = half - 1;
        median = mergedArray[half] + mergedArray[middle];
        median /= 2;

        return median;
      }
      else {
        median = mergedArray[half + 1];
        return median;
      }
    }
    else if ( nums1.length < 1 ) {
      int length = nums2.length;

      if ( length < 2 ) {
        return nums2[0];
      }
      else if ( length % 2 == 0 ) {
        median = nums2[length / 2] + nums2[( length / 2 ) + 1];
        return median;
      }
      else {
        return nums2[length / 2];
      }
    }
    else if ( nums2.length < 1 ) {

      int length = nums1.length;
      if ( length < 2 ) {
        return nums1[0];
      }
      else if ( length % 2 == 0 ) {
        median = nums1[length / 2] + nums1[( length / 2 ) + 1];
        return median;
      }
      else {
        return nums2[length / 2];
      }
    }

    return median;
  }
}
