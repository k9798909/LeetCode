package leetcode;

public class MergeKSortedLists23 {
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

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		
		ListNode listNode = lists[0];
		int i = 1;
		while (i < lists.length) {
			if (listNode == null) {
				listNode = lists[i++];
				continue;
			}
			
			ListNode beforeListNode1 = null;
			ListNode listNode1 = listNode;
			ListNode listNode2 = lists[i++];
			while (listNode2 != null) {
				if (listNode1 == null) {
					beforeListNode1.next = listNode2;
					break;
				}
				if (listNode1.val >= listNode2.val) {
					ListNode tempNode = listNode2.next;
					listNode2.next = listNode1;
					if (beforeListNode1 != null) {
						beforeListNode1.next = listNode2;
					} else {
						listNode = listNode2;
					}
					listNode1 = listNode2;
					listNode2 = tempNode;
				} else if (listNode1.val < listNode2.val){
					beforeListNode1 = listNode1;
					listNode1 = listNode1.next;
				}
			}
		}
		return listNode;
	}
}
