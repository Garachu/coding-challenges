package practice;

import java.util.*;

public class GraphPractice {

    public static void main(String args[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.neighbours.add(node2);
        node1.neighbours.add(node4);

        node2.neighbours.add(node1);
        node2.neighbours.add(node3);

        node3.neighbours.add(node2);
        node3.neighbours.add(node4);
        node3.neighbours.add(node5);

        node4.neighbours.add(node1);
        node4.neighbours.add(node3);

//        dfsTraversal(node1, new HashSet<>());
        bfsTraversal(node1);
    }

    public static void dfsTraversal(Node node, HashSet<Node> set) {
        if (set.contains(node)) {
            return;
        } else {
            System.out.println("" + node.val + "\t");
        }
        set.add(node);
        for (Node n : node.neighbours) {
            dfsTraversal(n, set);
        }
    }

    public static void bfsTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        HashSet<Node> set = new HashSet<>();
        set.add(node);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println("Visit: " + poll.val + "\t");
            for (Node n : poll.neighbours) {
                if (!set.contains(n)) {
                    //System.out.println("neighbour: " + n.val);
                    queue.add(n);
                    set.add(n);
                }
            }
        }
    }

    static class Node {
        int val;
        List<Node> neighbours;

        public Node(int data) {
            this.val = data;
            neighbours = new ArrayList<>();
        }
    }
}


