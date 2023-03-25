package leetcode;

public class RemoveNthNodeFrom {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode last = head;
		int length = 1;
		while (last.next != null) {
			last = last.next;
			length++;
		}
		
		ListNode remove = head;
		ListNode bef = null;
		for (int i = 0; i < length - n; i++) {
			bef = remove;
			remove = remove.next;
		}
		
		if (bef == null) {
			return head.next != null ? head.next : null;
		} else if (remove == null) {
			bef.next = null;
		} else {
			bef.next = remove.next;
		}
		
		return head;
	}
}
