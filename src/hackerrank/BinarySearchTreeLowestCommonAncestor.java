package hackerrank;

public class BinarySearchTreeLowestCommonAncestor {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(5);
        right.left = rightLeft;
        right.right = rightRight;

        TreeNode rightRightLeft = new TreeNode(6);
        rightRight.left = rightRightLeft;

        System.out.println("Pre Order");
        preOrderPrint(root);

        System.out.println("\n\nIn Order");
        inOrderPrint(root);

        System.out.println("\n\nPost Order");
        postOrderPrint(root);

        System.out.println("\n\nLowest Common Ancestor");
        TreeNode lca = lca(root, 1, 7);
        System.out.println(lca.val);
    }

    static void preOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    static void inOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderPrint(root.left);
        System.out.print(root.val + "\t");
        preOrderPrint(root.right);
    }

    static void postOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderPrint(root.left);
        preOrderPrint(root.right);
        System.out.print(root.val + "\t");
    }

    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    private static TreeNode lca(TreeNode root, int v1, int v2) {
        // Write your code here.
        if (v1 < root.val && v2 < root.val) {
            return lca(root.left, v1, v2);
        }
        if (v1 > root.val && v2 > root.val) {
            return lca(root.right, v1, v2);
        }
        return root;
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
