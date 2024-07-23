package leetcode;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices,
 * <p>
 * and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should
 * remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 *
 */
public class OddEvenLinkedList328 {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode node = evenNode.next;
        ListNode evenHeadNode = evenNode;
        boolean isOdd = true;

        while (node != null) {
            if (isOdd) {
                oddNode.next = node;
                oddNode = oddNode.next;
            } else {
                evenNode.next = node;
                evenNode = evenNode.next;
            }
            node = node.next;
            isOdd = !isOdd;
        }

        oddNode.next = evenHeadNode;
        evenNode.next = null;
        return head;
    }
}
