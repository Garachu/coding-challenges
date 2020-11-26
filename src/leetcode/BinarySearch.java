package leetcode;

public class BinarySearch {

    public static void main(String args[]) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, -1));
        System.out.println(search(new int[]{2, 5}, 5));
    }

    static int search(int[] nums, int target) {
        if (nums == null) return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (target > nums[mid]) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else if (target < nums[mid]) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
