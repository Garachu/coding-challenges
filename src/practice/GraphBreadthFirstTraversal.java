package practice;

import java.util.LinkedList;

public class GraphBreadthFirstTraversal {

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    }

    static class Graph {
        int vertices;
        LinkedList<Integer> adjacent[];

        Graph(int vertices) {
            this.vertices = vertices;
            adjacent = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacent[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adjacent[v].add(w);
        }
    }
}
