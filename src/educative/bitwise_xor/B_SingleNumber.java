package educative.bitwise_xor;


/**
 * Problem Statement #
 * In a non-empty array of integers, every number appears twice except for one, find that single number.
 */
public class B_SingleNumber {

    public static void main(String args[]) {

        // Example 1:
        // Input: 1, 4, 2, 1, 3, 2, 3
        // Output: 4
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));

        // Example 2:
        // Input: 7, 9, 7
        // Output: 9
        System.out.println(findSingleNumber(new int[]{7, 9, 7}));
    }

    /**
     * Solution with XOR #
     * xor properties
     * 1. It returns zero if we take XOR of two same numbers.
     * 2. It returns the same number if we XOR with zero.
     * So we can XOR all the numbers in the input; duplicate numbers will zero out each other and we will be left with the single number.
     * <p>
     * Time Complexity:
     * Time complexity of this solution is O(n) as we iterate through all numbers of the input once.
     * Space Complexity:
     * The algorithm runs in constant space O(1).
     */
    public static int findSingleNumber(int[] arr) {
        int s1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            s1 = s1 ^ arr[i];
        }
        return s1;
    }
}
