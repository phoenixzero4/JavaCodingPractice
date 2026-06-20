package leetcode;

public class Main
{

    static void main(String[] args) {

        /* TwoSum */
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] solution = TwoSum.twoSum(nums, target);
        System.out.println("[" + solution[0] + ", " + solution[1] + "]");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] solution2 = TwoSum.twoSum(nums2, target2);
        System.out.println("[" + solution2[0] + ", " + solution2[1] + "]");

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] solution3 = TwoSum.twoSum(nums3, target3);
        System.out.println("[" + solution3[0] + ", " + solution3[1] + "]");


    }
}
