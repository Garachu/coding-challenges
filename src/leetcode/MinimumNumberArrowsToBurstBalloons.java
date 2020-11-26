package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsToBurstBalloons {

    public static void main(String args[]) {
        int minArrowShots1 = findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        System.out.println(minArrowShots1);

        int minArrowShots2 = findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}});
        System.out.println(minArrowShots2);
    }

    static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points, Comparator.comparingInt(n -> n[0]));
        printArray(points);
        int minRight = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] <= minRight) {
                minRight = Math.min(minRight, point[1]);
                continue;
            } else {
                minRight = point[1];
                count++;
            }
        }
        return count;
    }

    static void printArray(int[][] points) {
        System.out.println("\n{");
        for (int i = 0; i < points.length; i++) {
            System.out.print("\t[" + points[i][0] + "," + points[i][1] + "]" + " ,");
        }
        System.out.println("}");
    }
}
