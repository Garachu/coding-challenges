package educative.topologicalsort;

import java.util.*;

/**
 * Problem Statement #
 * Topological Sort of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
 * Given a directed graph, find the topological ordering of its vertices.
 */
public class A_TopologicalSort {

    public static void main(String args[]) {

        // Example 1:
        // Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
        // Output: Following are the two valid topological sorts for the given graph:
        // 1) 3, 2, 0, 1
        // 2) 3, 2, 1, 0
        List<Integer> sortedList = sort(4, new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}});
        System.out.println(sortedList);

        // Example 2:
        // Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
        // Output: Following are all valid topological sorts for the given graph:
    }

    /**
     * Solution
     * The basic idea behind the topological sort is to provide a partial ordering among the vertices of the graph such that if there is an edge from U to V then U≤V i.e., U comes before V in the ordering.
     * Here are a few fundamental concepts related to topological sort:
     * <p>
     * Time Complexity #
     * In step ‘d’, each vertex will become a source only once and each edge will be accessed and removed once.
     * Therefore, the time complexity of the above algorithm will be O(V+E), where ‘V’ is the total number of vertices and ‘E’ is the total number of edges in the graph.
     * <p>
     * Space Complexity #
     * The space complexity will be O(V+E), since we are storing all of the edges for each vertex in an adjacency list.
     */
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();

        // a. Initialize the graph
        HashMap<Integer, Integer> vertexIndegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            vertexIndegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // b. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            graph.get(parent).add(child);
            vertexIndegree.put(child, vertexIndegree.get(child) + 1);
        }

        // c. Find all sources i.e., all vertices with 0 in-degree
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : vertexIndegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queu
        while (!sources.isEmpty()) {
            Integer poll = sources.poll();
            sortedOrder.add(poll);
            List<Integer> children = graph.get(poll);
            for (Integer child : children) {
                vertexIndegree.put(child, vertexIndegree.get(child) - 1);
                if (vertexIndegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (sortedOrder.size() != vertices) // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();

        return sortedOrder;
    }
}
