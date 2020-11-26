package hackerrank.tree;

public class TreeInorderTraversal {

    public static void main(String args[]) {
        Node root = insert(null, 1);
        insert(root, 2);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 4);

        inOrder(root);
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + "\t");
        inOrder(root.right);
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
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
