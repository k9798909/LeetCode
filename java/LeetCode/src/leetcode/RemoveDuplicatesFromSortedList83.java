package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList83 {
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

    public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode node = head;
		ListNode nextNode = head.next;
		int val = node.val;
		while (nextNode != null) {
			if (val == nextNode.val) {
				node.next = nextNode.next;
			} else {
				val = nextNode.val;
				node = nextNode;
			}
			nextNode = node.next;
		}

		return head;
    }
}
