package hackerrank;

import java.util.*;

public class SimpleTextEditor {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String operations = s.nextLine();
        int ops = Integer.parseInt(operations);

        Stack<String> stack = new Stack();
        int operation;
        String str = "";
        for (int i = 0; i < ops; i++) {
            operation = s.nextInt();
            switch (operation) {
                // Append: Append W to the end of String
                case 1:
                    str = str + s.next();
                    stack.push(str);
                    break;

                // Delete: Delete last k characters of S
                case 2:
                    int k = s.nextInt();
                    int endIndex = str.length() - k;
                    System.out.println("end index: " + endIndex);
                    str = str.substring(0, endIndex);
                    stack.push(str);
                    break;

                // Print: Print kth character of S
                case 3:
                    k = s.nextInt();
                    System.out.println(str.charAt(k - 1));
                    break;

                // Undo: undo the last operations of type 1 or 2
                case 4:
                    stack.pop();
                    str = stack.peek();
                    break;
            }
        }
    }
}
