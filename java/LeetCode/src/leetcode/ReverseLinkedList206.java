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
		ListNode oldNode = head;
		ListNode newNode = null;
		while (oldNode != null) {
			ListNode node = new ListNode(oldNode.val,newNode);
			oldNode = oldNode.next;
			newNode = node;
		}
		return newNode;
	}

}
