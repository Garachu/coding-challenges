package hackerrank.tree;

public class TreeSize {

    public static void main(String args[]) {

        // example 1
//        Node root = insert(null, 1);
//        insert(root, 2);
//        insert(root, 5);
//        insert(root, 3);
//        insert(root, 6);
//        insert(root, 4);

        // example 2
//        Node root = insert(null, 3);
//        insert(root, 2);
//        insert(root, 5);
//        insert(root, 1);
//        insert(root, 4);
//        insert(root, 6);
//        insert(root, 7);

//        arr = new int[size(root)];
//        inOrder(root);
//        printArr();
//        System.out.println(checkBst());

        Node root = new Node(18);
        Node node1 = new Node(8);
        Node node2 = new Node(20);
        root.left = node1;
        root.right = node2;

        Node node3 = new Node(18);
        Node node4 = new Node(30);
        node2.left = node3;
        node2.right = node4;

        System.out.println(checkBst2(root));
    }

    static int[] arr;
    static int len = 0;

    static int size(Node root) {
        if (root == null) return 0;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1;
    }

    static void printArr() {
        for (int b : arr) {
            System.out.print(b + "\t");
        }
    }

    static boolean checkBst() {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static Node previous = null;

    static boolean checkBst2(Node root) {
        if (root != null) {
            if(!checkBst2(root.left)){
                return false;
            }
            if (previous != null && root.data <= previous.data) {
                return false;
            }
            previous = root;
            return checkBst2(root.right);
        }
        return true;
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        arr[len] = root.data;
        len++;
        inOrder(root.right);
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
