package hackerrank.linkedlist;

public class CycleDetection {

    public static void main(String args[]) {
        Node head = new Node(1);

        Node node2 = new Node(2);
        head.next = node2;

        Node node3 = new Node(3);
        node2.next = node3;

        Node node4 = new Node(4);
        node3.next = node4;

        Node node5 = new Node(5);
        node4.next = node5;

        node5.next = node3;

        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    static Node insertNodeAtEnd(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            return node;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return head;
    }

    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
