package educative.two_pointer;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Problem Statement #
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
public class E_TripletSumToZero {

    public static void main(String args[]) {

        // Input: [-3, 0, 1, 2, -1, 1, -2]
        // Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
        // Explanation: There are four unique triplets whose sum is equal to zero.
        List<List<Integer>> triplets1 = searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
        System.out.println(triplets1.toString());

        // Input: [-5, 2, -1, -2, 3]
        // Output: [[-5, 2, 3], [-2, -1, 3]]
        // Explanation: There are two unique triplets whose sum is equal to zero.
        List<List<Integer>> triplets2 = searchTriplets(new int[]{-5, 2, -1, -2, 3});
        System.out.println(triplets2.toString());
    }

    /**
     * Solution #
     * This problem follows the Two Pointers pattern and shares similarities with Pair with Target Sum.
     * A couple of differences are that the input array is not sorted and instead of a pair we need to find triplets with a target sum of zero.
     * <p>
     * To follow a similar approach, first, we will sort the array and then iterate through it taking one number at a time.
     * Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0X+Y+Z==0.
     * At this stage, our problem translates into finding a pair whose sum is equal to “-X−X” (as from the above equation Y + Z == -XY+Z==−X).
     * <p>
     * Another difference from Pair with Target Sum is that we need to find all the unique triplets. To handle this, we have to skip any duplicate number.
     * Since we will be sorting the array, so all the duplicate numbers will be next to each other and are easier to skip.
     * <p>
     * Time complexity #
     * Sorting the array will take O(N * logN). The searchPair() function will take O(N). As we are calling searchPair() for every number in the input array, this means that overall searchTriplets() will take O(N * logN + N^2)
     * ​​which is asymptotically equivalent to O(N^2)O(N
     * <p>
     * Space complexity #
     * Ignoring the space required for the output array, the space complexity of the above algorithm will be O(N) which is required for sorting.
     */
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            search(arr, triplets, i + 1, -arr[i]);
        }
        return triplets;
    }

    public static void search(int[] arr, List<List<Integer>> triplets, int left, int targetSum) {
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                List<Integer> temp = Arrays.asList(-targetSum, arr[left], arr[right]);
                triplets.add(temp);
                left++;
                right--;
                while (arr[left] == arr[left - 1]) {
                    left++;
                }
                while (arr[right] == arr[right - 1]) {
                    right--;
                }
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

    }

}
