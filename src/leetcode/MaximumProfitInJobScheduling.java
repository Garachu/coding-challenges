package leetcode;

public class MaximumProfitInJobScheduling {

    public static void main(String args[]) {

        // Example 1
//        int[] startTime = new int[]{1, 2, 3, 3};
//        int[] endTime = new int[]{3, 4, 5, 6};
//        int[] profit = new int[]{50, 10, 40, 70};
//        System.out.println("------- " + jobScheduling(startTime, endTime, profit));

        // Example 2
        int[] startTime2 = new int[]{1, 2, 3, 4, 6};
        int[] endTime2 = new int[]{3, 5, 10, 6, 9};
        int[] profit2 = new int[]{20, 20, 100, 70, 60};
        System.out.println("------- " + jobScheduling(startTime2, endTime2, profit2));
    }

    static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int max = 0;

        for (int i = 0; i < len; i++) {

            System.out.println(" i == " + i);

            System.out.println("start == " + startTime[i] + "\t" + "end == " + endTime[i] + "\t" + "profit == " + profit[i]);

            int jStart;
            int jEnd;
            int jProfit;

            int jEndPrev2 = 0;
            int jProfitPrev2 = 0;

            int jEndPrev1 = endTime[i];
            int jProfitPrev1 = profit[i];

            for (int j = i + 1; j < len; j++) {

                System.out.println("\n j == " + j);

                jStart = startTime[j];
                jProfit = profit[j];
                jEnd = endTime[j];

                System.out.println("----- jStart == " + jStart + "\t" + "jEnd == " + jEnd + "\t" + "jProfit == " + jProfit);
                System.out.println("----- jEndPrev2 == " + jEndPrev2 + "\t" + "jProfitPrev2 == " + jProfitPrev2);
                System.out.println("----- jEndPrev1 == " + jEndPrev1 + "\t" + "jProfitPrev1 == " + jProfitPrev1);

                int p = 0;

                if (jStart <= jEndPrev1 && jStart <= jEndPrev2) {

                    System.out.println("----- jStart <= jEndPrev1 && jStart <= jEndPrev2 ");

                    p = Math.max((jProfit + jProfitPrev2), jProfitPrev1);

                    jEndPrev2 = jEndPrev1;
                    jProfitPrev2 = jProfitPrev1;

                    jProfitPrev1 = p;
                    jEndPrev1 = jEnd;

                } else if (jStart >= jEndPrev1) {

                    System.out.println("----- jStart >= jEndPrev1 ");

                    p = jProfitPrev1 + jProfit;

                    jEndPrev2 = jEndPrev1;
                    jProfitPrev2 = jProfitPrev1;

                    jProfitPrev1 = p;
                    jEndPrev1 = jEnd;

                } else {

                    System.out.println("----- else ");

                    jEndPrev2 = jEndPrev1;
                    jProfitPrev2 = jProfitPrev1;
                }

                max = Math.max(max, p);
            }

            System.out.println();
            System.out.println("Profit: " + max);
            System.out.println();

        }

        return max;

    }
}
