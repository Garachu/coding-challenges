package leetcode;

public class MaximumSubArray {

    public static void main(String args[]) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArray2(array));
    }

    public static int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int current_ending_here = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current_ending_here = Math.max(current_ending_here + nums[i],  nums[i]);
            max_so_far = Math.max(max_so_far, current_ending_here);
        }
        return max_so_far;
    }

    public static int maxSubArray2(int[] nums) {
        int[] pos = new int[nums.length];
        pos[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pos[i] = Math.max(pos[i-1] + nums[i], nums[i]);
            System.out.println("Pos --- " + pos[i]);
        }

        int max = pos[0];
        for(int i = 1; i < pos.length; i++){
            max = Math.max(max, pos[i]);
        }
        return max;
    }
}
