package hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTraversal {

    public static void main(String args[]) {
        Node root = insert(null, 1);
        insert(root, 2);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 4);


        levelOrderTraversal(root);
    }

    static void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.data + "\t");
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
    }

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        Node p = null;
        Node c = root;

        while (c != null) {
            // go right
            if (val > c.data) {
                p = c;
                c = c.right;
            }
            // go left
            else {
                p = c;
                c = c.left;
            }
        }

        Node node = new Node(val);

        // go right
        if (val > p.data) {
            p.right = node;
        }
        // go left
        else {
            p.left = node;
        }

        return node;
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
