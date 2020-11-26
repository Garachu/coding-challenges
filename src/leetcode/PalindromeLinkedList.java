package leetcode;

public class PalindromeLinkedList {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode headNext = new ListNode(2);
        head.next = headNext;
        ListNode headNextNext = new ListNode(2);
        headNext.next = headNextNext;
        ListNode headNextNextNext = new ListNode(1);
        headNextNext.next = headNextNextNext;
        System.out.println(isPalindrome(head));

//        ListNode head = new ListNode(1);
//        ListNode headNext = new ListNode(2);
//        head.next = headNext;
//        System.out.println(isPalindrome(head));
    }


    static ListNode check = null;
    static boolean flag = true;

    static boolean isPalindrome(ListNode head) {
        check = head;
        return checkCheck(head);

    }

    static boolean checkCheck(ListNode head) {
        if (head == null) return true;
        checkCheck(head.next);
        ListNode temp = check;
        check = check.next;
        flag = flag && (temp.val == head.val);
        return flag;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
