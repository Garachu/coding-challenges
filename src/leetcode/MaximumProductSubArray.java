package leetcode;

public class MaximumProductSubArray {

    public static void main(String args[]) {
        int[] array = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(array));
    }

    private static int maxProduct(int[] nums) {
        int max_overall = nums[0];
        int max_ending_here = nums[0];
        int min_ending_here = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max_ending_here;
            max_ending_here = Math.max(Math.max(nums[i], nums[i] * max_ending_here), nums[i] * min_ending_here);
            min_ending_here = Math.min(Math.min(nums[i], nums[i] * tmp), nums[i] * min_ending_here);
            max_overall = Math.max(max_overall, max_ending_here);
        }
        return max_overall;
    }
}
