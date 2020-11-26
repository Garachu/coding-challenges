package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PathSumIII {

    private static int count = 0;
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(10);

        tree.left = new TreeNode(5);
        tree.right = new TreeNode(-3);

        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode((2));
        tree.right.right = new TreeNode(11);

        tree.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(-2);
        tree.left.right.right = new TreeNode((1));

        //preOrderRecursive(tree);

        int sum = 8;
        pathSum(tree, sum);
        System.out.println("Count: \t" + count);

    }

    // Time Complexity o(n)
    // Space Complexity o(n)
    static void preOrderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);
    }

    static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return count;

        list.add(root.val);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        System.out.println("Before: " + Arrays.toString(list.toArray()));
        int temp = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            temp += list.get(i);
            if (temp == sum) {
                count++;
            }
        }
        list.remove(list.size() - 1);
        System.out.println("After: " + Arrays.toString(list.toArray()));
        return count;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}


