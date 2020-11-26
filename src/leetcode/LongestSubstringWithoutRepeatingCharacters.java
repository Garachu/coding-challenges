package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]){
        String s = "abcabcbb";
        System.out.println("Longest: " + lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int aPointer = 0;
        int bPointer = 0;
        Set<Character> chars = new HashSet<>();
        while (bPointer < s.length()){
            if(!chars.contains(s.charAt(bPointer))){
                chars.add(s.charAt(bPointer));
                bPointer ++;
                longest = Math.max(longest, chars.size());
            }else {
                chars.remove(s.charAt(aPointer));
                aPointer++;
            }
        }
        return longest;
    }
}
