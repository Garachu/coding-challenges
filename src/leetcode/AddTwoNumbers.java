package leetcode;

public class AddTwoNumbers {

    public static void main(String args[]) {

        ListNode l1Head = new ListNode(2);
        ListNode l1n1 = new ListNode(4);
        l1Head.next = l1n1;
        ListNode l1n2 = new ListNode(3);
        l1n1.next = l1n2;

        ListNode l2Head = new ListNode(5);
        ListNode l22n1 = new ListNode(6);
        l2Head.next = l22n1;
        ListNode l2n2 = new ListNode(4);
        l22n1.next = l2n2;

        ListNode node = addTwoNumbers(l1Head, l2Head);
        printList(node);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            int digit = sum % 10;
            ListNode node = new ListNode(digit);
            if (head == null) {
                last = node;
                head = last;
            } else {
                last.next = node;
                last = last.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            last.next = node;
        }
        return head;
    }

    // Method to print the LinkedList.
    private static void printList(ListNode currNode) {
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.val + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }
}


