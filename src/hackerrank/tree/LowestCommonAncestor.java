package hackerrank.tree;

public class LowestCommonAncestor {

    public static void main(String args[]) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);

        // we expect it to be 3. but it's giving 5. this is not a binary tree.
        // System.out.println(lca(root, 4, 6).val);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(6);

        // Expected Output = 4. this works as it is a perfect binary tree
        System.out.println(lca(root2, 1, 3).val);
    }

    private static TreeNode lca(TreeNode root, int v1, int v2) {
        // Write your code here.
        if (v1 < root.val && v2 < root.val) {
            System.out.println("v1 < root.val && v2 < root.val");
            return lca(root.left, v1, v2);
        } else if (v1 > root.val && v2 > root.val) {
            System.out.println("v1 > root.val && v2 > root.val");
            return lca(root.right, v1, v2);
        } else {
            System.out.println("return root");
            return root;
        }
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
