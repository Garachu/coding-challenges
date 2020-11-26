package leetcode;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
public class CloneGraph {

    public static void main(String args[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // add node1 neighbours
        node1.neighbours.add(node2);
        node1.neighbours.add(node4);

        // add node2 neighbours
        node2.neighbours.add(node1);
        node2.neighbours.add(node3);

        // add node3 neighbours
        node3.neighbours.add(node2);
        node3.neighbours.add(node4);

        // add node4 neighbours
        node4.neighbours.add(node1);
        node4.neighbours.add(node3);

        cloneGraph(node1);
    }

    static void cloneGraph(Node node) {
        if (node == null) return;
        Map<Integer, Node> map = new HashMap<>();
        cloneGraph(node, map);
    }

    static Node cloneGraph(Node node, Map<Integer, Node> map) {
        System.out.println("Node: " + node.val + "\t");
        if (map.containsKey(node.val)) {
            System.out.println("--- Node already visited");
            return map.get(node.val);
        } else {
            System.out.println("--- Node not yet visited");
        }
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node neighbour : node.neighbours) {
            copy.neighbours.add(cloneGraph(neighbour, map));
        }
        return copy;
    }

    static class Node {
        int val;
        List<Node> neighbours;

        public Node() {
            this.val = 0;
            this.neighbours = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbours = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbours) {
            this.val = val;
            this.neighbours = neighbours;
        }
    }

}
