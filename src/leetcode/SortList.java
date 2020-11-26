package leetcode;

import java.util.Arrays;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 */
public class SortList {

    public static void main(String args[]) {
        ListNode head = new ListNode(4);
        ListNode headNext = new ListNode(2);
        head.next = headNext;
        ListNode headNextNext = new ListNode(1);
        headNext.next = headNextNext;
        ListNode headNextNextNext = new ListNode(3);
        headNextNext.next = headNextNextNext;
        ListNode listNode = sortList(head);
        printNodes(listNode);
    }

    static ListNode sortList(ListNode head) {
        if (head == null) return head;
        int len = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            len++;
        }
        int[] arr = new int[len];
        current = head;
        for (int i = 0; i < len; i++) {
            System.out.println("data: " + i + "\t" + current.data);
            arr[i] = current.data;
            current = current.next;
        }
        Arrays.sort(arr);
        head = new ListNode(arr[0]);
        current = head;
        for (int i = 1; i < len; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    static void printNodes(ListNode head) {
        if (head == null) return;
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
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
