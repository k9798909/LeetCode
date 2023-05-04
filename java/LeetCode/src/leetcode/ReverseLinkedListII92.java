package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII92 {
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

	// left <= right
	public ListNode reverseBetween(ListNode head, int left, int right) {
		List<ListNode> list = new ArrayList<>();
		ListNode node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		for (int i = left - 1, j = right - 1; i < j; i++, j--) {
			ListNode leftNode = list.get(i);
			ListNode rightNode = list.get(j);
			list.set(i, rightNode);
			list.set(j, leftNode);
		}
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).next = list.get(i + 1);
		}
		list.get(list.size() - 1).next = null;
		return list.get(0);
	}
}
