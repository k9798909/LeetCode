package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 */
public class AddTwoNumbers2 {
	public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode node = null;
        int plus = 0;
        while (l1 != null || l2 != null) {
            int sum = plus;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            plus = sum / 10;

            if (node != null) {
                node.next = new ListNode(sum % 10);
                node = node.next;
            } else {
                firstNode = new ListNode(sum % 10);
                node = firstNode;
            }
        }

        if (plus > 0) {
            node.next = new ListNode(plus);
        }

        return firstNode;
    }

	public static void main(String[] args) {
		ListNode l7 = new ListNode(9);
		ListNode l6 = new ListNode(9, l7);
		ListNode l5 = new ListNode(9, l6);
		ListNode l4 = new ListNode(9, l5);
		ListNode l3 = new ListNode(9, l4);
		ListNode l2 = new ListNode(9, l3);
		ListNode l1 = new ListNode(9, l2);

		ListNode l11 = new ListNode(9);
		ListNode l10 = new ListNode(9, l11);
		ListNode l9 = new ListNode(9, l10);
		ListNode l8 = new ListNode(9, l9);

	}
}
