package leetcode;

import java.util.Arrays;

public class MinimumCostForTickets {

    public static void main(String args[]) {

        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};

        int minCost = mincostTickets(days, costs);
        System.out.println("Min Cost: " + minCost);
    }

    private static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;   // 6
        int[] dp = new int[n + 1]; // [7]
        Arrays.fill(dp, 365 * costs[1]);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int c1 = costs[0] + dp[i + 1];
            int d7 = i;
            int d30 = i;

            while (d7 < n && days[d7] < days[i] + 7) d7++;
            while (d30 < n && days[d30] < days[i] + 30) d30++;

            int c2 = costs[1] + dp[d7];
            int c3 = costs[2] + dp[d30];

            dp[i] = Math.min(Math.min(c1, c2), c3);
        }
        return dp[0];
    }
}
