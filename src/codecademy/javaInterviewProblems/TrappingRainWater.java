package codecademy.javaInterviewProblems;

public class TrappingRainWater {

    static int naiveSolution(int[] heights) {

        int sum = 0;
        int leftMax = 0, leftIndex = 0;
        int rightMax = 0, rightIndex = heights.length - 1;

        for (int i = 0; i < heights.length; i++) {
            int leftBound = 0;
            int rightBound = 0;

            for (int j = 0; j <= i; j++) {
                leftBound = Math.max(leftBound, heights[j]);
            }

            for (int j = i; j < heights.length; j++) {
                rightBound = Math.max(rightBound, heights[j]);
            }

            sum += Math.min(leftBound, rightBound) - heights[i];
        }

        return sum;
    }

    static void main(String[] args) {
        int[] heights = {7, 0, 9, 5, 9};
        System.out.println(naiveSolution(heights));
        System.out.println(optimizedSolution(heights));
    }

    public static int optimizedSolution(int[] heights) {
        int totalWater = 0, leftMax = 0, rightMax = 0;
        int leftIndex = 0, rightIndex = heights.length - 1;

        while (leftIndex < rightIndex) {
            leftMax = Math.max(leftMax, heights[leftIndex]);
            rightMax = Math.max(rightMax, heights[rightIndex]);
            totalWater += Math.min(leftMax, rightMax) - heights[leftIndex];
            if (leftMax <= rightMax) leftIndex++;
            else rightIndex--;
        }

        return totalWater;
    }
}
