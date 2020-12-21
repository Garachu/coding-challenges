package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String args[]) {
        System.out.println(largestNumber2(new int[]{3, 30, 34, 5, 9}));  // expected "9534330"
        System.out.println(largestNumber2(new int[]{10, 2}));  // expected "210"
    }

    static String largestNumber(int[] nums) {
        List<String> numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String X, String Y) {
                        String XY = X + Y;
                        String YX = Y + X;
                        return XY.compareTo(YX) > 0 ? -1 : 1;
                    }

                    @Override
                    public boolean equals(Object obj) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
        String str = String.join("", numStrs);
        if (str.charAt(0) == '0') return "0";
        else return String.join("", numStrs);
    }

    static String largestNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }

        });

        String str = "";
        for (String s : strs) {
            str = str + s;
        }
        if (str.charAt(0) == '0') return "0";
        else return String.join("", str);
    }

}
