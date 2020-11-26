package leetcode;

public class TeemoAttacking {

    /**
     * 4 - 1
     *
     * @param args
     */

    public static void main(String args[]) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));  // 4
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));  // 3
    }

    static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        if (timeSeries.length == 1) {
            return duration;
        }

        int poisonedDuration = 0;
        for (int i = 1; i < timeSeries.length; i++) {

            int diff = timeSeries[i] - timeSeries[i - 1];
            if (diff <= duration) {
                poisonedDuration += diff;
            } else {
                poisonedDuration += duration;
            }
            if (i == timeSeries.length - 1) {
                poisonedDuration += duration;
            }
        }
        return poisonedDuration;
    }
}
