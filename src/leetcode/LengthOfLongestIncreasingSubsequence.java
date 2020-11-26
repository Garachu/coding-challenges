package leetcode;

import java.util.Arrays;

public class LengthOfLongestIncreasingSubsequence {

    public static void main(String args[]) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS Length: \t" + lengthOfLIS(arr));
    }

    private static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        // storing the length of the subsequence
        int[] length = new int[nums.length];
        Arrays.fill(length, 1);

        for (int i = 1; i < nums.length; i++) {
            int iElement = nums[i];
            for (int j = 0; j < i; j++) {
                int jElement = nums[j];
                if (jElement < iElement) {
                    int len = length[j] + 1;
                    if (len >= length[i]) {
                        length[i] = len;
                    }
                }
            }
        }

        System.out.println("Length:");
        Arrays.stream(length).forEach(l -> System.out.print("\t" + l));

        // Get Maximum length
        return Arrays.stream(length).max().getAsInt();
    }
}
