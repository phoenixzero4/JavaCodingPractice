package leetcode.medium;

/**
 * Phoenix
 * Sep 22 2026
 */

/**
 *  PROBLEM DESCRIPTION (The problem description is TERRIBLE)
 *
 *  Leetcode medium 11 - container witht the most water
 *  You are given an integer array height of length n. There are n vertical lines drawn such that
 *  the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 *  Find two lines that together with the x-axis form a container such that the container
 *  contains the most water.
 *
 *  Return the maximum amount of water a container can store.
 *
 */

public class ContainerWithMostWater {

  public static int maxArea(int[] height){
    int mostWater = 0;
    int leftIndex = 0;
    int rightIndex = height.length -1;
    int leftHeight = height[leftIndex];
    int rightHeight = height[rightIndex];
    int span = rightIndex - leftIndex;
    int water = 0;

    for(int i = 0; i < rightIndex; i++){
      leftIndex = i;
      leftHeight = height[leftIndex];
      span = rightIndex - leftIndex;
      water = Math.min(leftHeight, rightHeight) * span;

      if(water > mostWater){
        mostWater = water;
      }
    }

    for(int j = height.length-1; j > leftIndex; j--) {
      rightIndex = j;
      rightHeight = height[j];
      span = rightIndex - leftIndex;
      water = Math.min( leftHeight, rightHeight ) * span;
      mostWater = Math.max( water, mostWater );

    }
    return mostWater;
  }

  public static int maxArea2( int[] height ) {
    int left = 0;
    int right = height.length - 1;
    int mostWater = 0;

    while (left < right) {
      int currentArea = Math.min(height[left], height[right]) * (right - left);
      mostWater = Math.max(mostWater, currentArea);

      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return mostWater;
  }

  static void main() {
    int[] array = {1,8,6,2,5,4,8,3,7};
    int[] array2 = {8,7,2,1};

    System.out.println(maxArea( array));
    System.out.println(maxArea( array2 ));

    System.out.println();

    System.out.println(maxArea2(array));
    System.out.println(maxArea2(array2));

  }
}
