package leetcode;

public class RotateArray {

    public static void main(String args[]) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);

        // len == 7
        // 0 1 2 3 4 5 6
        // 1 2 3 4 5 6 7
        // 3 4 5 6 0 1 2
    }

    static void rotate(int[] nums, int k) {
        int len = nums.length;
        int r = k % len;
        int l = len - r;
        int temp[] = new int[len];
        for(int i = 0; i < len; i++) temp[i] = nums[i];
        for(int i = 0; i < len; i++) nums[(i + k) % len] = temp[i];
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }
}
