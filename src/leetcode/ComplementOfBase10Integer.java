package leetcode;

public class ComplementOfBase10Integer {

    public static void main(String args[]) {
        // Input: 5
        // Output: 2
        // Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
        System.out.println("---------");
        System.out.println(bitwiseComplement(5));

        // Input: 10
        // Output: 5
        // Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
        System.out.println("---------");
        System.out.println(bitwiseComplement(10));

        // Input: 7
        // Output: 0
        // Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
        System.out.println("---------");
        System.out.println(bitwiseComplement(7));
    }

    static int bitwiseComplement(int N) {
        int factor = 1;
        int result = 0;
        while (N > 0) {
            int rem = N % 2;
            int compliment = rem == 1 ? 0 : 1;
            result += compliment * factor;
            factor *= 2;
            N = N / 2;
            System.out.println(rem + "\t" + compliment);
        }
        return result;
    }
}
