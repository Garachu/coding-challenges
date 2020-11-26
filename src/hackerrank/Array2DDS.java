package hackerrank;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class Array2DDS {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr1 = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] arr2 = {{-9, -9, -9, 1, 1, 1}, {0, -9, 0, 4, 3, 2}, {-9, -9, -9, 1, 2, 3}, {0, 0, 8, 6, 6, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, 1, 2, 4, 0}};
        int[][] arr3 = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}};

        int result = hourglassSum(arr3);
        System.out.println("Array Result: \t" + result);
//        result = hourglassSum(arr2);
//        System.out.println("Array 2 Result: \t" + result);
        scanner.close();
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int result = 0;
        // row
        for (int i = 0; i <= 3; i++) {
            // column
            for (int j = 0; j <= 3; j++) {
                int total =
                        arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                                + arr[i + 1][j + 1]
                                + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (i == 0 && j == 0) {
                    result = total;
                } else {
                    result = Math.max(total, result);
                }

            }
        }
        return result;
    }

    // input array
    static int[][] inputArray() {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 3; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        return arr;
    }

    // print array
    static void printArray(int[][] arr) {
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print("\t" + arr[i][j]);
            }
        }
    }

}
