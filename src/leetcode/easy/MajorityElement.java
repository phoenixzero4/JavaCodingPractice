package leetcode.easy;

/*
	MAJORITY ELEMENT

	Given an array nums of size n, return the majority element.

	The majority element is the element that appears more than n/2 times.
	A majority element always exists in the array
 */
public class MajorityElement {

	public static int majorityElement( int[] nums ) {

		int possible = 0;
		int count = 0;

		for ( int num : nums ) {
			if ( count == 0 ) {
				possible = num;
			}
			count += (num == possible) ? 1 : -1;
		}

		return possible;
	}

	static void main( String[] args ) {

		int[] nums = {3, 2, 3};
		int result = majorityElement(nums);
		System.out.println(result);

		int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
		int result1 = majorityElement(nums1);
		System.out.println(result1);
			
	}
}
