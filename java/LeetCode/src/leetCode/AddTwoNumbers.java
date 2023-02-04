package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumbers {
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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Queue<Integer> queue = new LinkedList<>();
		while(l1 !=null) {
			queue.offer(l1.val + (l2 != null ? l2.val : 0));
			l1 = l1.next;
			l2 = l2 != null ? l2.next : null;
		}
		
		while(l2 != null) {
			queue.offer(l2.val);
			l2 = l2.next;
		}
		
		int add = 0;
		while(!queue.isEmpty()) {
			int val = queue.poll() + add;
			add = 0;
			if(val >= 10) {
				add = val / 10;
				val = val % 10;
			}
			if(l1 != null) {
				l1.next = new ListNode(val);
				l1 = l1.next;
			} else {
				l1 = new ListNode(val);
				l2 = l1;
			}
			
			if(queue.isEmpty() && add != 0) {
				l1.next = new ListNode(add);
				l1 = l1.next;
			}
		}
		return l2;
	}

	public static void main(String[] args) {
		ListNode l7 = new ListNode(9);
		ListNode l6 = new ListNode(9, l7);
		ListNode l5 = new ListNode(9, l6);
		ListNode l4 = new ListNode(9, l5);
		ListNode l3 = new ListNode(9, l4);
		ListNode l2 = new ListNode(9, l3);
		ListNode l1 = new ListNode(9, l2);

		
		ListNode l11 = new ListNode(9);
		ListNode l10 = new ListNode(9, l11);
		ListNode l9 = new ListNode(9, l10);
		ListNode l8 = new ListNode(9, l9);

		addTwoNumbers(l1, l8);

	}
}
