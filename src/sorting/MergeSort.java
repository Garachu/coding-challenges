package sorting;

public class MergeSort {

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

    // Iteration sort(nums, 4, 5)  Iteration sort(nums, 6, 6)

    // sort(nums, 4, 6)

    // Iteration sort(nums, 3, 3)  return
    // Iteration sort(nums, 2, 2)  return

    // Iteration sort(nums, 2,? 3)

    // Iteration sort(nums, 1, 1)  return
    // Iteration sort(nums, 0, 0)  return


    // Iteration sort(nums, 0, 1)  sort(nums, 2, 3)
    // Iteration sort(nums, 0, 3)  sort(nums, 4, 6)

    private static void sortArray(int[] nums, int lb, int ub) {
        if (lb == ub) {
            return;
        }

        int mid = (lb + ub) / 2;
        sortArray(nums, lb, mid);
        sortArray(nums, mid + 1, ub);
        sortAndMergeArray(nums, lb, mid, ub);
    }

    static void sortAndMergeArray(int[] nums, int lb, int mid, int ub) {
        System.out.println("----------------------------");
        System.out.println(lb + "\t" + mid + "\t" + ub);
        int[] results = new int[ub - lb  + 1];
        int leftPointer = lb;
        int rightPointer = mid + 1;
        int resultPointer = 0;

        while (leftPointer <= mid || rightPointer <= ub){

            if(leftPointer <= mid && rightPointer <= ub){
                if(nums[leftPointer] < nums[rightPointer]){
                    results[resultPointer++] = nums[leftPointer++];
                }else {
                    results[resultPointer++] = nums[rightPointer++];
                }
            }else if(leftPointer <= mid){
                results[resultPointer++] = nums[leftPointer++];

            }else if(rightPointer <= ub){
                results[resultPointer++] = nums[rightPointer++];
            }

        }

        for(int i = 0; i < results.length; i++){
            nums[lb++] = results[i];
        }

    }

    static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
