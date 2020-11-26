package practice;

public class Merge2SortedArrays {

    public static void main(String arg[]) {
        int[] arr1 = new int[]{2, 5, 7, 14, 50};
        int[] arr2 = new int[]{1, 3, 3, 4, 15, 20, 60};
        int[] ints = mergeSortedArrays(arr1, arr2);
        printArray(ints);
    }

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        System.out.println("len1: " + len1);
        System.out.println("len2: " + len2);

        int[] result = new int[(arr1.length + arr2.length)];
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < len1 && rightPointer < len2) {
            if (arr1[leftPointer] <= arr2[rightPointer]) {
                result[resultPointer++] = arr1[leftPointer++];
            } else {
                result[resultPointer++] = arr2[rightPointer++];
            }
        }

        while (leftPointer < len1) {
            result[resultPointer++] = arr1[leftPointer++];
        }

        while (rightPointer < len2) {
            result[resultPointer++] = arr2[rightPointer++];
        }

        return result;

    }

    static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
