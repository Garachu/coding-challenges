package leetcode;

public class RotateList {

    public static void main(String args[]) {
        ListNode head = insertAtEnd(null, 1);
        insertAtEnd(head, 2);
        insertAtEnd(head, 3);
        insertAtEnd(head, 4);
        insertAtEnd(head, 5);
//        System.out.println("\nBefore Rotation");
//        printNodes(head);
//        System.out.println("\nAfter Rotation");
//        printNodes(rotateRight(head, 2));

        printNodes(rotateRight(head, 2));


    }

    private static ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        if (head == null && k == 0) return head;

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        len = len + 1;
        int rotations = len - k % len;
        tail.next = head;

        while (rotations > 0){
            rotations--;
            tail= tail.next;
        }

        ListNode tempTail = tail;
        head = tail.next;
        tempTail.next = null;
        return head;
    }

    static ListNode rotateRight1(ListNode head, int k) {
        if (head == null) return head;
        while (k > 0) {
            head = rotate(head);
            k--;
        }
        return head;
    }

    static ListNode rotate(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        if (current == null) return head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        current.next = head;
        return current;
    }


    static ListNode insertAtEnd(ListNode head, int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            return node;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return head;
    }

    static void printNodes(ListNode head) {
        if (head == null) return;
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next;
        }
    }

    static class ListNode {
        int data;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int data) {
            this.data = data;
        }

    }

}
