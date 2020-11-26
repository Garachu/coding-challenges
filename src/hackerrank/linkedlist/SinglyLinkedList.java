package hackerrank.linkedlist;

public class SinglyLinkedList {

    Node head; // head of list

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        printList(list);

        insertAtEnd(list, "Francis");
        insertAtEnd(list, "Joel");
        insertAtEnd(list, "Ana");
        printList(list);

        // Insert Node in the middle of the list
        //insertAtPosition(list, "Meg", 2);
        insertAtPosition(list.head, "Meg", 1);
        printList(list);

        // Insert Node in the beginning of the list
        Node headNode = insertAtPosition(list.head, "Kigaita", 0);
        list.head = headNode;
        printList(headNode);

        // Insert Node in position that does not exist
        headNode = insertAtPosition(list.head, "Mary", 9);
        printList(headNode);
    }

    // Method to insert a new node
    private static SinglyLinkedList insertAtEnd(SinglyLinkedList list, String data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        return list;
    }

    // Method to insert a new node
    private static SinglyLinkedList insertAtPosition(SinglyLinkedList list, String data, int position) {
        Node newNode = new Node(data);
        Node trackingNode = list.head;

        if (trackingNode == null) {
            trackingNode = newNode;
            return list;
        } else {
            int currentPosition = 1;
            while (currentPosition < position - 1 && trackingNode.next != null) {
                trackingNode = trackingNode.next;
                currentPosition++;
            }
        }

        Node nodeAtPosition = trackingNode.next;
        trackingNode.next = newNode;
        newNode.next = nodeAtPosition;
        return list;
    }

    /**
     * You’re given the pointer to the head node of a linked list, an integer to add to the list and the position at which the integer must be inserted.
     * Create a new node with the given integer, insert this node at the desired position and return the head node.
     * A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. The head pointer given may be null meaning that the initial list is empty.
     *
     * @param head     : a Node pointer to the head of the list
     * @param data     : a String value to insert as data in your new node
     * @param position : an integer position to insert the new node, zero based indexing
     * @return reference to the head node of your finished list.
     */
    private static Node insertAtPosition(Node head, String data, int position) {
        Node newNode = new Node(data);
        Node trackingNode = head;

        // A position of 0 indicates head,
        if (position == 0) {
            if (head == null) {
                return newNode;
            } else {
                newNode.next = head;
                return newNode;
            }
        } else {

            int currentPosition = 0;
            while (currentPosition < position - 1 && trackingNode.next != null) {
                trackingNode = trackingNode.next;
                currentPosition++;
            }

            Node nodeAtPosition = trackingNode.next;
            trackingNode.next = newNode;
            newNode.next = nodeAtPosition;
            return head;
        }

    }

    // Method to print the LinkedList.
    private static void printList(SinglyLinkedList list) {
        Node currNode = list.head;
        System.out.print("\nLinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    // Method to print the LinkedList.
    private static void printList(Node head) {
        Node currNode = head;
        System.out.print("\nLinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    static class Node {

        String data;
        Node next;

        public Node() {

        }

        public Node(String data) {
            this.data = data;
        }

    }
}
