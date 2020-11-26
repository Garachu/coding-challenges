package leetcode;

import java.util.Collections;

public class RepeatedSubstringPattern {

    public static void main(String args[]) {
//        String s1 = "abab";
//        System.out.println(s1 + "\t" + repeatedSubstringPattern(s1));
//        String s2 = "aba";
//        System.out.println(s2 + "\t" + repeatedSubstringPattern(s2));
        String s3 = "abcabcabcabc";
        System.out.println(s3 + "\t" + repeatedSubstringPattern(s3));
    }

    static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return false;
        int halfStrLen = s.length() / 2;
        System.out.println("Half Len: " + halfStrLen);
        for (int i = 0; i < halfStrLen; i++) {
            String subS = s.substring(0, (i + 1));
            System.out.println("Substring: " + subS);
            if ((s.length() % subS.length()) == 0) {
                int times = s.length() / subS.length();
                System.out.println("Possible: " + times);
                String join = String.join("", Collections.nCopies(times, subS));
                System.out.println("Join: " + join);
                if (join.equals(s)) return true;
            }
        }
        return false;
    }
}
