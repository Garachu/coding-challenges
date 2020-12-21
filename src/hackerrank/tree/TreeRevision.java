package hackerrank.tree;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class TreeRevision {

    public static void main(String args[]) {
        TreeNode root = insert(null, 10);
        insert(root, 3);
        insert(root, 12);
        insert(root, 2);
        insert(root, 4);
        insert(root, 15);

        System.out.println("Pre Order Traversal");
        preOrderTraversal(root);

        System.out.println("\nIn Order Traversal");
        inOrderTraversal(root);

        System.out.println("\nPost Order Traversal");
        postOrderTraversal(root);

        System.out.println("\nLevel Order Traversal");
        levelOrderTraversal(root);

        System.out.println("\n Level Order Traversal: Array for Each Level");
        System.out.println(traverse(root));

        System.out.println("\n Height of Tree");
        System.out.println(heightOfTree(root));
    }

    static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "\t");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + "\t");
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + "\t");
    }

    static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + "\t");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    static int heightOfTree(TreeNode root){
        int rightHeight;
        int leftHeight;

        if(root == null) return -1;

        return Math.max(heightOfTree(root.left) + 1, heightOfTree(root.right) + 1);
    }

    static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> l = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = queue.poll();
                l.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

            list.add(l);
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
