package hackerrank.tree;

import java.util.Stack;

public class Tree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(12);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right.right = new TreeNode(15);

//        preOrderRecursive(tree);
//        preOrderIterative(tree);

//        insertIntoBSTIterative(tree, 17);
//        preOrderRecursive(tree);

        System.out.println("Left Height: \t" + height(tree));
        //System.out.println("Right Height: \t" + height(tree.right));

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

    // Time Complexity o(n)
    // Space Complexity o(n)
    static void preOrderIterative(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || node != null) {
            if (node != null) {
                System.out.println("Node -> Iterative: " + node.val);
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    static TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            // search right
            else if (root.val < val) {
                root = root.right;
            }
            // search left
            else if (root.val > val) {
                root = root.left;
            }
        }
        return null;
    }

    static TreeNode searchBSTRecursive(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        // search right
        else if (root.val < val) {
            return searchBSTIterative(root.right, val);
        }
        // search left
        else {
            return searchBSTIterative(root.left, val);
        }
    }

    static TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val < val) {
            root.right = insertIntoBSTRecursive(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBSTRecursive(root.left, val);
        }
        return root;
    }

    static TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode p = null;
        TreeNode q = root;

        while (q != null) {
            p = q;
            // go right
            if (val > q.val) {
                q = q.right;
            }
            // go left
            else if (val < q.val) {
                q = q.left;
            }
        }

        // insert right
        if (p.val < val) {
            p.right = new TreeNode(val);
        }
        // go left
        else {
            p.left = new TreeNode(val);
        }
        return root;
    }

    static int height(TreeNode root){
        int leftHeight = 0;
        int rightHeight = 0;

        System.out.println("Left \t" + leftHeight);
        System.out.println("Right \t" + rightHeight);

        if(root == null){
            return -1;
        }else {
            leftHeight = height(root.left);
            rightHeight = height(root.right);
        }
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
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

