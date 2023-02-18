package leetcode;

public class SwapNodesInPairs {

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
	
	public static ListNode swapPairs(ListNode head) {
		//前一個資料
		ListNode lastNode = null;
		//當前資料
		ListNode node = head;
		while (node != null && node.next != null) {
			ListNode node1 = node;
			ListNode node2 = node.next;
			ListNode node2Next = node2.next;
			
			//前一個資料沒有代表是第一個。如果有將前一個資料的節點接上node2
			if (lastNode == null) {
				head = node2;
			} else {
				lastNode.next = node2;
			}
			
			//開始交換，資料2的下一個節點接上資料一，資料1的下一個節點接上資料2的下一個節點。
			node2.next = node1;
			node1.next = node2Next;
			//node1 變為前一次資料，當前要處理資料改成資料2的下一個資料
			lastNode = node1;
			node = node2Next;
		}
		return head;
	}

}
