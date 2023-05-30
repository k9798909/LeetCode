package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

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

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
		ForkJoinPool customThreadPool = new ForkJoinPool(10);
		customThreadPool.execute(() ->
				list.parallelStream().forEach(t -> {
					set.add(Thread.currentThread().getName());
					for (int i = 0; i < 10000000; i++) {
					}
					System.out.println(t);
				})
		);
		customThreadPool.shutdown();
		if (!customThreadPool.awaitTermination(1, TimeUnit.SECONDS)) {
			throw new RuntimeException("執行緒超時");
		}
		for (String name : set) {
			System.out.println(name);
		}
	}

}
