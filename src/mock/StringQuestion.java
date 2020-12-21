package mock;

import java.util.*;

public class StringQuestion {

    public static void main(String args[]) {
        // System.out.println(useMap("Umbrella"));

        // System.out.println(rFactorial(4));

        System.out.println(arr(new int[]{1, 2, 3}, new int[]{4, 1, 9}));
        System.out.println(arr(new int[]{1, 2, 1}, new int[]{4, 4, 1}));

        // 1 2  5 2 8 1 5   2  10

    }

    static void maxSubArray(int[] nums, int n){
        int aPointer = 0;
        int bPointer = 0;

        int maxSum = -99999999;
        int sum = 0;
        int count = 0;

        while(bPointer < nums.length){
            sum = sum + nums[bPointer];
            count = count + 1;

            if(count == n){
                maxSum = Math.max(sum, maxSum);
            }


        }

    }

    static boolean arr(int[] num1, int[] num2){

        if(num1.length != num2.length) return false;

        Arrays.sort(num1);
        Arrays.sort(num2);

        for(int i = 0; i < num1.length; i++){
            if(num2[i] != (num1[i] * num1[i])){
                return false;
            }
        }

        return true;
    }

    static int factorial(int num){
        int product = 1;
        while(num >= 1){
            product = product * num--;
        }
        return product;
    }

    static int rFactorial(int num){
        if(num == 1){
            return 1;
        }
        return num * rFactorial(--num);
    }

    static char useMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] letters = s.toCharArray();

        int max = 0;
        char ch = ' ';

        for (char l : letters) {
            if (map.containsKey(l)) {
                Integer n = map.get(l);
                n = n + 1;
                if (n > max) {
                    ch = l;
                }
                max = Math.max(max, n);
                map.put(l, n);
            } else {
                if (1 > max) {
                    ch = l;
                }
                max = Math.max(max, 1);
                map.put(l, 1);
            }
        }

        return ch;

    }
}
