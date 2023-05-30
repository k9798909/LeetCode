package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList1721 {
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

	public ListNode swapNodes(ListNode head, int k) {
		List<ListNode> list = new ArrayList<>();
		ListNode node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		
		ListNode firstNode = list.get(k - 1);
		ListNode lastNode = list.get(list.size() - k);
		int tempVal = firstNode.val;
		firstNode.val = lastNode.val;
		lastNode.val = tempVal;
		return head;
	}
}
