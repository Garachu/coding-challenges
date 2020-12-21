package educative.sliding_window;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
public class D_LongestSubstringWithKDistinctCharacters {

    public static void main(String args[]) {

        // Input: String="araaci", K=2
        // Output: 4
        // Explanation: The longest substring with no more than '2' distinct characters is "araa".
        System.out.println(findLength("araaci", 2));

        // Input: String="araaci", K=1
        // Output: 2
        // Explanation: The longest substring with no more than '1' distinct characters is "aa".
        System.out.println(findLength("araaci", 1));

        // Input: String="cbbebi", K=3
        // Output: 5
        // Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
        System.out.println(findLength("cbbebi", 3));
    }

    public static int findLength(String str, int k) {
        int[] char_counts = new int[128];
        char[] chars = str.toCharArray();
        int maxLen = 0;
        int dist = 0;
        int bPointer = 0;

        // "araaci"
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int count = char_counts[c];
            if (count == 0) {
                dist = dist + 1;
            }
            char_counts[c] = count + 1;
            if (dist > k) {
                maxLen = Math.max(maxLen, (i - bPointer));
                while (dist >= k) {
                    char bElement = chars[bPointer];
                    int bElementCount = char_counts[bElement];
                    if (bElementCount > 1) {
                        char_counts[bElement] = bElementCount - 1;
                    } else if (bElementCount == 1) {
                        char_counts[bElement] = 0;
                        dist--;
                    }
                    bPointer++;
                }
            }
        }

        return maxLen;
    }
}
