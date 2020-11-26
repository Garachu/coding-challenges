package leetcode;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {

    public static void main(String args[]) {
        int[] array = new int[]{2, 3, 2};
        System.out.println("Log -> " + rob(array));
    }

    private static int rob(int[] nums) {
        int len = nums.length;
        int a = check(nums, 0, len - 2);
        int b = check(nums, 1, len - 1);
        return Math.max(a, b);
    }

    private static int check(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }


}
