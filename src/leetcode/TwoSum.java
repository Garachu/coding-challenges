package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(num, i);
            }
        }
        return new int[]{};
    }


}
