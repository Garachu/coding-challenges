package leetcode;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3]
 * Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3]
 * Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String args[]) {
        System.out.println("Example 1");
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(nums);
        System.out.println("Count: " + res);
        System.out.println("Array == " + nums);
        printArray(nums, res);


        System.out.println("Example 2\n");
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res2 = removeDuplicates(nums2);
        System.out.println("Count: " + res2);
        System.out.println("Array == " + nums2);
        printArray(nums2, res2);
    }

    static int removeDuplicates(int[] nums) {
        int count = 1;
        int aPointer = 0;
        int bPointer = 1;
        int dup = 1;
        int len = nums.length;

        while (bPointer < len) {
            System.out.println("bPointer : " + nums[bPointer]);
            if (nums[aPointer] == nums[bPointer] && dup < 2) {
                System.out.println("nums[aPointer] == nums[bPointer] && dup < 2");
                aPointer++;
                nums[aPointer] = nums[bPointer++];
                dup++;
                count++;
            } else if (nums[aPointer] == nums[bPointer] && dup >= 2) {
                System.out.println("nums[aPointer] == nums[bPointer] && dup >= 2");
                dup++;
                bPointer++;
            } else {
                System.out.println("else");
                dup = 1;
                aPointer++;
                nums[aPointer] = nums[bPointer++];
                count++;
            }
        }
        return count;
    }

    static void printArray(int nums[], int len) {
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i] + "\t");
        }
    }
}
