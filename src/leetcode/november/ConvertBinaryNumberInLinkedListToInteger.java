package leetcode.november;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 * <p>
 * Example 1:
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * <p>
 * Example 2:
 * Input: head = [0]
 * Output: 0
 * <p>
 * Example 3:
 * Input: head = [1]
 * Output: 1
 * <p>
 * Example 4:
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * <p>
 * Example 5:
 * Input: head = [0,0]
 * Output: 0
 */
public class ConvertBinaryNumberInLinkedListToInteger {

    public static void main(String args[]) {
        ListNode root = new ListNode(1);

        ListNode next1 = new ListNode(0);
        root.next = next1;

        ListNode next2 = new ListNode(1);
        next1.next = next2;

        System.out.println("Decimal: " + getDecimalValue(root));
    }

    static int getDecimalValue(ListNode head) {
        if (head == null) return 0;

        // find length of linked list
        ListNode current = head;
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }

        // find decimal representation of linked list
        current = head;
        double decimal = 0;
        len = len - 1;
        while (current != null) {
            decimal = decimal + Math.pow(2, len) * current.val;
            current = current.next;
            len--;
        }
        return (int) decimal;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }


        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
