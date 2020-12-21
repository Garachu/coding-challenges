package hackerrank.tree;

public class IsBST {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(30);

        System.out.println(isBST(root));
    }

    static TreeNode previous = null;

    public static boolean isBST(TreeNode root) {
        if (root != null) {
            if (!isBST(root.left)) {
                return false;
            }
            if (previous != null && previous.val >= root.val) {
                return false;
            }
            previous = root;
            if (!isBST(root.right)) {
                return false;
            }
        }
        return true;
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
