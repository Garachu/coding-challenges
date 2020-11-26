package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrogJump {

    public static void main(String args[]) {
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    static boolean canCross(int[] stones) {
        Map<Integer, HashSet<Integer>> myMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (i == 0) {
                myMap.put(stones[0], new HashSet<>(Arrays.asList(0)));
            } else {
                myMap.put(stones[i], new HashSet<>());
            }
        }
        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];
            if (i == 0) {
                int steps = 1;
                int nextStep = currentStone + steps;
                if (myMap.containsKey(nextStep)) {
                    myMap.get(nextStep).add(steps);
                }
            } else {
                HashSet<Integer> prevSteps = myMap.get(currentStone);
                if (prevSteps.isEmpty()) {
                    continue;
                }
                prevSteps.forEach(prevStep -> {
                    // k-1
                    int kMinus1Steps = prevStep - 1;
                    if (kMinus1Steps > 0) {
                        int nextStep = currentStone + kMinus1Steps;
                        insertToMap(nextStep, kMinus1Steps, myMap);
                    }

                    // k
                    int kSteps = prevStep;
                    if (kSteps > 0) {
                        int nextStep = currentStone + kSteps;
                        insertToMap(nextStep, kSteps, myMap);
                    }

                    // k+1
                    int kPlus1Steps = prevStep + 1;
                    if (kPlus1Steps > 0) {
                        int nextStep = currentStone + kPlus1Steps;
                        insertToMap(nextStep, kPlus1Steps, myMap);
                    }
                });
            }
        }
        int lastStone = stones[stones.length - 1];
        return !myMap.get(lastStone).isEmpty();
    }

    static void insertToMap(int key, int steps, Map<Integer, HashSet<Integer>> myMap) {
        if (myMap.containsKey(key)) {
            myMap.get(key).add(steps);
        }
    }


}
