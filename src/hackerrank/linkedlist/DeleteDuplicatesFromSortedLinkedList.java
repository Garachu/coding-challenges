package hackerrank.linkedlist;

public class DeleteDuplicatesFromSortedLinkedList {

    public static void main(String args[]){
        // 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> null
        Node head = new Node(1);
        insertNodeAtHead(head, 2);
        insertNodeAtHead(head, 2);
        insertNodeAtHead(head, 3);
        insertNodeAtHead(head, 3);
        insertNodeAtHead(head, 3);
        insertNodeAtHead(head, 3);
        printLinkedList(head);
        System.out.println("Remove Duplicates");
        removeDuplicates(head);
        printLinkedList(head);
    }

    static Node insertNodeAtHead(Node head, int data){
        Node newNode = new Node(data);
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;

        return head;
    }

    static Node removeDuplicates(Node head){
        if(head == null) return null;
        Node currentNode = head;
        while (currentNode.next != null){
            if(currentNode.data == currentNode.next.data){
                currentNode.next = currentNode.next.next;
            }else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    static void printLinkedList(Node head){
        Node last = head;
        while(last != null){
            System.out.println(last.data);
            last = last.next;
        }
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
