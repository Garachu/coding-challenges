package hackerrank.stacksandqueues;

import java.util.*;

public class BalancedBrackets {

    public static void main(String args[]) {
        System.out.println("Expected: YES  + \t Actual: " + isBalanced("{[()]}"));
        System.out.println("Expected: NO  + \t Actual: " + isBalanced("{[(])}"));
        System.out.println("Expected: YES  + \t Actual: " + isBalanced("{{[[(())]]}}"));
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();

        for (char bracket : brackets) {
            if (bracket == '{') {
                stack.push('}');
            } else if (bracket == '(') {
                stack.push(')');
            } else if (bracket == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != bracket) {
                    return "NO";
                }
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
