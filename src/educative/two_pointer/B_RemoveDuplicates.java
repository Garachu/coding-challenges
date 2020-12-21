package educative.two_pointer;

import java.util.Arrays;

/**
 * Problem Statement #
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 * <p>
 * Solution #
 * In this problem, we need to remove the duplicates in-place such that the resultant length of the array remains sorted.
 * As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates. In other words, we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number. So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.
 */
public class B_RemoveDuplicates {

    public static void main(String args[]) {
        // Input: [2, 3, 3, 3, 6, 9, 9]
        // Output: 4
        // Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
        int out1 = removeDuplicates(new int[]{2, 3, 3, 3, 6, 9, 9});
        System.out.println(out1);
    }

    /**
     * Time Complexity #
     * The time complexity of the below algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * Space Complexity #
     * The algorithm runs in constant space O(1)O(1).
     */
    public static int removeDuplicates(int[] arr) {
        int aPointer = 0;
        int bPointer = 1;
        int len = arr.length;

        while (bPointer < len) {
            if (arr[aPointer] != arr[bPointer]) {
                arr[++aPointer] = arr[bPointer];
            }
            bPointer++;
        }
        System.out.println(Arrays.toString(arr));
        return aPointer + 1;
    }
}
