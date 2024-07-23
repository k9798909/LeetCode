package leetcode;

public class ReverseLinkedList206 {

    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode befNode = head;
        ListNode afterNode = head.next;
        befNode.next = null;
        ListNode tempNode;
        while (afterNode != null) {
            tempNode = afterNode.next;
            afterNode.next = befNode;
            befNode = afterNode;
            afterNode = tempNode;
        }
        return befNode;
    }

}
