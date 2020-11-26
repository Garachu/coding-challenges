package leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String arg[]) {
        int[] arr1 = new int[]{2, 5, 7, 14, 50, 0, 0, 0, 0, 0, 0, 0};
        int[] arr2 = new int[]{1, 3, 3, 4, 15, 20, 60};
        mergeSortedArrays(arr1, 5, arr2, 7);
        printArray(arr1);
    }

    static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[m + n];
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < m && rightPointer < n) {
            if (nums1[leftPointer] <= nums2[rightPointer]) {
                result[resultPointer++] = nums1[leftPointer++];
            } else {
                result[resultPointer++] = nums2[rightPointer++];
            }
        }

        while (leftPointer < m) {
            result[resultPointer++] = nums1[leftPointer++];
        }

        while (rightPointer < n) {
            result[resultPointer++] = nums2[rightPointer++];
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }

    }

    static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
