package hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIsThisABinarySearchTree {

    public static void main(String args[]) {

        // example 1
//        Node root = insert(null, 1);
//        insert(root, 2);
//        insert(root, 5);
//        insert(root, 3);
//        insert(root, 6);
//        insert(root, 4);

        // example 2
        Node root = new Node(18);
        Node node1 = new Node(8);
        Node node2 = new Node(20);
        root.left = node1;
        root.right = node2;

        Node node3 = new Node(18);
        Node node4 = new Node(30);
        node2.left = node3;
        node2.right = node4;

        // levelOrderTraversal(root);

        boolean h = checkBST(root);
        System.out.println("\nBST: " + h);

        // inOrderTraversal(root);
    }

    static boolean checkBST(Node root) {
        return bst(root);
    }

    static Node previous = null;

    static boolean bst(Node root) {

        if (root != null) {

            System.out.println("root == " + root.data);

            if (!bst(root.left)) {
                System.out.println("check left: return false");
                return false;
            } else {
                System.out.println("check left: passes");
            }

            if (previous != null && root.data <= previous.data) {
                System.out.println("previous != null && root.data <= previous.data \t" + root.data + "\t" + previous.data);
                return false;
            }

            previous = root;
            if (previous != null) {
                System.out.println("\n---assign previous = " + previous.data);
            } else {
                System.out.println("\n---assign previous = null ");
            }

            if (!bst(root.right)) {
                System.out.println("check right: return false");
                return false;
            } else {
                System.out.println("check right: return true");
                return true;
            }
        } else {
            System.out.println("root == null");
        }

        System.out.println("end: return true");
        return true;
    }

    static void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll == null) {
                System.out.println("null");
            } else {
                System.out.println(poll.data);
            }
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
    }

    static void inOrderTraversal(Node root) {
        if (root == null) {
            System.out.println("root == null");
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
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
