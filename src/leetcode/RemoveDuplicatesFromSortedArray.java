package leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4]
 * Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String args[]) {
        int[] nums = new int[]{1, 1, 2};
        int count = removeDuplicates(nums);
        System.out.println("Count: " + count);
        System.out.println("Array == " + nums);
        printArray(nums);
    }

    static int removeDuplicates(int[] nums) {
        int aPointer = 0;
        int bPointer = 1;
        int count = 1;
        int len = nums.length;

        while (bPointer < len) {
            if (nums[aPointer] == nums[bPointer]) {
                bPointer++;
            } else {
                aPointer++;
                nums[aPointer] = nums[bPointer++];
                count++;
            }
        }
        return count;
    }

    static void printArray(int nums[]) {
        for (int num : nums) {
            System.out.println(num + "\t");
        }
    }
}
