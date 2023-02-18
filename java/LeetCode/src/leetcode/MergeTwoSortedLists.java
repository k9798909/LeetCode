package leetcode;

public class MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}

		if (list1 == null) {
			return list2;
		}

		if (list2 == null) {
			return list1;
		}

		var list = new ListNode();
		var next = list;
		while (list1 != null || list2 != null) {
			if (list2 == null || (list1 != null && list1.val <= list2.val)) {
				next.val = list1.val;
				list1 = list1.next;
			} else if (list1 == null || (list2 != null && list2.val < list1.val)) {
				next.val = list2.val;
				list2 = list2.next;
			}

			if (list1 != null || list2 != null) {
				next.next = new ListNode();
				next = next.next;
			}
		}

		return list;
	}

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

	public static void main(String[] args) {
	}
}
