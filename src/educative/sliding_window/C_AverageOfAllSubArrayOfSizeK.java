package educative.sliding_window;

public class C_AverageOfAllSubArrayOfSizeK {

    public static void main(String args[]) {
        int[] arr = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        double[] averages = findAverages(k, arr);

        for (int i = 0; i < averages.length; i++) {
            System.out.println(averages[i]);
        }
    }

    /**
     * Sliding Window approach:
     */
    public static double[] findAverages(int k, int[] arr) {
        double sum = 0;
        int count = 0;
        double[] result = new double[arr.length - k + 1];
        int n = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            count = count + 1;

            if (count == k) {
                result[n] = sum / k;
                n++;
                count--;
                sum = sum - arr[i - k + 1];
            }
        }

        return result;
    }
}
