package educative.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 */
public class E_NoRepeatSubstring {

    public static void main(String args[]) {
        // Input: String="aabccbb"
        // Output: 3
        // Explanation: The longest substring without any repeating characters is "abc".
        String str1 = "abccde";
        System.out.println(findLength(str1));

        // Input: String="abbbb"
        // Output: 2
        // Explanation: The longest substring without any repeating characters is "ab".
        String str2 = "abbbb";
        System.out.println(findLength(str2));

        // Input: String="abccde"
        // Output: 3
        // Explanation: Longest substrings without any repeating characters are "abc" & "cde".
        String str3 = "abccde";
        System.out.println(findLength(str3));
    }

    public static int findLength(String str) {
        int maxLength = 0;
        int aPointer = 0;

        char[] chars = str.toCharArray();

        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (seen.contains(c)) {
                maxLength = Math.max(maxLength, seen.size());
                while (seen.contains(c)) {
                    seen.remove(chars[aPointer]);
                    aPointer++;
                }
            } else {
                seen.add(c);
            }
        }
        return maxLength;
    }

}
