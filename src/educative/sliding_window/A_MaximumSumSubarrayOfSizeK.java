package educative.sliding_window;

/**
 * Given an array of positive numbers and a positive number ‘k,’
 * find the maximum sum of any contiguous subarray of size ‘k’.
 */
public class A_MaximumSumSubarrayOfSizeK {

    public static void main(String args[]) {

        // Input: [2, 1, 5, 1, 3, 2], k=3
        // Output: 9
        // Explanation: Subarray with maximum sum is [5, 1, 3].
        int maxSumSubArray1 = findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2});
        System.out.println(maxSumSubArray1);

        // Input: [2, 3, 4, 1, 5], k=2
        // Output: 7
        // Explanation: Subarray with maximum sum is [3, 4].
        int maxSumSubArray2 = findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        System.out.println(maxSumSubArray2);
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            count = count + 1;

            if (count == k) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - arr[i - k + 1];
                count = count - 1;
            }
        }
        return maxSum;
    }

}
