package educative.two_pointer;

import java.util.Arrays;

/**
 * Problem Statement #
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * <p>
 * Solution #
 * This is a straightforward question.
 * The only trick is that we can have negative numbers in the input array, which will make it a bit difficult to generate the output array with squares in sorted order.
 * <p>
 * An easier approach could be to first find the index of the first non-negative number in the array. After that, we can use Two Pointers to iterate the array.
 * One pointer will move forward to iterate the non-negative numbers, and the other pointer will move backward to iterate the negative numbers.
 * At any step, whichever number gives us a bigger square will be added to the output array. For the above-mentioned Example-1, we will do something like this:
 * <p>
 * Since the numbers at both ends can give us the largest square, an alternate approach could be to use two pointers starting at both ends of the input array.
 * At any step, whichever pointer gives us the bigger square, we add it to the result array and move to the next/previous number according to the pointer.
 */
public class D_SquaringASortedArray {

    public static void main(String args[]) {

        // Example 1:
        // Input: [-2, -1, 0, 2, 3]
        // Output: [0, 1, 4, 4, 9]
        int[] arr1 = makeSquares(new int[]{-2, -1, 0, 2, 3});
        System.out.println(Arrays.toString(arr1));


        // Example 2:
        // Input: [-3, -1, 0, 1, 2]
        // Output: [0, 1, 1, 4, 9]
        int[] arr2 = makeSquares(new int[]{-3, -1, 0, 1, 2});
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * Time complexity #
     * The below algorithm’s time complexity will be O(N) as we are iterating the input array only once.
     * <p>
     * Space complexity #
     * The below algorithm’s space complexity will also be O(N); this space will be used for the output array.
     */
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int n = arr.length - 1;
        int aPointer = 0;
        int bPointer = arr.length - 1;
        while ((aPointer <= bPointer)) {
            int leftSquare = arr[aPointer] * arr[aPointer];
            int rightSquare = arr[bPointer] * arr[bPointer];

            if (leftSquare > rightSquare) {
                squares[n] = leftSquare;
                aPointer++;
            } else {
                squares[n] = rightSquare;
                bPointer--;
            }
            n--;
        }
        return squares;
    }
}
