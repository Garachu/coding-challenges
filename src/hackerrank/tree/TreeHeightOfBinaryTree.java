package hackerrank.tree;

public class TreeHeightOfBinaryTree {

    public static void main(String args[]) {

        // example 1
//        Node root = insert(null, 1);
//        insert(root, 2);
//        insert(root, 5);
//        insert(root, 3);
//        insert(root, 6);
//        insert(root, 4);

        // example 2
        Node root = insert(null, 3);
        insert(root, 2);
        insert(root, 5);
        insert(root, 1);
        insert(root, 4);
        insert(root, 6);
        insert(root, 7);

        int h = height(root);
        System.out.println("Height: " + h);
    }

    static int height(Node root) {
        if (root == null) return -1;

        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            System.out.println("b left: " + root.left.data + "  : " + leftHeight);
            leftHeight = 1 + height(root.left);
            System.out.println("a left: " + root.left.data + "  : " + leftHeight);
        }
        if (root.right != null) {
            System.out.println("b right: " + root.right.data + "  : " + rightHeight);
            rightHeight = 1 + height(root.right);
            System.out.println("a right: " + root.right.data + "  : " + rightHeight);
        }

        int max = Math.max(leftHeight, rightHeight);
        System.out.println("Return: " + max);
        return max;
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else if (data < root.data) {
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
