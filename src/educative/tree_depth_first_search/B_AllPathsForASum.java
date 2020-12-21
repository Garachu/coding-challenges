package educative.tree_depth_first_search;

import java.util.List;
import java.util.ArrayList;

/**
 * Problem Statement #
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
public class B_AllPathsForASum {

    public static void main(String args[]) {

        // Example 1:
        // S: 12
        // Output: 2
        // Explanation: There are the two paths with sum '12':1 -> 7 -> 4 and 1 -> 9 -> 2
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(7);
        System.out.println(findPaths(root1, 12));

        // Example 2:
        // S: 23
        // Output: 2
        // Explanation: Here are the two paths with sum '23':12 -> 7 -> 4 and 12 -> 1 -> 10
        TreeNode root2 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(7);
        System.out.println(findPaths(root2, 12));
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        findPathsRecursive(root, sum, allPaths, new ArrayList<>());
        return allPaths;
    }

    public static void findPathsRecursive(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> currentPath) {

        if (root == null) {
            return;
        }

        // add the current node to the path
        currentPath.add(root.val);

        // if the current node is a leaf and its value is equal to sum, save the current pat
        if (root.left == null && root.right == null && root.val == sum) {
            allPaths.add(new ArrayList(currentPath));
        }

        // traverse the left sub-tree
        findPathsRecursive(root.left, sum - root.val, allPaths, currentPath);
        // traverse the right sub-tree
        findPathsRecursive(root.right, sum - root.val, allPaths, currentPath);

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
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
