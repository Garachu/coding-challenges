package educative.tree_depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 */
public class C_SumOfPathNumbers {

    public static void main(String args[]) {

        // Example 1:
        // Output: 408
        // Explanation: The sum of all path numbers: 17 + 192 + 199
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(9);
        System.out.println(findSumOfPathNumbers(root1));

        // Example 2:
        // Output: 332
        // Explanation: The sum of all path numbers: 101 + 116 + 115
    }

    public static int findSumOfPathNumbers(TreeNode root) {
        List<StringBuilder> list = new ArrayList<>();
        findSumOfPathNumbers(root, new StringBuilder(), list);

        int sum = 0;

        for (StringBuilder str : list) {
            sum += Integer.valueOf(str.toString());
        }

        return sum;
    }

    public static void findSumOfPathNumbers(TreeNode root, StringBuilder str, List<StringBuilder> list) {

        if (root == null) {
            return;
        }

        str.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(new StringBuilder(str));
        }

        findSumOfPathNumbers(root.left, str, list);
        findSumOfPathNumbers(root.right, str, list);

        str.deleteCharAt(str.length() - 1);
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
