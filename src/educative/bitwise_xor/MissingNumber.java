package educative.bitwise_xor;

/**
 * Given an array of n-1n−1 integers in the range from 11 to nn, find the one number that is missing from the array.
 */
public class MissingNumber {

    /**
     * Time & Space complexity:
     * The time complexity of the above algorithm is O(n)
     * space complexity is O(1)
     * <p>
     * Important properties of XOR to remember #
     * Taking XOR of a number with itself returns 0
     * Taking XOR of a number with 0 returns the same number
     * XOR is Associative & Commutative, which means:
     */
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int s1 = 1;
        for (int i = 2; i <= n; i++) {
            s1 = s1 ^ i;
        }

        int s2 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            s2 = s2 ^ arr[i];
        }

        return s1 ^ s2;
    }

    public static void main(String args[]) {

        // Input: 1, 5, 2, 6, 4
        // Answer: 3
        int[] arr = new int[]{1, 5, 2, 6, 4};
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
    }
}
