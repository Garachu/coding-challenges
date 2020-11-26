package hackerrank.tree;

public class TreePreorderTraversal {

    public static void main(String args[]) {
        Node root = insert(null, 1);
        insert(root, 2);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 4);

        preOrderTraversal(root);
    }

    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + "\t");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
