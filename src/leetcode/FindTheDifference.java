package leetcode;

public class FindTheDifference {

    public static void main(String args[]) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    private static char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        res ^= t.charAt(s.length());
        return (char) res;
    }
}
