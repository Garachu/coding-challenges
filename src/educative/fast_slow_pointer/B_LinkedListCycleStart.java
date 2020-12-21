package educative.fast_slow_pointer;

/**
 * Problem Statement #
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */
public class B_LinkedListCycleStart {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;

        ListNode cycleNodeStart = findCycleStart(head);
        System.out.println(cycleNodeStart.value);
    }

    /**
     * Time Complexity #
     * As we know, finding the cycle in a LinkedList with ‘N’ nodes and also finding the length of the cycle requires O(N)O(N). Also, as we saw in the above algorithm, we will need O(N)O(N) to find the start of the cycle. Therefore, the overall time complexity of our algorithm will be O(N)O(N).
     * <p>
     * Space Complexity #
     * The algorithm runs in constant space O(1)O(1).
     */
    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int cycleLength = findCycleLength(slow);
                System.out.println("------ Len: " + cycleLength);
                return findStart(cycleLength, head);
            }
        }
        return head;
    }

    public static ListNode findStart(int cycleLength, ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (cycleLength > 0) {
            cycleLength--;
            pointer2 = pointer2.next;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2;
    }

    public static int findCycleLength(ListNode slow) {
        int cycleLength = 0;
        ListNode n = slow;
        do {
            cycleLength++;
            n = n.next;
        } while (n != slow);
        return cycleLength;
    }

    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
