package leetcode;

/**
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the
 * linked list is known as the twin of the (n-1-i)th node,
 * <p>
 * if 0 <= i <= (n / 2) - 1.
 * <p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the
 * twin of node 2. These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * <p>
 * Given the head of a linked list with even length, return the maximum twin sum
 * of the linked list.
 *
 */
public class MaximumTwinSumOfALinkedList2130 {
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

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode reverseNode = null;

        while (fast != null && fast.next != null) {
            reverseNode = new ListNode(slow.val, reverseNode);
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxSum = 0;
        while (slow != null) {
            maxSum = Math.max(maxSum, slow.val + reverseNode.val);
            reverseNode = reverseNode.next;
            slow = slow.next;
        }

        return maxSum;
    }
}
