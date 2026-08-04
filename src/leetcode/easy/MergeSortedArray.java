package leetcode.easy;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
 the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

	static void merge( int[] nums1, int m, int[] nums2, int n ) {

		for ( Integer i : nums2 ) {
			nums1[m] = i;
			m++;
		}
		Arrays.sort(nums1);

		for ( Integer j : nums1 ) {
			System.out.print(j + " " );
		}
	}

	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {

			// Why is it faster with the first array copy?
			// It still works without it but is marginally slower (and takes more memory)
			System.arraycopy(nums1, 0, nums1, 0, m);
			System.arraycopy( nums2, 0, nums1, m, n);
			Arrays.sort(nums1);

		}
	}

	static void main( String[] args ) {

		int[] n1 = {1, 2, 3, 0, 0, 0};
		int[] n2 = {2, 5, 6};
		int n = 3, m = 3;

		merge(n1, m, n2, n);
	}

}
