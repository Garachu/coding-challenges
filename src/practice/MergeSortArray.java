package practice;

public class MergeSortArray {

    public static void main(String args[]) {
        int[] arr = new int[]{5, 4, 2, 3, 7, 1};

        // print array before sorting
        System.out.println("array before sorting");
        printArray(arr);

        // sort array
        sortArray(arr, 0, arr.length - 1);

        // print array after sorting
        System.out.println("array after sorting");
        printArray(arr);
    }

    static void sortArray(int[] nums, int lb, int ub) {
         if (lb == ub) {
            return;
        }
        int mid = (lb + ub) / 2;
        sortArray(nums, lb, mid);
        sortArray(nums, mid + 1, ub);
        sortAndMergeArray(nums, lb, mid, ub);
    }

    static void sortAndMergeArray(int[] nums, int lb, int mid, int ub) {
        System.out.println("sort sort: " + lb + "\t" + mid + "\t" + ub);

        int leftPointer = lb;
        int rightPointer = mid + 1;
        int[] result = new int[(ub - lb) + 1];
        int resultPointer = 0;

        System.out.println("lp: == " + leftPointer + "\t rp: == " + rightPointer + "\t mid: == " + mid);

        while (leftPointer <= mid || rightPointer <= ub) {
            if (leftPointer <= mid && rightPointer <= ub) {
                if (nums[leftPointer] <= nums[rightPointer]) {
                    result[resultPointer++] = nums[leftPointer++];
                } else {
                    result[resultPointer++] = nums[rightPointer++];
                }
            } else if (leftPointer <= mid) {
                result[resultPointer++] = nums[leftPointer++];

            } else if (rightPointer <= ub) {
                result[resultPointer++] = nums[rightPointer++];
            }
        }

        for (int i = 0; i < resultPointer; i++) {
            nums[lb] = result[i];
            lb++;
        }

        printArray(nums);
    }

    static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
