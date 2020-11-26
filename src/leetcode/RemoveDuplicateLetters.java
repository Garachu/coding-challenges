package leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public static void main(String args[]) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));  // acdb
    }

    static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)] = i;
        }
        boolean[] seen = new boolean['z' + 1];
        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c]) continue;
            while (!chars.isEmpty() && chars.peek() > c && lastIndex[chars.peek()] > i) {
                seen[chars.pop()] = false;
            }
            chars.push(c);
            seen[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) sb.append(chars.pop());
        return sb.reverse().toString();
    }
}
