package leetcode;

public class RemoveLinkedListElements203 {
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

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}

		ListNode node = head;
		ListNode latelyNode = null;
		while (node != null) {
			if (latelyNode == null && node.val == val) {
				head = node.next;
			} else if (node.val == val) {
				latelyNode.next = node.next;
			} else {
				latelyNode = node;
			}
			node = node.next;
		}
		return head;
	}
}
