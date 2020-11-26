package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings A and B of lowercase letters,
 * return true if you can swap two letters in A so the result is equal to B, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j].
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */
public class BuddyStrings {

    public static void main(String args[]) {
        System.out.println(buddyStrings("ab", "ba"));  // true
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));  // true
        System.out.println(buddyStrings("ab", "ab"));  // false
        System.out.println(buddyStrings("aa", "aa"));  // true
        System.out.println(buddyStrings("abcd", "badc"));  // false
        System.out.println(buddyStrings("abcaa", "abcbb"));  // false
    }

    static boolean buddyStrings(String A, String B) {
        if (A == null || A.length() == 0) return false;
        if (B.length() != A.length()) return false;
        int diff1 = -1;
        int diff2 = -1;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (diff1 == -1) {
                    diff1 = i;
                } else if (diff2 == -1) {
                    diff2 = i;
                } else {
                    return false;
                }
            }
            chars.add(A.charAt(i));
        }
        if (diff1 != -1 && diff2 != -1) {
            return A.charAt(diff1) == B.charAt(diff2) && A.charAt(diff2) == B.charAt(diff1);
        } else if (diff1 != -1) {
            return false;
        }
        return chars.size() < A.length();
    }


}
