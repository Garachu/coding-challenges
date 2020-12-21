package educative.tree_breadth_first_search;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class B_ReverseLevelOrderTraversal {

    public static void main(String args[]) {

        // Example 1:
        // Output: [[4, 5, 6, 7], [2, 3], [1]]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> nodes = traverse(root);
        System.out.println(nodes);

        // Example 2:
        // Output [[9, 10, 5], [12], [7, 1]]
        TreeNode root2 = new TreeNode(12);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(9);
        root2.right.left = new TreeNode(10);
        root2.right.right = new TreeNode(5);
        List<List<Integer>> nodes2 = traverse(root2);
        System.out.println(nodes2);
    }

    /**
     * Time complexity #
     * The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
     * This is due to the fact that we traverse each node once.
     * <p>
     * The space complexity of the above algorithm will be O(N) as we need to return a list containing the level order traversal.
     * We will also need O(N) space for the queue. Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
     * therefore we will need O(N) space to store them in the queue.
     */
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.value);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }


}
