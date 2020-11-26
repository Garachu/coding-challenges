package hackerrank;

/**
 * Amanda has a string of lowercase letters that she wants to copy to a new string. She can perform the following operations with the given costs.
 * She can perform them any number of times to construct a new string :
 * 1. Append a character to the end of string  p at a cost of 1 dollar.
 * 2. Choose any substring of p and append it to the end of p at no charge.
 * <p>
 * Complete the stringConstruction function in the editor below. It should return the minimum cost of copying a string.
 * stringConstruction has the following parameter(s):
 */
public class StringConstruction {

    public static void main(String[] args) {
        // Expected = 2
        String s1 = "abab";
        System.out.println(s1 + " == " + stringConstruction(s1));

        // Expected = 4
        String s2 = "abcd";
        System.out.println(s2 + " == " + stringConstruction(s2));
    }

    // Complete the stringConstruction function below.
    static int stringConstruction(String s) {
        if (s == null) return 0;
        int[] b = new int[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            int i = b[c - 'a'];
            if (i == 0) {
                b[c - 'a'] = 1;
                count++;
            }
        }
        return count;
    }
}
