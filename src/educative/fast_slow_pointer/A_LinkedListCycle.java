package educative.fast_slow_pointer;

/**
 * Problem Statement #
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * <p>
 * Solution #
 * Imagine two racers running in a circular racing track. If one racer is faster than the other, the faster racer is bound to catch up and cross the slower racer from behind. We can use this fact to devise an algorithm to determine if a LinkedList has a cycle in it or not.
 * <p>
 * Imagine we have a slow and a fast pointer to traverse the LinkedList. In each iteration, the slow pointer moves one step and the fast pointer moves two steps. This gives us two conclusions:
 * <p>
 * If the LinkedList doesn’t have a cycle in it, the fast pointer will reach the end of the LinkedList before the slow pointer to reveal that there is no cycle in the LinkedList.
 * The slow pointer will never be able to catch up to the fast pointer if there is no cycle in the LinkedList.
 * If the LinkedList has a cycle, the fast pointer enters the cycle first, followed by the slow pointer.
 * After this, both pointers will keep moving in the cycle infinitely. If at any stage both of these pointers meet, we can conclude that the LinkedList has a cycle in it. Let’s analyze if it is possible for the two pointers to meet.
 * When the fast pointer is approaching the slow pointer from behind we have two possibilities:
 * <p>
 * The fast pointer is one step behind the slow pointer.
 * The fast pointer is two steps behind the slow pointer.
 * All other distances between the fast and slow pointers will reduce to one of these two possibilities. Let’s analyze these scenarios, considering the fast pointer always moves first:
 * <p>
 * If the fast pointer is one step behind the slow pointer: The fast pointer moves two steps and the slow pointer moves one step, and they both meet.
 * If the fast pointer is two steps behind the slow pointer: The fast pointer moves two steps and the slow pointer moves one step. After the moves, the fast pointer will be one step behind the slow pointer, which reduces this scenario to the first scenario. This means that the two pointers will meet in the next iteration.
 * This concludes that the two pointers will definitely meet if the LinkedList has a cycle. A similar analysis can be done where the slow pointer moves first. Here is a visual representation of the above discussion:
 */
public class A_LinkedListCycle {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;

        System.out.println("------ checkout");
        System.out.println("------ head.next.next: " + head.next.next.value);
        System.out.println("------" + hasCycle(head));
    }

    /**
     * Time Complexity #
     * As we have concluded above, once the slow pointer enters the cycle,
     * the fast pointer will meet the slow pointer in the same loop. Therefore, the time complexity of our algorithm will be O(N)O(N) where ‘N’ is the total number of nodes in the LinkedList.
     * <p>
     * Space Complexity #
     * The algorithm runs in constant space O(1)O(1).
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
