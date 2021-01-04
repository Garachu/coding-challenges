package sorting;

public class BubbleSort {

    public static void main(String args[]) {
        int[] arr = new int[]{5, 4, 2, 3, 7, 1};

        // print array before sorting
        System.out.println("array before sorting");
        printArray(arr);

        // sort array
        bubbleSortArray(arr);

        // print array after sorting
        System.out.println("array after sorting");
        printArray(arr);
    }

    private static void bubbleSortArray(int[] nums) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < nums.length; i++) {
                int prev = nums[i - 1];
                int current = nums[i];
                if (current < prev) {
                    sorted = false;
                    nums[i - 1] = current;
                    nums[i] = prev;
                }
            }
        }
    }

    static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
