package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList143 {
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

	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}

		List<ListNode> list = new ArrayList<>();
		ListNode node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}

		node = list.get(0);
		int first = 1;
		int last = list.size() - 1;
		while (first <= last) {
			ListNode firstNode = list.get(last);
			ListNode lastNode = list.get(first);
			node.next = firstNode;
			firstNode.next = lastNode;
			node = lastNode;
			first++;
			last--;
		}

		if (node != null) {
			node.next = null;
		}

	}
}
