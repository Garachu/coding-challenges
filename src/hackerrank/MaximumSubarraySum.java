package hackerrank;

import java.util.Arrays;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, -1, 2, 3, 4, -5};
        int[] arr3 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr4 = {-2, -3, -1, -4, -6};

        printMaxSubArray(maxSubarray(arr1));
        printMaxSubArray(maxSubarray(arr2));
        printMaxSubArray(maxSubarray(arr3));
        printMaxSubArray(maxSubarray(arr4));

        maxSubarray(arr4);
    }

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {

        int max_so_far = arr[0];
        int max_ending_here = 0;

//        for (int i = 0; i < arr.length; i++) {
//            max_ending_here = max_ending_here + arr[i];
//
//            if (max_ending_here > max_so_far) {
//                max_so_far = max_ending_here;
//            }
//
//            if (max_ending_here < 0) {
//                max_ending_here = 0;
//            }
//        }

        for (int x : arr) {
            max_ending_here = Math.max(x, max_ending_here + x);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }

        int maxSubSequenceSum = 0;
        Arrays.sort(arr);
        //if there is none positive value in entire array
        if (arr[arr.length - 1] <= 0) {
            maxSubSequenceSum = arr[arr.length - 1];
        } else {
            int temp;
            for (int x : arr) {
                temp = maxSubSequenceSum + x;
                if (temp > maxSubSequenceSum) {
                    maxSubSequenceSum = temp;
                }
            }
        }

        return new int[]{max_so_far, maxSubSequenceSum};
    }

    static void printMaxSubArray(int[] results) {
        System.out.println("\n");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + ",");
        }
    }

}
