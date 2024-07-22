package leetcode;

public class DeleteTheMiddleNodeOfALinkedList2095 {
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

    public ListNode deleteMiddle(ListNode head) {
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }

        node = head;
        ListNode befNode = null;
        int mid = cnt / 2;
        for (int i = 0; i < mid; i++) {
            befNode = node;
            node = node.next;
        }

        if (befNode != null) {
            befNode.next = node.next;
        } else {
            head = null;
        }

        return head;
    }
}
