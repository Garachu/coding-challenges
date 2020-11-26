package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String args[]) {
        int[] candidates = new int[]{2, 3, 6, 7};
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, 7, 7, arr, result);
        result.forEach(r -> {
            System.out.println("Result: " + r);
        });
    }

    static void backtrack(int[] candidates, int start, int target, int res, List<Integer> arr, List<List<Integer>> result) {
        System.out.println(arr);
        if (res < 0) {
            System.out.println("res < 0 \t" + res);
            return;
        } else if (res == 0) {
            System.out.println("res == 0 \t" + res);
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            System.out.println(String.format("i == %d \t cand == %d \t res == %d", i, candidates[i], res));
            arr.add(candidates[i]);
            System.out.println(res + " - " + candidates[i]);
            backtrack(candidates, i, target, res - candidates[i], arr, result);
            System.out.println("Remove: " + arr.get(arr.size() -1));
            arr.remove(arr.size() -1);
            System.out.println(arr);
        }
    }
}
