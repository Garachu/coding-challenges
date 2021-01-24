package educative.topologicalsort;

import java.util.*;

/**
 * Problem Statement #
 * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be completed before it can be scheduled.
 * Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
 */
public class B_TaskScheduling {

    public static void main(String args[]) {

        // Example 1:
        // Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
        // Output: true
        // Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs to finish before '2' can be scheduled. A possible sceduling of tasks is: [0, 1, 2]
        boolean result = isSchedulingPossible(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println("Tasks execution possible: " + result);

        // Example 2:
        // Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
        // Output: false
        // Explanation: The tasks have cyclic dependency, therefore they cannot be sceduled.
        result = isSchedulingPossible(3,
                new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println("Tasks execution possible: " + result);


        // Example 3:
        // Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
        // Output: true
        // Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]
        result = isSchedulingPossible(6, new int[][]{new int[]{2, 5}, new int[]{0, 5},
                new int[]{0, 4}, new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println("Tasks execution possible: " + result);
    }

    static boolean isSchedulingPossible(int num, int[][] tasks) {
        List<Integer> sortedOrder = new ArrayList<>();

        // a. Initialize the graph
        HashMap<Integer, Integer> vertexIndegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < num; i++) {
            vertexIndegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // b. Build the graph
        for (int i = 0; i < tasks.length; i++) {
            int parent = tasks[i][0];
            int child = tasks[i][1];

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

        if (sortedOrder.size() != num - 1) // topological sort is not possible as the graph has a cycle
            return false;

        return true;
    }
}
