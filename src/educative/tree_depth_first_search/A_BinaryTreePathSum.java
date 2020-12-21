package educative.tree_depth_first_search;

/**
 * Problem Statement #
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’
 * sum=10, 1
 */
public class A_BinaryTreePathSum {

    public static void main(String args[]) {

        // Example 1:
        // S: 10
        // Output: true
        // Explanation: The path with sum '10' is highlighted 1 -> 3 -> 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(hasPath(root, 10));
    }

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            System.out.println("root == null:  return false");
            return false;
        }

        System.out.println("root: " + root.val + " sum: " + sum);

        if (root.left == null && root.right == null && sum == root.val) {
            System.out.println("sum:  return true");
            return true;
        }

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
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
