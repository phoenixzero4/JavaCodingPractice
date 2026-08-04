package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

	// Solution in O(n^2) (Quadratic run time)
	// Using nested loops quadruples the work as the input size doubles
	static int[] twoSum( int[] nums, int target ) {

		int[] solution = new int[2];

		for ( int i = 0; i < nums.length; i++ ) {

			for ( int j = 0; j < nums.length; j++ ) {

				if ( i != j ) {
					if ( nums[i] + nums[j] == target ) {
						solution[0] = i;
						solution[1] = j;
						return solution;
					}
				}
			}
		}

		return solution;
	}

	// Solution in O(n) (Linear) Time
	static int[] efficientTwoSum( int[] nums, int target ) {

		Map<Integer, Integer> map = new HashMap<>();

		for ( int i = 0; i < nums.length; i++ ) {
			int complement = target - nums[i];

			if ( map.containsKey(complement) ) {
				return new int[]{map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No solution found" );
	}

	// Runs in Quadratic time using Streams
	static int[] twoSumWithStreams( int[] nums, int target ) {

		return IntStream.range(0, nums.length)
				.boxed()
				.flatMap(i ->
						IntStream.range(i + 1, nums.length)
								.filter(j -> nums[i] + nums[j] == target)
								.mapToObj(j -> new int[]{i, j})
				)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No Solution" ));
	}

	static int[] recordTwoSum( int[] nums, int target ) {

		Map<Integer, Integer> map = new HashMap<>();

		for ( int i = 0; i < nums.length; i++ ) {
			int complement = target - nums[i];

			if ( map.containsKey(complement) ) {
				Pair result = new Pair(map.get(complement), i);
				return new int[]{result.i(), result.j()};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No Solution in recordTwoSum approach" );
	}

	static void main( String[] args ) {

		int[] numbers = {1, 5, 3, 2, 4};
		int target = 6;

		int[] solution = twoSumWithStreams(numbers, target);
		int index1 = solution[0];
		int index2 = solution[1];
		int element1 = numbers[index1];
		int element2 = numbers[index2];

		if ( index1 != index2 ) {
			System.out.printf("numbers[%d] = %d\nnumbers[%d] = %d\n", index1, element1, index2, element2);
			System.out.printf("\t%d + %d = %d", element1, element2, target);
		} else {
			System.out.print("There are no numbers in the array that add up to target" );
		}

	}

	record Pair(int i, int j) {

	}
}
