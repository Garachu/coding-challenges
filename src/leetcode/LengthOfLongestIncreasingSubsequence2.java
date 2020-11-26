package leetcode;

import java.util.Arrays;

public class LengthOfLongestIncreasingSubsequence2 {

    public static void main(String args[]) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS Length: \t" + lengthOfLongestIncreasing(arr));
    }

    private static int lengthOfLongestIncreasing(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
