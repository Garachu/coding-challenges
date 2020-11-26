package leetcode;

public class LongestPalindromicSubstring {

    static int resultLength;
    static int resultStart;

    public static void main(String args[]) {
        String str1 = "babad";
        System.out.println("Longest Palindromic substring: " + longestPalindrome(str1));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len; i++) {
            System.out.println(s.charAt(i));
            range(s, i, i);
            range(s, i, i + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void range(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        start = start + 1;
        int len = end - start;
        if (resultLength < len) {
            resultLength = len;
            resultStart = start;
        }

    }
}
