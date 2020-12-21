package educative.two_pointer;

import java.util.Arrays;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 */
public class A_PairWithTargetSum {

    public static void main(String args[]) {

        // Example 1:
        // Input: [1, 2, 3, 4, 6], target=6
        // Output: [1, 3]
        // Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
        int[] arr1 = search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println(Arrays.toString(arr1));


        // Example 2:
        // Input: [2, 5, 9, 11], target=11
        // Output: [0, 2]
        // Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
        int[] arr2 = search(new int[]{2, 5, 9, 11}, 11);
        System.out.println(Arrays.toString(arr2));
    }

    public static int[] search(int[] nums, int targetSum) {
        int[] pair = new int[2];
        int aPointer = 0;
        int bPointer = nums.length - 1;

        while (aPointer != bPointer) {
            int sum = nums[aPointer] + nums[bPointer];

            // If the sum of the two numbers pointed by the two pointers is greater than the target sum, this means that we need a pair with a smaller sum.
            // So, to try more pairs, we can decrement the end-pointer.
            if (sum > targetSum) {
                bPointer--;
            }
            // If the sum of the two numbers pointed by the two pointers is smaller than the target sum, this means that we need a pair with a larger sum.
            // So, to try more pairs, we can increment the start-pointer.
            else if (sum < targetSum) {
                aPointer++;
            } else {
                pair[0] = aPointer;
                pair[1] = bPointer;
                return pair;
            }
        }
        return pair;
    }

}
