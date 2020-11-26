package leetcode;

public class InsertIntoBinarySearchTree {

    public static void main(String args[]) {
        System.out.println("----------");
        TreeNode root = insertIntoBST(null, 4);
        preOrderPrint(root);
        insertIntoBST(root, 2);
        insertIntoBST(root, 7);
        insertIntoBST(root, 1);
        insertIntoBST(root, 3);
        preOrderPrint(root);
    }

    static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            System.out.println("root == null");
            return node;
        } else {
            System.out.println("root != null");
        }
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            parent = current;
            if (val > current.val) {
                current = current.right;
            } else if (val < current.val) {
                current = current.left;
            }
        }

        if (val > parent.val) {
            System.out.println("insert right of : " + parent.val);
            parent.right = node;
        } else if (val < parent.val) {
            System.out.println("insert left of : " + parent.val);
            parent.left = node;
        }

        return root;
    }

    static void preOrderPrint(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}
