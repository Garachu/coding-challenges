package practice;

import java.util.*;

public class GraphTraversal {

    public static void main(String args[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // add node1 neighbors
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        // add node2 neighbors
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        // add node3 neighbors
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        // add node4 neighbors
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        //bfsTraversal(node1);
        dfsTraversal(node1);
    }

    static void bfsTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Set set = new HashSet();
        set.add(node.val);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println("Poll: " + poll.val);

            for (Node neighbor : poll.neighbors) {
                if (!set.contains(neighbor.val)) {
                    System.out.println("Add Node: " + neighbor.val);
                    set.add(neighbor.val);
                    queue.add(neighbor);
                } else {
                    System.out.println("Node Exists: " + neighbor.val);
                }
            }
        }
    }

    static void dfsTraversal(Node node) {
        Set<Integer> set = new HashSet<>();
        dfsTraversal(node, set);
    }

    static void dfsTraversal(Node node, Set<Integer> set) {
        if (set.contains(node.val)) {
            System.out.println("Node Visited: " + node.val);
            return;
        } else {
            System.out.println("Visit Node: " + node.val);
        }
        set.add(node.val);
        for (Node neighbor : node.neighbors) {
            dfsTraversal(neighbor, set);
        }
    }

    static class Node {
        int val;
        List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
