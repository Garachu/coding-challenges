package hackerrank;

public class FindMergePointOfTwoLists {

    public static void main(String args[]) {
        SinglyLinkedListNode l1Node1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode l1Node2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode l1Node3 = new SinglyLinkedListNode(3);
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        // printList(l1Node1);

        SinglyLinkedListNode l2Node1 = new SinglyLinkedListNode(1);
        l2Node1.next = l1Node3;
        //printList(l2Node1);

        int mergeNode = findMergeNode(l1Node1, l2Node1);
        System.out.println(mergeNode);
        //printList(l1Node1);

//        int mergeNode = findMergeNode(l1Node1, l2Node1);
        //System.out.println(mergeNode);
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode tail = head1;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head2;

        SinglyLinkedListNode slow = head2;
        SinglyLinkedListNode fast = head2.next;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        tail.next = null;
        return slow.data;
    }

    static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode tmp = head;
        System.out.println("\n------ Start Print Nodes");
        while (tmp != null) {
            System.err.print(tmp.data);
            tmp = tmp.next;
        }
        System.out.println("\n------ End Print Nodes");
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }
}
