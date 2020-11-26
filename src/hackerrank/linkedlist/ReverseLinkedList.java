package hackerrank.linkedlist;

public class ReverseLinkedList {

    public static void main(String args[]) {

        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
        node1.next = node2;
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3);
        node2.next = node3;

        printLinkedList(node1);

        SinglyLinkedListNode head = reverseLinkedList(node1);
        printLinkedList(head);

    }

    static SinglyLinkedListNode reverseLinkedList(SinglyLinkedListNode head) {
        if (head == null) return null;

        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = head;

        while (next != null) {
            current = next;
            next = current.next;
            current.next = previous;
            previous = current;
        }

        return current;
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        if (head == null) return;
        System.out.println();
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next;
        }
        System.out.println();
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

    }
}
