package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CarPooling {

    public static void main(String args[]) {

        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Expected: " + false + "\tActual: " + carPoolingUsingArray(trips1, 4));

        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        System.out.println("Expected: " + true + "\tActual: " + carPoolingUsingArray(trips2, 5));

        int[][] trips3 = {{2, 1, 5}, {3, 5, 7}};
        System.out.println("Expected: " + true + "\tActual: " + carPoolingUsingArray(trips3, 3));

        int[][] trips4 = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        System.out.println("Expected: " + true + "\tActual: " + carPoolingUsingArray(trips4, 11));

//        int[][] trips5 = {{3, 2, 8}, {4, 4, 6}, {10, 8, 9}};
//        System.out.println("Expected: " + false + "\tActual: " + carPoolingUsingArray(trips5, 11));

        int[][] trips6 = {{7, 5, 6}, {6, 7, 8}, {10, 1, 6}};
        System.out.println("Expected: " + false + "\tActual: " + carPoolingUsingArray(trips6, 16));
    }

    /**
     * failing for some test cases
     */
    static boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> stageDropOffs = new HashMap<>();
        int totalNumberOfPassengers = 0;
        for (int[] trip : trips) {
            int numberOfPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];
            // we check if we're dropping off at this location
            Integer drops = stageDropOffs.getOrDefault(startLocation, 0);
            // drop off
            totalNumberOfPassengers -= drops;
            // on board
            totalNumberOfPassengers += numberOfPassengers;
            // check capacity
            if (totalNumberOfPassengers > capacity) {
                return false;
            } else {
                stageDropOffs.merge(endLocation, numberOfPassengers, Integer::sum);
            }
        }
        return true;
    }

    /**
     * failing for some test cases
     */
    static boolean carPooling2(int[][] trips, int capacity) {
        Map<Integer, Integer> stageDropOffs = new HashMap<>();
        int totalNumberOfPassengers = 0;
        for (int[] trip : trips) {
            int numberOfPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];
            List<Map.Entry<Integer, Integer>> collect = stageDropOffs.entrySet().stream().filter(entry -> entry.getKey() <= startLocation).collect(Collectors.toList());
            for (Map.Entry<Integer, Integer> st : collect) {
                System.out.println();
                // drop off
                totalNumberOfPassengers -= st.getValue();
                // update hashmap that there no more drop offs at the location
                stageDropOffs.remove(st.getKey());
            }
            // on board
            totalNumberOfPassengers += numberOfPassengers;
            // check capacity
            if (totalNumberOfPassengers > capacity) {
                return false;
            } else {
                stageDropOffs.merge(endLocation, numberOfPassengers, Integer::sum);
            }
        }
        return true;
    }

    /**
     * working for all test cases
     */
    static boolean carPooling3(int[][] trips, int capacity) {
        Map<Integer, Integer> ourMap = new TreeMap<>();
        for (int[] trip : trips) {
            int numberOfPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];
            ourMap.put(startLocation, ourMap.getOrDefault(startLocation, 0) + numberOfPassengers);
            ourMap.put(endLocation, ourMap.getOrDefault(endLocation, 0) - numberOfPassengers);
        }
        int totalNumberOfPassengers = 0;
        for (Map.Entry<Integer, Integer> entry : ourMap.entrySet()) {
            totalNumberOfPassengers += entry.getValue();
            if (totalNumberOfPassengers > capacity) return false;
        }
        return true;
    }

    /**
     * working for all test cases
     * Best performing
     */
    static boolean carPoolingUsingArray(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        int max = 0;
        for (int[] trip : trips) {
            int numberOfPassengers = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];
            arr[startLocation] += numberOfPassengers;
            arr[endLocation] -= numberOfPassengers;
            max = Math.max(max, endLocation);
        }
        int total = 0;
        for (int i = 0; i < max; i++) {
            total += arr[i];
            if (total > capacity) {
                return false;
            }
        }
        return true;
    }
}
