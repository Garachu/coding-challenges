package educative.sliding_window;

/**
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 */
public class SmallestSubarrayWithGivenSum {

    public static void main(String args[]) {
        // Input: [2, 1, 5, 2, 8], S=7
        // Output: 1
        // Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
        int minSubArray1 = findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println(minSubArray1);

        // Input: [3, 4, 1, 1, 6], S=8
        // Output: 3
        // Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
        int minSubArray2 = findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println(minSubArray2);
    }

    public static int findMinSubArray(int S, int[] arr) {
        int minSubArray = 0;
        int sum = 0;
        int bPointer = 0;
        boolean f = true;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            while (sum >= S) {
                if (f) {
                    minSubArray = (i - bPointer + 1);
                } else {
                    minSubArray = Math.min(minSubArray, (i - bPointer + 1));
                }
                sum = sum - arr[bPointer];
                bPointer = bPointer + 1;
            }

        }
        return minSubArray;
    }
}
