package leetcode;


/**
 *
 * index    0  1  2  3  4
 * value    2, 7, 9, 3, 1
 *
 * for i = 0    a[0] = 2
 * prev1 = 0, prev2 = 0
 * tmp = prev1
 * max(prev2 + num, prev1)  max(0+2, 2)   prev1 = 2 prev2 = 0
 *
 *
 * for i = 1    a[1] = 7
 * store prev1 in tmp tmp = prev1
 * prev1 = max(prev2 + num, prev1)  max(0+7, 2)  prev1 = 7  prev2 = 2
 *
 * for i = 2    a[2] = 9
 * tmp = prev1 tmp = 7
 * prev1 = max(prev2 + num, prev1)   prev1 = max(2+9, 7)   prev1 = 11 prev2 = 7
 *
 * for i = 3 a[3] = 1
 * tmp = prev1 tmp = 11
 * prev1 = max(prev2 + num, prev1)  prev1(7+3, 11)  prev1 = 11 prev2 = 11
 *
 *
 * for i = 4 a[4] = 4
 * tmp = prev1 tmp = 11
 * prev1 = max(prev2 + num, prev1) prev1(11 + 1, prev2)   prev1 = 12
 *
 */
public class HouseRobber1 {

    public static void main(String args[]) {
        int nums[] = {2, 7, 9, 3, 1};
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        System.out.println("Prev 1: \t" + prev1);
    }

}
