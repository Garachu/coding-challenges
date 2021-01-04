package educative.bitwise_xor;

import java.util.*;

/**
 * Problem Statement #
 * In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
 * Find the two numbers that appear only once.
 */
public class C_TwoSingleNumbers {

    /**
     * Solution with HashMap #
     *
     * @return
     */
    public static Integer[] findSingleNumbersHashMap(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        return set.stream().toArray(Integer[]::new);
    }

    /**
     * Time Complexity #
     * The time complexity of this solution is O(n) where ‘n’ is the number of elements in the input array.
     * <p>
     * Space Complexity #
     * The algorithm runs in constant space O(1).
     */
    public static int[] findSingleNumbersBinary(int[] nums) {
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        int rightMostSetBit = 1;
        while ((rightMostSetBit & n1xn2) == 0) {
            rightMostSetBit = rightMostSetBit << 1;
        }

        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((num & rightMostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        // Example 1:
        // Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
        // Output: [4, 6]
        int[] arr = new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        int[] result = findSingleNumbersBinary(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        // Example 2:
        // Input: [2, 1, 3, 2]
        // Output: [1, 3]
        arr = new int[]{2, 1, 3, 2};
        result = findSingleNumbersBinary(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
