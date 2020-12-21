package educative.two_pointer;

import java.util.Arrays;

/**
 * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
 */
public class C_RemoveInstancesOfKeyInPlace {

    public static void main(String args[]) {

        // Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
        // Output: 4
        // Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
        int a1 = removeInstances(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3);
        System.out.println(a1);

        // Input: [2, 11, 2, 2, 1], Key=2
        // Output: 2
        // Explanation: The first two elements after removing every 'Key' will be [11, 1].
        int a2 = removeInstances(new int[]{2, 11, 2, 2, 1}, 2);
        System.out.println(a2);
    }

    public static int removeInstances(int[] arr, int k) {
        int aPointer = 0;
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            if (t != k) {
                arr[aPointer] = arr[i];
                aPointer++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return aPointer;
    }
}
