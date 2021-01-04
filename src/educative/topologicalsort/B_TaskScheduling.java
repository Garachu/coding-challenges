package educative.topologicalsort;

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
        return true;
    }
}
