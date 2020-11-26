package leetcode;

public class BestTimeToBuyAndSellStock {

    public static void main(String args[]) {
        System.out.println("Expected: 5: \t Actual: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Expected: 0: \t Actual: " + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minBuyingPrice = prices[0];
        int[] profits = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            profits[i] = Math.max((prices[i] - minBuyingPrice), profits[i - 1]);
            minBuyingPrice = Math.min(minBuyingPrice, prices[i]);
        }
        int profit = profits[0];
        for (int i = 1; i < profits.length; i++) {
            profit = Math.max(profit, profits[i]);
        }
        return profit;
    }
}
