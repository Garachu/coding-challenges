package educative.tree_depth_first_search;

/**
 * Problem Statement #
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 */
public class D_PathWithGivenSequence {

    public static void main(String args[]) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(9);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(9);

        System.out.println("Tree has path sequence: " + findPath(root1, new int[]{1, 7}));

        // Sequence: [1, 9, 9]
        // Output: true
        // Explanation: The tree has a path 1 -> 9 -> 9.
        System.out.println("Tree has path sequence: " + findPath(root1, new int[]{1, 9, 9}));
    }

    /**
     * Solution #
     * This problem follows the Binary Tree Path Sum pattern.
     * We can follow the same DFS approach and additionally, track the element of the given sequence that we should match with the current node.
     * Also, we can return false as soon as we find a mismatch between the sequence and the node value.
     */
    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPathRecursive(root, sequence, 0);
    }

    /**
     * Time complexity #
     * The time complexity of this algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
     * This is due to the fact that we traverse each node once.
     * <p>
     * Time complexity #
     * The time complexity of the the algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
     * This is due to the fact that we traverse each node once.
     */
    public static boolean findPathRecursive(TreeNode root, int[] sequence, int sequenceIndex) {

        if (root == null) {
            return false;
        }

        if (root.left == null
                && root.right == null
                && root.val == sequence[sequenceIndex]
                && sequenceIndex == sequence.length - 1) {
            return true;
        }

        if (sequenceIndex >= sequence.length || root.val != sequence[sequenceIndex]) {
            return false;
        }

        return findPathRecursive(root.left, sequence, sequenceIndex + 1) ||
                findPathRecursive(root.right, sequence, sequenceIndex + 1);

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
