package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LongestIncreasingSubsequence {

    public static void main(String args[]) {

        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] sequence = lengthOfLIS(arr);
        System.out.println("\nSequence : \n");
        Arrays.stream(sequence).forEach(s -> System.out.print("\t" + s));
    }

    private static int[] lengthOfLIS(int[] nums) {
        // storing the length of the subsequence
        int[] length = new int[nums.length];
        Arrays.fill(length, 1);

        for (int i = 1; i < nums.length; i++) {
            int iElement = nums[i];

            for (int j = 0; j < i; j++) {
                int jElement = nums[j];
                if (jElement < iElement) {
                    int len = length[j] + 1;
                    if (len >= length[i]) {
                        length[i] = len;
                    }
                }
            }
        }

        System.out.println("Length:");
        Arrays.stream(length).forEach(l -> System.out.print("\t" + l));

        // Get Maximum length
        int max = Arrays.stream(length).max().getAsInt();
        System.out.println("\n\nMax: \t" + max);

        // Get the index of the max value
        int maxIndex = IntStream.range(0, length.length)
                .filter(i -> max == length[i])
                .findFirst()
                .orElse(-1);// return -1 if target is not found
        System.out.println("\nMax Index: \t" + maxIndex);

        // indexes
        List<Integer> ll = new ArrayList<>();

        System.out.println("\nLengthsss: \n");
        for (int i = maxIndex; i >= 0; i--) {
            System.out.print("\t " + length[i]);
        }

        int prev = 0;
        int pres = 0;
        System.out.println("\nLengthsss: \n");
        for (int i = maxIndex; i >= 0; i--) {
            if (i == maxIndex) {
                System.out.println("adding max: \t" + i);
                pres = length[i];
                ll.add(i);
            } else {
                pres = length[i];
                if ((prev - 1) == pres) {
                    System.out.println("adding: \t" + i);
                    ll.add(i);
                }
            }
            prev = pres;
        }

        System.out.println("\nSequence Indexes: \n");
        Collections.sort(ll);
        ll.stream().forEach(s -> System.out.print("\t" + s));

        int[] sequence = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            sequence[i] = nums[ll.get(i)];
        }

        return sequence;
    }
}
