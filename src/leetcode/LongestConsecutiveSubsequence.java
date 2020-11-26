package leetcode;

import java.util.*;

public class LongestConsecutiveSubsequence {

    public static void main(String args[]) {
        //int[] arr = {100, 4, 200, 1, 3, 2, 2};
        //int[] arr = {100};
        //int[] arr = {0, 0};
        int[] arr = {0,-1};
        int longest = maxConsecutive2(arr);
        System.out.println("Longest Longest: " + longest);
    }

    private static int maxConsecutive1(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<Integer> arrSet = new HashSet<>(Arrays.asList(arr));
        int longest = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer num : arrSet) {
            if (!arrSet.contains(num - 1)) {
                int next = num + 1;
                int count = 1;
                List<Integer> curr = new ArrayList<>();
                curr.add(num);
                while (arrSet.contains(next)) { //
                    curr.add(next);
                    next++;
                    count++;
                }
                if (count > longest) {
                    list = curr;
                    longest = count;
                }
            }
        }
        System.out.println("Longest: " + longest);
        System.out.println(list);
        return longest;
    }

    private static int maxConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int longest = 1;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int prev = nums[i - 1];
            if ((current - 1) == prev) {
                if (counter == 1) {
                    list.add(prev);
                }
                list.add(current);
                counter++;
            } else if (current != prev) {
                counter = 1;
            }
            longest = Math.max(counter, longest);
        }
        System.out.println("Sorted ARray: " + Arrays.toString(nums));
        System.out.println("Longest: " + longest);
        System.out.println(list);
        return longest;
    }

}
